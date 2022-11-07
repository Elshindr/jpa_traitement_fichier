package components;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.*;

/**
 * The type Recup fichier.
 */
public class RecupFichier {

	/**
	 * The Categories.
	 */
	public final static Map<String, Categorie> CATEGORIE_MAP =  new HashMap<>();

	/**
	 * The Marques.
	 */
	public final static Map<String, Marque> MARQUE_MAP = new HashMap<>();

	/**
	 * The Ingredients.
	 */
	public final static Map<String, Ingredient> INGREDIENT_MAP = new HashMap<>();

	/**
	 * The Allergenes.
	 */
	public final static Map<String, Allergene> ALLERGENE_MAP = new HashMap<>();

	public static Stock leStock;

	private RecupFichier() {
		super();
	}

	/**
	 * Gets instance.
	 *
	 * @return the instance
	 * @throws IOException the io exception
	 */
	public static RecupFichier getInstance() throws IOException {
		RecupFichier recupFichier = new RecupFichier();
		List<Produit> stock = new ArrayList<>();
		Path path = Paths.get(".\\src\\main\\resources\\open-food-facts.csv");
		List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		lines.remove(0);

		for (String line : lines) {

			String[] tokens = new String[30];
			for (int i = 0; i < line.split("\\|").length; i++) {
				tokens[i] = line.split("\\|")[i];
			}

			Categorie categorie = CATEGORIE_MAP.get(tokens[0]);
			if (categorie == null) {
				categorie = new Categorie(tokens[0]);
				CATEGORIE_MAP.put(tokens[0], categorie);
				categorie.setId(CATEGORIE_MAP.size());
			}

			Marque marque = MARQUE_MAP.get(tokens[1]);
			if (marque == null) {
				marque = new Marque(tokens[1]);
				MARQUE_MAP.put(tokens[1], marque);
				marque.setId(MARQUE_MAP.size());
			}

			List<Allergene> lstAllergenes = RecupFichier.initAllergenes(tokens[28]);
			List<Ingredient> lstIngredients = RecupFichier.initIngredients(tokens[4]);

			// Provisoire le temps d'implémenter additif et attribut à supprimer par la
			// suite
			List<Additif> lstAdditifs = RecupFichier.initAdditifs(tokens[29]);

			Map<String, String> lstAttribut = null;

			// Instantiation de Produits
			Produit produit = new Produit(tokens[2], categorie, marque, tokens[3],lstIngredients, lstAdditifs, lstAllergenes);
			stock.add(produit);

		}

		// Instantiation du Stock
		leStock = new Stock(stock);
		System.out.println("TROUVER");
		return recupFichier;
	}

	private static ArrayList<Allergene> initAllergenes(String lineAllergenes) {
		ArrayList<Allergene> lstAllergenes = new ArrayList<>();
		
		if (lineAllergenes != null) {
			lineAllergenes = lineAllergenes == null ? "" : lineAllergenes;
			String[] allergenes = lineAllergenes.split(",");
			for (String newAllergene : allergenes) {
				newAllergene = newAllergene.toLowerCase().replace("fr:", "").replace("en:", "").replace("*", "").trim();
				Allergene allergene = RecupFichier.ALLERGENE_MAP.get(newAllergene);
				if (allergene == null) {
					allergene = new Allergene(newAllergene);
					RecupFichier.ALLERGENE_MAP.put(newAllergene, allergene);
				}
				lstAllergenes.add(allergene);
			}
		}

		return lstAllergenes;
	}

	private static ArrayList<Ingredient> initIngredients(String lineIngredients) {
		ArrayList<Ingredient> lstIngredients = new ArrayList<>();
		if (lineIngredients != null) {
			String[] arrIngredient = lineIngredients.replace("_", "").trim().split("[,\\-]");
	
			for (String strIngredient : arrIngredient) {
	
				strIngredient = strIngredient.replace(".", "").trim().toLowerCase();
				Ingredient newIngredient = INGREDIENT_MAP.get(strIngredient);

				if (newIngredient == null) {
					newIngredient = new Ingredient(strIngredient);
					INGREDIENT_MAP.put(strIngredient, newIngredient);
				}
				lstIngredients.add(newIngredient);
			}
		}

		return lstIngredients;
	}

	private static ArrayList<Additif> initAdditifs(String lineAdditif) {
		ArrayList<Additif> listAdditif = new ArrayList<>();
		/*if (lineAdditif != null) {
			String[] splitAdditif = lineAdditif.replace("en:", "").split(",");

			for (String s : splitAdditif) {
				listAdditif.add(new Additif(s));
			}

		}*/
		return listAdditif;
	}
}
