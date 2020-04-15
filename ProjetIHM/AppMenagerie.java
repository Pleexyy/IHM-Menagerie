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
        System.out.println(e.getSource().toString());
    }

    public void afficherAjouter() {
        Ajouter ajouter = new Ajouter(this);
        JPanel panelAjouter = ajouter.getJPanel();
        this.refreshPanel(panelAjouter);
    }

    public void afficherSupprimer() {
        Supprimer supprimer = new Supprimer(this, menagerie.getAnimaux());
        JPanel panelSupprimer = supprimer.getJPanel();
        this.refreshPanel(panelSupprimer);

    }

    public void afficherRechercher() {
        Rechercher rechercher = new Rechercher(this, menagerie.getAnimaux());
        JPanel panelRechercher = rechercher.getJPanel();
        this.refreshPanel(panelRechercher);
    }

    public void afficherCompter() {
        Compteur compteur = new Compteur(this, menagerie.getAnimaux());
        JPanel panelCompteur = compteur.getJPanel();
        this.refreshPanel(panelCompteur);
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
    }

    public void afficher() {
        Afficher afficher = new Afficher(this, menagerie.getAnimaux());
        JPanel panelAfficher = afficher.getJPanel();
        this.refreshPanel(panelAfficher);
        menagerie.toString();
    }

    public void supprimerAnimal(int index) {
        menagerie.supprimerUnAnimal(index);
        this.afficherSupprimer();
    }

    public boolean rechercherAnimal(String nom) {
        menagerie.rechercherUnAnimal(nom);
        return menagerie.rechercherUnAnimal(nom);
    }

    public void compterAnimaux() {
        menagerie.getNombreAnimaux();
    }
    public static void main(String[] args) {
        new AppMenagerie();
    }
}
