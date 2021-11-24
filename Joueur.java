 class Joueur {
	private char symbole;
	private String nom;
    private int score;
	
	public Joueur(char symbole) {
		this.symbole = symbole;
		
	}

	public Joueur(char symbole, String nom) {
		this.symbole = symbole;
		this.nom = nom;

	}
				
	public String getnom() {
		return nom;
	}

	public void setnom(String nom) {
		this.nom = nom;
	}
	
	public int getscore() {
		return score;
	}

	public char getsymbole() {
		return symbole;
	}

	public void setsymbole(char symbole) {
		this.symbole = symbole;
	}

	public void afficher (){
	   System.out.println("Symbole : " + symbole + ", nom : " + nom);		
	}
	
}