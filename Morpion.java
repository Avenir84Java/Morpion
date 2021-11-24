/**
 * Jeu de morpion, développé dans le cadre d'une formation JAVA à Avenir84, Avignon
 *
 * @author Avenir 84 - 
 * <a href="mailto:philippe.kurz@javenir84.org">philippe.kurz@javenir84.org</a>
 *
 *
 * @version 1.0.0.0.0.1
 */
import java.util.Scanner;

/**
 * Classe Morpion : représente le jeu du morpion
 */
public class Morpion {
	
	/**
	* Boolean qui indique si il faut afficher les message de debug dans la console. Peut être indiqué sur la ligne de commande
	*/
	public static boolean debug;
	
	private static boolean autofill = false;
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
		
		if (autofill) {
			grille.remplir();
			System.out.println(grille.toString());
			System.out.println(grille.verif());
		}
		else
			run();		
	}
	
	private void run() {
		notifier("Démarrage du jeu");
	
		String resultat;
		System.out.println("Test");
		while ((resultat = grille.verif()) == null) {
			
			//Point p = validateCoordinatesAndCreatePoint(grille);
			//grille.getGrille()[p.getCoordX()+(p.getCoordY()*grille.getDimension())]=p;
			grille.validateCoordinatesAndCreatePoint();
			System.out.println(grille.toString());
			if (debug)
				System.out.println(resultat);		
			
		}
		System.out.println(grille.verif());
		System.exit(0);
	}
	
	

	
	
	
	/**
	* Fonction d'affichage d'un message dans la console. Le message ne s'affiche que si ma variable debug est à true
	* @param message	Le message à afficher
	*/
	public static void notifier(String message) {
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
			else if (args[i].equals("-autofill")) 
				autofill = true;

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

}