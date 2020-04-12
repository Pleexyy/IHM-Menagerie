import java.util.ArrayList;

public class Menagerie {
    private ArrayList<Animal> lesAnimaux;

    public Menagerie() {
        this.lesAnimaux = new ArrayList<Animal>();
    }

    public void ajouterUnAnimal(Animal unAnimal) {
        this.lesAnimaux.add(unAnimal);
    }

    public void supprimerUnAnimal(int index) {
        this.lesAnimaux.remove(index);
    }

    public boolean rechercherUnAnimal(String unNom) {
        boolean rep = false;
        int i = 0;
        while (i < this.lesAnimaux.size() && !this.lesAnimaux.get(i).getNom().equals(unNom)) {
            i++;
        }
        if (i < this.lesAnimaux.size()) {
            rep = true;
        }
        return rep;
    }

    public String toString() {
        String chaine = "";
        if (this.lesAnimaux.isEmpty()) {
            chaine += "\nAucun animal présent dans la ménagerie \n";
        } else {
            for (int i = 0; i < this.lesAnimaux.size(); i++) {
                chaine += "\n " + i + " - " + this.lesAnimaux.get(i).toString();
            }
        }
        return chaine;
    }

    public int getNombreAnimaux() {
        return this.lesAnimaux.size();
    }

    public ArrayList<Animal> getAnimaux() {
        return this.lesAnimaux;
    }
}