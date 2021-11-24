import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

// SAMIA AGAIN !

public class Grille {
	private final int DIMENSION_DEFAUT = 3;
	private int DIMENSION_CUSTOM = -1;
	private boolean XTurn = true;

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
	}

	/**
	* Fonction de recherche d'un gagnant dans la grille
	* @return	Le nom du gagnant (en attendant, le caractère gagnant, X ou O ou null si pas de gagnant)
	*/
	public String verif(){

		int dimension = this.getDimension();
		for (int i = 0; i<dimension; i++) {

			System.out.println();
			
			//verif ligne
			for (int j = i * dimension; j< (i+1)*dimension;j++){
				if ( j != i * dimension){
					String car1 = new String((grille[j]==null?Integer.toString(j):grille[j].getValue()));
					String car2 = new String((grille[j-1]==null?Integer.toString(j-1):grille[j-1].getValue())); 
					
					if (!car1.equals(car2)){
					   break; 
					}
					
					if (j == (i+1)*dimension-1){
						
						if (car1.equals("X")){
							
							return "X GAGNANT";
						}
						else if (car1.equals("O")) {
							
							return "O GAGNANT";
						}
						
						return null;
					}  
				}
			}
			
			// verif colonne

			for (int j = i ; j< dimension*dimension;j+=dimension) {
				System.out.println("i:" + i + " j:" + j);
				if ( j != i){	
					
					 String car1 = new String((grille[j]==null?Integer.toString(j):grille[j].getValue()));	
					 String car2 = new String((grille[j-dimension]==null?Integer.toString(j-dimension):grille[j-dimension].getValue())); 
					System.out.println(car1 + " " + car2);
					 if (!car1.equals(car2)){
					    break; 
					 }

					 if (j == dimension*dimension + (i-dimension)){ 
						
						if (car1.equals("X")){
							return "X";
						}
						else if (car1.equals("O")) {
							return "O";
						}
						
						 return null;
					}  
				}
			}
					
		}

		//verif diagonale
		for (int j=0; j<dimension*dimension;j+=(dimension+1)) {
			if (j!=0) {
				
				String car1 = new String((grille[j]==null?Integer.toString(j):grille[j].getValue()));	
				String car2 = new String((grille[j-1]==null?Integer.toString(j-1):grille[j-(dimension+1)].getValue()));
				
				if (j == (dimension*dimension)-1){
				
				if (car1.equals("X")){
							return "X";
						}
						else if (car1.equals("O")) {
							return "O";
						}		
				}
				
			}
		
		}
		
		for (int j=dimension-1; j<((dimension-1)*dimension)+1;j+=(dimension-1)) {
			if (j!=0) {
				
				String car1 = new String((grille[j]==null?Integer.toString(j):grille[j].getValue()));	
				String car2 = new String((grille[j-1]==null?Integer.toString(j-1):grille[j-(dimension-1)].getValue()));
				
				if (j == (dimension*dimension)-dimension){
				
				if (car1.equals("X")){
							return "X";
						}
						else if (car1.equals("O")) {
							return "O";
						}
				}
			}
		
		}
		
		return null;

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

				sb.append((i == 0 ? "│ " : " │ ") + (null==grille[(j * dimension) + i]?" ":grille[(j * dimension) + i].getValue()) + ((i < dimension-1) ? "" : " │" + System.lineSeparator()));

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

	
	public int getDimension() {
		if (this.DIMENSION_CUSTOM != -1) {
			return this.DIMENSION_CUSTOM;
		} else {
			return this.DIMENSION_DEFAUT;
		}
	}	
	
	public String getCellValue(int coordX, int coordY) {
		for (Point p: grille) {
			if (p != null && p.getCoordX() == coordX && p.getCoordY() == coordY) {
				return p.getValue();
			}
		}
		return "Empty";
	}	
	
	public String getValueForPoint() {
		String valueOfCharacter;
		if (XTurn) {
			valueOfCharacter = "X";
			XTurn = false;
		} else {
			valueOfCharacter = "O";
			XTurn = true;
		}
		return valueOfCharacter;
	}

	public boolean getXTurn() {
		return XTurn;
	}

	public void validateCoordinatesAndCreatePoint() {
		boolean scannerIsInteger = false;
		int coordinateX = -1;
		int coordinateY = -1;
		
		System.out.println(makeYourChoise());
		
		Scanner scanner = new Scanner(System.in);
		
		

		while (scannerIsInteger == false) {
			System.out.print("X coordinate (horizontal, zero-based, left -> right) : ");
			String input1 = scanner.nextLine();
			System.out.print("Y coordinate (vertical, zero-based, up -> down) : ");
			String input2 = scanner.nextLine();
			
			try {
				coordinateX = Integer.parseInt(input1);
				coordinateY = Integer.parseInt(input2);
			} catch (Exception e) {
				System.out.println();
				System.out.println("Data is not valid. Only numbers are required");
				continue;
			}
			
			if (coordinateX >= this.getDimension() || coordinateX < 0 || coordinateY >= this.getDimension() || coordinateY < 0 ) {
				System.out.println();
				System.out.println("Data is out of bounds. Coordinates must be between 0 and " + (this.getDimension() - 1));
				continue;
			}
			
			if (this.getCellValue(coordinateX, coordinateY) != "Empty") {
				System.out.println();
				System.out.println("Oh no, '" + this.getCellValue(coordinateX, coordinateY) + "' is already here! Please, choose another cell coordinates");
				continue;
			}
			scannerIsInteger = true;
		}
		
		Point point = new Point(coordinateX, coordinateY, this.getValueForPoint());
		grille[point.getCoordX()+(point.getCoordY()*this.getDimension())]=point;
		
	}
	
	public String makeYourChoise() {
		String makeYourChoisePlayer;
		
		if (this.getXTurn()) {
			makeYourChoisePlayer = "Player XXXX, make your choise";
		} else {
			makeYourChoisePlayer = "Player OOOO, make your choise";
		}
		
		return makeYourChoisePlayer;
	}

}