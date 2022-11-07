import java.io.IOException;
import java.util.Scanner;

import components.RecupFichier;
import services.MenuService;
import services.AfficherAllergenesLesPlusCourants;
import services.AfficherMeilleurProduitParMarque;

public class ApplicationOpenFoodFacts {

	/**
	 * Point d'entrée de l'application
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("******** MENU FOOD ********");

		boolean running = true;
		RecupFichier.getInstance();

		while (running) {
			System.out.println("	-----------------	");
			System.out.println("Choisissez une option :");
			System.out.println("1 - Rechercher les meilleurs produits pour une Marque donnée");
			System.out.println("2 - Rechercher les meilleurs produits pour une Catégorie donnée");
			System.out.println("3 - Rechercher les meilleurs produits par Marque et par Catégorie");
			System.out.println("4 - Afficher les allergènes les plus courants");
			System.out.println("5 - Afficher les additifs les plus courants");
			System.out.println("6 - Sortir");
			String userChoice = scanner.nextLine();

			switch (userChoice) {
			case "1":
				MenuService service1 = new AfficherMeilleurProduitParMarque();
				service1.traiter(scanner);
				break;
			case "2":

				break;
			case "3":

				break;
			case "4":
				MenuService service4 = new AfficherAllergenesLesPlusCourants();
				service4.traiter(scanner);
				break;
			case "5":

				break;
			case "6":
				running = false;
				break;
			}
		}

		scanner.close();
	}
}
