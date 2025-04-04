public class Ordonnance {
    private int id;

    public Ordonnance(int id) {
        this.id = id;
    }

    public boolean validerOrdonnance() {
        System.out.println("id de l'ordonnance :"+this.id);
        return true;
    }
}
