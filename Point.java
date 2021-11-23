/**
 * Classe java Point pour un jeu de morpion, développé dans le cadre d'une formation JAVA à Avenir84, Avignon
 *
 * @author Avenir84 - 
 * <a href="mailto:philippe.kurz@javenir84.org">philippe.kurz@javenir84.org</a>
 *
 *
 * @version 1.0
 */
/**
 * Classe Point : Représentation des coordonnées et de la valeur d'un point dans la grille de morpion
 */
 
public class Point {

	//Déclaration des variables
	private int coordX;
	private int coordY;
	private String value;
	
	
/**
 * Méthode constructeur qui initialise les valeurs
 * @param	inputCoordX	La position en X du point dans la grille
 * @param	inputCoordY	La position en Y du point dans la grille
 * @param	inputValue	La valeur affectée au point ("X" ou "O")
 */
	public Point(int inputCoordX, int inputCoordY, String inputValue) {
		this.coordX = inputCoordX;
		this.coordY = inputCoordY;
		this.value = inputValue;
	}
	
/**
 * Méthode qui définit ou initialise la coordonnée X
 * @param	coord	La position en X du point dans la grille
 */
	public void setCoordX(int coord) {
		coordX = coord;
	}
	
/**
 * Méthode qui définit ou initialise la coordonnée Y
 * @param	coord	La position en Y du point dans la grille
 */
	public void setCoordY(int coord) {
		coordY = coord;
	}
	
/**
 * Méthode pour obtenir la valeur de la cordonnée X
 * @return La coordonnée X du point
 */
	public int getCoordX() {
		return coordX;
	}
	
/**
 * Méthode pour obtenir la valeur de la cordonnée Y
 * @return La coordonnée Y du point
 */
	public int getCoordY() {
		return coordY;
	}
	
/**
 * Méthode setter qui donne la valeur à la coordonnée
 * @param	newValue	La valeur du point dans la grille
 */
	public void setValue(String newValue) {
		value = newValue;
	}
	
/**
 * Méthode getter qui appelle la valeur 
 * @return La valeur du point
 */
	public String getValue() {
		return value;
	}
	
/**
 * Méthode qui fournit un chaîne de caractères pour afficher les détails de l'objet
 * @return Un objet de classe String utilisable pour l'affichage
 */
	@Override
	public String toString() {
		return this.coordX + ":" + this.coordY + " => " + this.value;
	}

}