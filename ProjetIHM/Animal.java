public class Animal {
    private String nom;
    private String espece;

    public Animal(String unNom, String uneEspece) {
        this.nom = unNom;
        this.espece = uneEspece;
    }

    public String getNom() {
        return this.nom;
    }

    public String toString() {
        return this.nom + " " + this.espece;
    }

}