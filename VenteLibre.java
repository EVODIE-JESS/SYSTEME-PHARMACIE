public class VenteLibre extends Medicament {
    private int restrictionAge;

    public VenteLibre(String nom, double prix, int quantite, int restrictionAge) {
        super(nom, prix, quantite);
        this.restrictionAge = restrictionAge;
    }

    public boolean estDisponiblePour(int age) {
        return age >= restrictionAge;
    }

    @Override
    public void afficherInformation() {
        super.afficherInformation();
        System.out.println("Restriction d'age :"+ restrictionAge+"ans");
    }
    
}
