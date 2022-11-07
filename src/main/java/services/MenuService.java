package services;

import java.util.Scanner;

public abstract class MenuService {
	
	/**
	 * Permet de traiter le fichier food
	 * @param scanner
	 */
	public abstract void traiter(Scanner scanner);

	/**
	 * Permet d'afficher un message afin de faire fonctionner les services
	 * @param scanner
	 * @param message
	 * @return le choix de l'utilisateur
	 */
	public static String afficherMessage(Scanner scanner, String message){
		System.out.println("Veuillez choisir une "+ message);
		return scanner.nextLine();
	}

}
