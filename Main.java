import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Création de la liste des médicaments
        ArrayList<Medicament> medicaments = new ArrayList<>();
        medicaments.add(new VenteLibre("Doliprane", 1500, 100, 12));
        medicaments.add(new VenteLibre("Ibuprofène", 7000, 50, 18));
        medicaments.add(new VenteSurOrdonnance("Antibiotique", 12.0, 30, true));
        medicaments.add(new VenteSurOrdonnance("Anti-douleur", 8.0, 20, false));

        System.out.println("**********Bienvenue dans l'application de gestion de pharmacie !********");
        System.out.print("Entrez votre nom : ");
        String nomClient = scanner.nextLine();

        System.out.print("Entrez votre âge : ");
        int ageClient = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante
        

        Client client = new Client(nomClient, ageClient);

        while (true) {
            System.out.println("\nMenu principal :");
            System.out.println("1. Afficher les médicaments disponibles");
            System.out.println("2. Acheter un médicament");
            System.out.println("3. Quitter");

            System.out.print("Faites votre choix : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne restante

            if (choix == 1) {
                // Afficher les informations des médicaments
                System.out.println("\nMédicaments disponibles :");
                for (int i = 0; i < medicaments.size(); i++) {
                    System.out.println((i + 1) + ". ");
                    medicaments.get(i).afficherInformation();
                }
            } else if (choix == 2) {
                // Acheter un médicament
                System.out.println("\nEntrez le numéro du médicament que vous souhaitez acheter :");
                for (int i = 0; i < medicaments.size(); i++) {
                    System.out.println((i + 1) + ". " + medicaments.get(i).nom);
                }

                System.out.print("Votre choix : ");
                int choixMedicament = scanner.nextInt();
                scanner.nextLine(); // Consommer la ligne restante

                if (choixMedicament < 1 || choixMedicament > medicaments.size()) {
                    System.out.println("Choix invalide !");
                    continue;
                }

                Medicament medicamentChoisi = medicaments.get(choixMedicament - 1);

                // Vérifier les conditions d'achat
                if (medicamentChoisi instanceof VenteLibre) {
                    VenteLibre venteLibre = (VenteLibre) medicamentChoisi;
                    if (venteLibre.estDisponiblePour(client.getAge())) {
                        client.acheterMedicament(venteLibre);
                    } else {
                        System.out.println("Vous n'avez pas l'âge requis pour acheter ce médicament.");
                    }
                } else if (medicamentChoisi instanceof VenteSurOrdonnance) {
                    VenteSurOrdonnance venteSurOrdonnance = (VenteSurOrdonnance) medicamentChoisi;
                    System.out.print("Avez-vous une ordonnance ? (oui/non) : ");
                    String reponse = scanner.nextLine();
                    boolean ordonnancePresente = reponse.equalsIgnoreCase("oui");

                    if (venteSurOrdonnance.validerOrdonnance(ordonnancePresente)) {
                        client.acheterMedicament(venteSurOrdonnance);
                    } else {
                        System.out.println("Vous ne pouvez pas acheter ce médicament sans ordonnance.");
                    }
                }
            } else if (choix == 3) {
                // Quitter l'application
                System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                break;
            } else {
                System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
    
