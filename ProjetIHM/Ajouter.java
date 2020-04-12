import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ajouter extends JFrame implements ActionListener {
    private JPanel monPanel;
    private AppMenagerie appMenagerie;
    private JButton valider, retour;
    private JTextField nom, espece;
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

        retour.setBackground(new Color(59, 89, 182));
        retour.setForeground(Color.WHITE);
        retour.setFocusPainted(false);
        retour.setFont(new Font("Arial", Font.BOLD, 12));
        retour.setBounds(220, 150, 200, 40);
        retour.addActionListener(this);

        JLabel lblNom = new JLabel("Nom de l'animal");
        lblNom.setFont(new Font("Arial", Font.BOLD, 14));
        lblNom.setBounds(50, 50, 200, 40);

        JLabel lblEspece = new JLabel("Espèce de l'animal");
        lblEspece.setFont(new Font("Arial", Font.BOLD, 14));
        lblEspece.setBounds(300, 50, 200, 40);

        nom.setBounds(50, 100, 200, 40);

        espece.setBounds(300, 100, 200, 40);

        valider.setBackground(new Color(59, 89, 182));
        valider.setForeground(Color.WHITE);
        valider.setFocusPainted(false);
        valider.setFont(new Font("Arial", Font.BOLD, 12));
        valider.setBounds(200, 150, 200, 40);
        valider.addActionListener(this);

        retour.setBounds(10, 10, 200, 40);
        retour.addActionListener(this);

        monPanel.add(lblNom);
        monPanel.add(lblEspece);
        monPanel.add(nom);
        monPanel.add(espece);
        monPanel.add(valider);
        monPanel.add(retour);
    }

    public JPanel getJPanel() {
        return this.monPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == valider) {
            String nomAnimal = nom.getText();
            String especeAnimal = espece.getText();
            this.appMenagerie.ajouterAnimal(nomAnimal, especeAnimal);
        } else if (source == retour) {
            this.appMenagerie.retour();
        }
    }
}