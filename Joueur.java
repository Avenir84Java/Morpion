
 class Joueur {
	private char symbole;
	private String nom;
	private String prenom;
    private int score;

	
	public Joueur(char symbole,String prenom,String nom) {
		
		this.symbole= symbole;
		this.nom= nom;
		this.prenom=prenom;
	}
		
		
	public String getnom() {
       return nom;
   }

   public void setnom(String nom) {
       this.nom = nom;
   }
	
	public String getprenom() {
       return prenom;
   }

   public void setprenom(String prenom) {
       this.prenom = prenom;
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
	   System.out.println("symbole"+"    "+symbole+"     "+"prenom"+"     "+prenom+"     "+"nom"+"    "+nom);
		
	}
	
}