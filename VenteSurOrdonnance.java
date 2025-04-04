public class VenteSurOrdonnance extends Medicament {
    private boolean necessiteOrdonnance;

    public VenteSurOrdonnance(String nom, double prix, int quantite, boolean necessiteOrdonnance) {
        super(nom, prix, quantite);
        this.necessiteOrdonnance = necessiteOrdonnance;
    }

    public boolean validerOrdonnance(boolean ordonnancePresente) {
        if (ordonnancePresente) {
            return true;
        }
        else{
            return false;
        }
       
    }

    @Override
    public void afficherInformation() {
        super.afficherInformation();
        System.out.println("Necessite une ordonnance:" + (necessiteOrdonnance ? "Oui":"Non"));
    }
    
}
