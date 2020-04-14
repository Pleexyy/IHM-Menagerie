import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Rechercher extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton retour, rechercher;
    private JLabel label, lblNom;
    private JTextField nom;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Rechercher(AppMenagerie appMenagerie, ArrayList<Animal> lesAnimaux) {
        this.appMenagerie = appMenagerie;
        monPanel = new JPanel();
        monPanel.setLayout(null);
        monPanel.setBackground(Color.white);

        retour = new JButton("retour");
        retour.setBackground(new Color(59, 89, 182));
        retour.setForeground(Color.WHITE);
        retour.setFocusPainted(false);
        retour.setFont(new Font("Arial", Font.BOLD, 12));
        retour.setBounds(10, 10, 200, 40);
        retour.addActionListener(this);

        if (!lesAnimaux.isEmpty()) {
            lblNom = new JLabel("Nom de l'animal à rechercher");
            lblNom.setFont(new Font("Arial", Font.BOLD, 14));
            lblNom.setBounds(325, 150, 250, 40);
            nom = new JTextField();
            nom.setBounds(340, 200, 200, 40);

            rechercher = new JButton("rechercher");
            rechercher.setBounds(340, 250, 200, 40);
            rechercher.setBackground(new Color(59, 89, 182));
            rechercher.setForeground(Color.WHITE);
            rechercher.setFocusPainted(false);
            rechercher.setFont(new Font("Arial", Font.BOLD, 12));
            rechercher.addActionListener(this);

            monPanel.add(lblNom);
            monPanel.add(nom);
            monPanel.add(rechercher);
        } else {
            label = new JLabel();
            label.setText("La ménagerie ne contient aucun animaux...");
            label.setBounds(300, 180, 350, 40);
            monPanel.add(label);
        }
        monPanel.add(retour);
    }

    public JPanel getJPanel() {
        return this.monPanel;
    }

    private void displayGui(String lbl, int x) {
        label = new JLabel();
        label.setText(lbl);
        label.setBounds(x, 170, 350, 40);
        System.out.println(lbl);
        lblNom = new JLabel("Nom de l'animal à rechercher");
        lblNom.setFont(new Font("Arial", Font.BOLD, 14));
        lblNom.setBounds(325, 150, 250, 40);
        nom = new JTextField();
        nom.setBounds(340, 200, 200, 40);

        rechercher = new JButton("rechercher");
        rechercher.setBounds(340, 250, 200, 40);
        rechercher.setBackground(new Color(59, 89, 182));
        rechercher.setForeground(Color.WHITE);
        rechercher.setFocusPainted(false);
        rechercher.setFont(new Font("Arial", Font.BOLD, 12));
        rechercher.addActionListener(this);

        monPanel.removeAll();
        monPanel.add(lblNom);
        monPanel.add(nom);
        monPanel.add(rechercher);
        monPanel.add(label);
        monPanel.add(retour);
        monPanel.revalidate();
        monPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == retour) {
            System.out.println("retour");
            this.appMenagerie.retour();
        } else if (source == rechercher) {
            String nomAnimal = nom.getText();
            this.appMenagerie.rechercherAnimal(nomAnimal);
            if (this.appMenagerie.rechercherAnimal(nomAnimal) == true) {
                displayGui("Animal trouvé !", 390);
            } else {
                displayGui("Cet animal n'est pas dans la ménagerie...", 290);
            }
        }
    }
}
