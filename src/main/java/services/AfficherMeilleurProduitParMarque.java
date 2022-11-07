package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import components.RecupFichier;
import entities.Produit;

public class AfficherMeilleurProduitParMarque extends MenuService {

	@Override
	public void traiter(Scanner scanner) {
		String marque = MenuService.afficherMessage(scanner, "Marque");

		List<Produit> lstStock = RecupFichier.leStock.getLstProduit();
		List<Produit> meilleurProduits = new ArrayList<>();

		if (RecupFichier.MARQUE_MAP.get(marque) == null) {
			System.out.println(marque + "Marque non trouvé dans la base");
			return;
		}

		marque = marque.toLowerCase();
		String[] nutriScores = { "a", "b", "c", "d", "e", "f" };
		for (String nutriScore : nutriScores) {
			for (Produit produit : lstStock) {
				String marqueProduit = produit.getMarque().getLibelle().toLowerCase();
				if (produit.getGrade().contains(nutriScore) && marqueProduit.equals(marque)
						&& meilleurProduits.size() <= 10) {
					System.out.println(marqueProduit + " - " + produit.getLibelle() + " - "
							+ produit.getGrade().toUpperCase());
					meilleurProduits.add(produit);
				}
			}

		}
	}
}
