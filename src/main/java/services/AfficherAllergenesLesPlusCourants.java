package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import components.RecupFichier;
import entities.Allergene;
import entities.Produit;

public class AfficherAllergenesLesPlusCourants extends MenuService {

	@Override
	public void traiter(Scanner scanner) {
		List<Produit> lstStock = RecupFichier.leStock.getLstProduit();
		HashMap<Allergene, Integer> countAllergenes = new HashMap<>();
		
		for (Produit produit : lstStock) {
			List<Allergene> allergeneProduit =  produit.getLstAllergene();
			for (Allergene allergene : allergeneProduit) {
				Integer count = countAllergenes.get(allergene);
				if(count == null) {
					countAllergenes.put(allergene, 1);
				} else {
					countAllergenes.replace(allergene, count + 1);
				}
			}
		}
		
		List<Integer> countSort = new ArrayList<>();
		
		for (Integer count : countAllergenes.values()) {
			countSort.add(count);
		}
		
		Collections.sort(countSort);
		
		for (int i = countSort.size() - 1; i >= countSort.size() - 10; i--) {
			for (Allergene allergene : countAllergenes.keySet()) {
				if(countAllergenes.get(allergene) == countSort.get(i)) {
					System.out.println(allergene.getLibelle() + " - Présent dans " + countSort.get(i) + " produits");
				}
			}
		}
	}

}
