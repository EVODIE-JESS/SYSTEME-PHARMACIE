public class Client {
    private String nom;
    private int age;
    
    public Client(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public void acheterMedicament(Medicament medicament) {
        if (medicament.estdisponible()) {
            medicament.modifierQuantite(medicament.quantite - 1);
            System.out.println("Merci" +nom+", vous avez achete : "+medicament.nom);
        } else {
            System.out.println("Desole le médicament " + medicament.nom + " est en rupture de stock.");
        }
    }
}
