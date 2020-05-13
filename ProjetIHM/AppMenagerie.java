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
    private JMenuBar mb;
    private JMenu menu;
    private JMenuItem add, delete, search, count, list, back;

    public AppMenagerie() {
        menagerie = new Menagerie();

        frame = new JFrame("IHM - Ménagerie");
        frame.setSize(900, 500);
        frame.setResizable(false);
        
        Accueil accueil = new Accueil(this);
        JPanel panelAccueil = accueil.getJPanel();

        add = new JMenuItem("ajouter");
        delete = new JMenuItem("supprimer");
        search = new JMenuItem("rechercher");
        list = new JMenuItem("liste des animaux présents");
        count = new JMenuItem("nombre d'animaux présents");
        back = new JMenuItem("retour au menu");

        add.addActionListener(this);
        delete.addActionListener(this);
        search.addActionListener(this);
        list.addActionListener(this);
        count.addActionListener(this);
        back.addActionListener(this);

        mb = new JMenuBar();
        menu = new JMenu("Menu");

        menu.add(add);
        menu.add(delete);
        menu.add(search);
        menu.add(list);
        menu.add(count);
        menu.add(back);
        mb.add(menu);
        frame.add(mb);
        frame.setJMenuBar(mb);

        frame.getContentPane().add(panelAccueil);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource().toString());
        if (e.getSource() == add) {
            afficherAjouter();
        }
        if (e.getSource() == delete) {
            afficherSupprimer();
        }
        if (e.getSource() == search) {
            afficherRechercher();
        }
        if (e.getSource() == list) {
            afficher();
        }
        if (e.getSource() == count) {
            afficherCompter();
        }
        if (e.getSource() == back) {
            retour();
        }
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
        Animal animal = null;
        if (espece == "Vertébrés") {
            Vertebres unVertebre = new Vertebres(nom);
            animal = unVertebre;
        } else if (espece == "Mollusques") {
            Mollusques unMollusque = new Mollusques(nom);
            animal = unMollusque;
        } else {
            Arthropodes unArthropode = new Arthropodes(nom);
            animal = unArthropode;
        }
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
