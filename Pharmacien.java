public class Pharmacien {
    private String nom;
    private String identifiant;

    public Pharmacien(String nom, String identifiant) {
        this.nom = nom;
        this.identifiant = identifiant;
    }

    public void ajouterMedicament(Medicament medicament, int quantite) {
        medicament.modifierQuantite(quantite);
        System.out.println("Le médicament " + medicament + " a été ajoute.");
    }
    public void afficherIdentifiant(){
        System.out.println("Identifiant du pharmacien : " + this.identifiant);
    }
    public void afficherNom(){
        System.out.println("Nom du pharmacien : " + this.nom);
    }

    public void vendreMedicament(Client client, Medicament medicament) {
        client.acheterMedicament(medicament);
    }
}
