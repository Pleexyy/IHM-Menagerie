import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Accueil implements ActionListener {
    private JPanel monPanel;
    private JButton ajouter;
    private JButton supprimer;
    private JButton rechercher;
    private JButton afficher;
    private JButton compter;
    private JButton quitter;
    private JLabel lblMenagerie;
    private JLabel lblAction;
    private AppMenagerie appMenagerie;

    public Accueil(AppMenagerie appMenagerie) {
        this.appMenagerie = appMenagerie;

        monPanel = new JPanel();
        monPanel.setBackground(Color.white);
        monPanel.setLayout(null);

        lblMenagerie = new JLabel("Bienvenue dans votre ménagerie !");
        lblMenagerie.setFont(new Font("Arial", Font.BOLD, 18));
        lblMenagerie.setBounds(280, 0, 400, 50);

        lblAction = new JLabel("Que souhaitez-vous faire ?");
        lblAction.setFont(new Font("Arial", Font.BOLD, 15));
        lblAction.setBounds(340, 10, 400, 120);

        ajouter = new JButton("Ajouter un animal");
        ajouter.setBackground(new Color(59, 89, 182));
        ajouter.setForeground(Color.WHITE);
        ajouter.setFocusPainted(false);
        ajouter.setFont(new Font("Arial", Font.BOLD, 12));
        ajouter.setBounds(220, 150, 200, 40);
        ajouter.addActionListener(this);

        supprimer = new JButton("Supprimer un animal");
        supprimer.setBackground(new Color(59, 89, 182));
        supprimer.setForeground(Color.WHITE);
        supprimer.setFocusPainted(false);
        supprimer.setFont(new Font("Arial", Font.BOLD, 12));
        supprimer.setBounds(475, 150, 200, 40);
        supprimer.addActionListener(this);

        rechercher = new JButton("Rechercher un animal");
        rechercher.setBackground(new Color(59, 89, 182));
        rechercher.setForeground(Color.WHITE);
        rechercher.setFocusPainted(false);
        rechercher.setFont(new Font("Arial", Font.BOLD, 12));
        rechercher.setBounds(220, 225, 200, 40);
        rechercher.addActionListener(this);

        afficher = new JButton("Animaux présents");
        afficher.setBackground(new Color(59, 89, 182));
        afficher.setForeground(Color.WHITE);
        afficher.setFocusPainted(false);
        afficher.setFont(new Font("Arial", Font.BOLD, 12));
        afficher.setBounds(475, 225, 200, 40);
        afficher.addActionListener(this);

        compter = new JButton("Nombre d'animaux");
        compter.setBackground(new Color(59, 89, 182));
        compter.setForeground(Color.WHITE);
        compter.setFocusPainted(false);
        compter.setFont(new Font("Arial", Font.BOLD, 12));
        compter.setBounds(350, 300, 200, 40);
        compter.addActionListener(this);

        quitter = new JButton("Quitter");
        quitter.setBackground(new Color(59, 89, 182));
        quitter.setForeground(Color.WHITE);
        quitter.setFocusPainted(false);
        quitter.setFont(new Font("Arial", Font.BOLD, 12));
        quitter.setBounds(800, 402, 100, 40);
        quitter.addActionListener(this);

        monPanel.add(lblMenagerie);
        monPanel.add(lblAction);
        monPanel.add(ajouter);
        monPanel.add(supprimer);
        monPanel.add(rechercher);
        monPanel.add(afficher);
        monPanel.add(compter);
        monPanel.add(quitter);
    }

    public JPanel getJPanel() {
        return this.monPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == ajouter) {
            this.appMenagerie.afficherAjouter();
        } else if (source == afficher) {
            this.appMenagerie.afficher();
        } else if (source == supprimer) {
            this.appMenagerie.afficherSupprimer();
        } else if (source == rechercher) {
            this.appMenagerie.afficherRechercher();
        } else if (source == compter) {
            this.appMenagerie.afficherCompter();
        } else {
            this.appMenagerie.dispose();
            System.exit(0);
        }
    }
}