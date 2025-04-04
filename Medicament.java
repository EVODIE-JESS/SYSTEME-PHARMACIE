public class Medicament {
    protected String nom;
    protected double prix;
    protected int quantite;

    public Medicament(String nom, double prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }
    public void afficherInformation() {
        System.out.println("Nom: " + nom + ", Prix: " + prix + ", Quantité: " + quantite);
    }
    public void modifierQuantite(int nouvelleQuantite) {
        this.quantite = nouvelleQuantite;
    }
    public boolean estdisponible() {
        return quantite > 0;

    }
}