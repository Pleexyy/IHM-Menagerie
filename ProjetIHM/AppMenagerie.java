import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppMenagerie extends JFrame implements ActionListener {
    /**
     *
     */
    private JFrame frame;
    private Menagerie menagerie;
    private static final long serialVersionUID = 1L;

    public AppMenagerie() {
        menagerie = new Menagerie();
        frame = new JFrame("IHM - Ménagerie");
        frame.setSize(900, 500);
        frame.setResizable(false);
        
        Accueil accueil = new Accueil(this);
        JPanel panelAccueil = accueil.getJPanel();
        
        frame.getContentPane().add(panelAccueil);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("act");
        System.out.println(e.getSource().toString());
    }

    public void afficherAjouter () {
        Ajouter ajouter = new Ajouter(this);
        JPanel panelAjouter = ajouter.getJPanel();
        this.refreshPanel(panelAjouter);
    }

    public void retour() {
        Accueil accueil = new Accueil(this);
        JPanel panelAccueil = accueil.getJPanel();
        this.refreshPanel(panelAccueil);
    }

    private void refreshPanel(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.repaint();
        frame.validate();
    }

    public void ajouterAnimal(String nom, String espece) {
        Animal animal = new Animal(nom, espece);
        menagerie.ajouterUnAnimal(animal);
        System.out.println(menagerie.toString());
    }

    public void afficher() {
        Afficher afficher = new Afficher(this, menagerie.getAnimaux());
        JPanel panelAfficher = afficher.getJPanel();
        this.refreshPanel(panelAfficher);
        System.out.println(menagerie.toString());
        menagerie.toString();
    }

    public static void main(String[] args) {
        new AppMenagerie();
    }
}
