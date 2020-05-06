import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

public class Ajouter extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton valider, retour;
    private JTextField nom, espece;
    private JComboBox<String> box;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Ajouter(AppMenagerie appMenagerie) {
        this.appMenagerie = appMenagerie;

        monPanel = new JPanel();
        valider = new JButton("ajouter");
        retour = new JButton("retour");
        nom = new JTextField();
        espece = new JTextField();

        monPanel.setLayout(null);
        monPanel.setBackground(Color.white);

        retour.setBackground(new Color(59, 89, 182));
        retour.setForeground(Color.WHITE);
        retour.setFocusPainted(false);
        retour.setFont(new Font("Arial", Font.BOLD, 12));
        retour.setBounds(220, 150, 200, 40);
        retour.addActionListener(this);

        JLabel lblNom = new JLabel("Nom de l'animal");
        lblNom.setFont(new Font("Arial", Font.BOLD, 14));
        lblNom.setBounds(225, 150, 200, 40);
        nom.setBounds(225, 200, 200, 40);

        // JLabel lblEspece = new JLabel("Espèce de l'animal");
        // lblEspece.setFont(new Font("Arial", Font.BOLD, 14));
        // lblEspece.setBounds(475, 150, 200, 40);
        // espece.setBounds(475, 200, 200, 40);

        String s1[] = { "Vertebres", "Mollusques", "Arthropodes" };
        box = new JComboBox<>(s1);
        box.addActionListener(this);
        box.setBounds(480, 200, 200, 40);

        valider.setBackground(new Color(59, 89, 182));
        valider.setForeground(Color.WHITE);
        valider.setFocusPainted(false);
        valider.setFont(new Font("Arial", Font.BOLD, 12));
        valider.setBounds(360, 275, 200, 40);
        valider.addActionListener(this);
        valider.setEnabled(false);

        retour.setBounds(10, 10, 200, 40);
        retour.addActionListener(this);

        monPanel.add(lblNom);
        // monPanel.add(lblEspece);
        monPanel.add(nom);
        monPanel.add(espece);
        monPanel.add(valider);
        monPanel.add(retour);
        monPanel.add(box);

        nom.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                change();
            }

            public void removeUpdate(DocumentEvent e) {
                change();
            }

            public void insertUpdate(DocumentEvent e) {
                change();
            }

            public void change() {
                if (!nom.getText().isEmpty()) {
                    valider.setEnabled(true);
                }
            }
        });

        // espece.getDocument().addDocumentListener(new DocumentListener() {
        // public void changedUpdate(DocumentEvent e) {
        // change();
        // }

        // public void removeUpdate(DocumentEvent e) {
        // change();
        // }

        // public void insertUpdate(DocumentEvent e) {
        // change();
        // }

        // public void change() {
        // if (!espece.getText().isEmpty() && (!nom.getText().isEmpty())) {
        // valider.setEnabled(true);
        // }
        // }
        // });

    }

    public JPanel getJPanel() {
        return this.monPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        
        System.out.println("Selected  = " + box.getSelectedItem());

        if (box.getSelectedIndex() == 0) {
            System.out.println("Vertebres");
        } else if (box.getSelectedIndex() == 1) {
            System.out.println("Mollusques");
        } else {
            System.out.println("Arthropodes");
        }

        if (source == valider) {
            String nomAnimal = nom.getText().toLowerCase();
            String especeAnimal = String.valueOf(box.getSelectedItem());
            this.appMenagerie.ajouterAnimal(nomAnimal, especeAnimal);
        } else if (source == retour) {
            this.appMenagerie.retour();
        }
    }
}