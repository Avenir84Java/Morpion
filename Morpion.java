/**
 * Jeu de morpion, développé dans le cadre d'une formation JAVA à Avenir84, Avignon
 *
 * @author Avenir 84 - 
 * <a href="mailto:philippe.kurz@javenir84.org">philippe.kurz@javenir84.org</a>
 *
 *
 * @version 1.0
 */
 
 
 
import java.util.Scanner;


/**
 * Classe Morpion : représente le jeu du morpion
 */
public class Morpion {
	
	/**
	* Boolean qui indique si il faut afficher les message de debug dans la console. Peut être indiqué sur la ligne de commande
	*/
	private static boolean debug;
	
	/**
	* La grille de jeu
	*/
	private Grille grille;
	
	/**
	* Constructeur sans paramètre. La valeur par defaut (3) sera utilisée pour les dimensions de la grille.
	*/
	public Morpion(){
		notifier("Morpion instancié sans dimension");
		_morpion(0);
	}
	
	/**
	* Constructeur avec un paramètre pour indiquer la taille de grille souhaitée
	* @param dimension  La taille de la grille (3 => grille de 3 x 3)
	*/
	public Morpion(int dimension){
		notifier("Morpion instancié avec dimension = " + dimension);
		_morpion(dimension);
	}

	/**
	* Méthode privée gérant l'instanciation de la classe
	*/
	private void _morpion(int dimension) {
		
		if(dimension == 0)
			grille = new Grille();
		else
			grille = new Grille(dimension);
		

		grille.remplir();
		
		System.out.println(grille.toString());
		grille.verif();		

		//grille.remplir();
		

		run();		
	}
	
	private void run() {
		notifier("Démarrage du jeu");

		// while (true) {
			
			// Point p = validateCoordinatesAndCreatePoint(grille);
			// grille.verif();
			
		// }
	}
	
	// public static Point validateCoordinatesAndCreatePoint(Grille grid) {
		// boolean scannerIsInteger = false;
		// int coordinateX = -1;
		// int coordinateY = -1;
		
		// System.out.println(makeYourChoise(grid));
		
		// Scanner scanner = new Scanner(System.in);
		
		

		// while (scannerIsInteger == false) {
			// System.out.print("X coordinate (horizontal, zero-based, left -> right) : ");
			// String input1 = scanner.nextLine();
			// System.out.print("Y coordinate (vertical, zero-based, up -> down) : ");
			// String input2 = scanner.nextLine();
			
			// try {
				// coordinateX = Integer.parseInt(input1);
				// coordinateY = Integer.parseInt(input2);
			// } catch (Exception e) {
				// System.out.println();
				// System.out.println("Data is not valid. Only numbers are required");
				// continue;
			// }
			
			// if (coordinateX >= grid.getLineLength() || coordinateX < 0 || coordinateY >= grid.getLineLength() || coordinateY < 0 ) {
				// System.out.println();
				// System.out.println("Data is out of bounds. Coordinates must be between 0 and " + (grid.getLineLength() - 1));
				// continue;
			// }
			
			// if (grid.getCellValue(coordinateX, coordinateY) != "Empty") {
				// System.out.println();
				// System.out.println("Oh no, '" + grid.getCellValue(coordinateX, coordinateY) + "' is already here! Please, choose another cell coordinates");
				// continue;
			// }
			// scannerIsInteger = true;
		// }
		
		// Point point = new Point(coordinateX, coordinateY, grid.getValueForPoint());
		
		// return point;
		
	// }
	
	// public static String makeYourChoise(Grille grid) {
		// String makeYourChoisePlayer;
		
		// if (grid.getXTurn()) {
			// makeYourChoisePlayer = "Player XXXX, make your choise";
		// } else {
			// makeYourChoisePlayer = "Player OOOO, make your choise";
		// }
		
		// return makeYourChoisePlayer;
	// }	

		while (true) {
			
			//Point p = validateCoordinatesAndCreatePoint(grille);
			//grille.getGrille()[p.getCoordX()+(p.getCoordY()*grille.getDimension())]=p;
			grille.validateCoordinatesAndCreatePoint();
			System.out.println(grille.toString());
			grille.verif();		
			
		}
	}
	
	

	
	
	
	/**
	* Fonction d'affichage d'un message dans la console. Le message ne s'affiche que si ma variable debug est à true
	* @param message	Le message à afficher
	*/
	private static void notifier(String message) {
		if(debug)
			 System.out.println(message);
	}
	
	/**
	* Méthode principale.
	* La méthode analyse les arguments puis instancie un objet de classe Morpion, avec ou sans paramètre selon les arguments
	* @param args : Les arguments de la ligne de commande. Supporte -n (taille du tableau) et -debug (activation du mode debug)
	*/
	public static void main(String[] args) {
		int dim = 0;
		

		// Analyse des arguments

		// Recherche d'un argument -debug
		for(int i = 0; i < args.length ; i++) {
			
			if (args[i].equals("-debug")) 
				debug = true;
			else {
				try {
					dim = Integer.parseInt(args[i].substring(1));
					notifier("Dimension spécifiée : " + dim);
				}
				catch(Exception e) {
					notifier("Pas de dimension spécifiée");
				}
			}
		}
			

		// Construit un objet avec ou sans paramètre
		if (dim == 0 ) new Morpion(); else new Morpion(dim);
	}
	

		if (dim == 0 ) new Morpion(); else new Morpion(dim);
	}

}