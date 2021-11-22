import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

public class Grille {
	private final int DIMENSION_DEFAUT = 3;
		
	/** Version avec un tableau de Point
	* private Point[] grille = {new Point(0,0,"X"), new Point(1,0,"O"), new Point(2,0,"O"),
	*						    new Point(0,1,"X"), new Point(1,1,"X"), new Point(2,1,"O"),
	*						    new Point(0,2,"X"), new Point(1,2,"O"), new Point(2,2,"X")};
	*/
	
	private Point[] grille;					  
	
	/**
	* Exemple de remplissage de la grille 3x3	
	* 00 10 20
	* 01 11 21
	* 02 12 22
	*/
  
  
	public Grille(){
		_grille(DIMENSION_DEFAUT);
	}
  
	public Grille(int dimension){
		_grille(dimension);
	} 

	private void _grille(int dimension) {
		System.out.println("constructeur grille");
		grille = new Point[(int)Math.pow(dimension,2)];					  
		//System.out.println(this.toString());
	}

	/**
	* Fonction de recherche d'un gagnant dans la grille
	* @return	Le nom du gagnant (en attendant, le caractère gagnant, X ou O ou null si pas de gagnant)
	*/
	public String verif(){
		String okGagne = "";
		int dimension = (int)Math.sqrt(grille.length);
		
		for (int i = 0; i<dimension; i++) {
			if (okGagne == "stop"){
				break;
			}
			System.out.println();
			
			for (int j = i * dimension; j< (i+1)*dimension;j++){
				if ( j != i * dimension){
					String premier = grille[j].getValue();
					String second = grille[j-1].getValue(); 
					
					//System.out.println(premier + " " + second + " " + (premier != second));
					if (premier != second){
					   break; 
					}
					if (j == (i+1)*dimension-1){
						
						System.out.println("Gagné !!!");
						okGagne = "stop";
						
						break;
					}
				
			    }
				
				//System.out.println(grille[j]);				
			}			
		} 
		
		
		return " c'est bon ";
	}

	/**
	* Fonction pour remplir la grille de manière aléatoire afin de procéder aux tests
	*/
	public void remplir() {
		// Déterminer le 1er joueur
		int start = new Random().nextInt(2);	// 0 ou 1
		int nombreDeCases = grille.length; //(int)Math.pow(this.dimension,2);

		// Parcourir la grille			
		for (int i = 0; i < nombreDeCases; i++ ){	
			
			// tirer une case au hasard
			int j;
			do {			
				j = new Random().nextInt(nombreDeCases);
				//System.out.print("Dans la boucle " + j);
			} while ( grille[j] != null ); // Tant que j ne désigne pas une case vide
			
			grille[j] = new Point(0,0,	(((i + start) % 2) == 0 ? "X": "O"));	
			System.out.println(grille[j].toString());
		}
	}



	/**
	* Fonction qui retourne une chaîne de caractères affichant la grille 
	* @return 	La chaîne représentant la grille
	*/
	@Override	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int dimension = (int)Math.sqrt(grille.length);
		
		// Première ligne
		for (int i = 0; i < dimension; i++)
			sb.append((i == 0 ? "┌───┬" : (i < dimension-1) ? "───┬" : "───┐" + System.lineSeparator()));
		
		// Corps du tableau
		for(int j = 0; j < dimension; j++) {
			for (int i = 0; i < dimension; i++)
				sb.append((i == 0 ? "│ " : " │ ") + grille[(j * dimension) + i].getValue() + ((i < dimension-1) ? "" : " │" + System.lineSeparator()));
			if (j < dimension-1){
				for (int i = 0; i < dimension; i++)
					sb.append((i == 0 ? "├───┼" : (i < dimension-1) ? "───┼" : "───┤" + System.lineSeparator()));
			}
		}
		
		// Dernière ligne
		for (int i = 0; i < dimension; i++)
			sb.append((i == 0 ? "└───┴" : (i < dimension-1) ? "───┴" : "───┘"));

		return sb.toString();
		
	}
}