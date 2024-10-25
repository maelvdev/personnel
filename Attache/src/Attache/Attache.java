package Attache;

public class Attache
{
	private Joueur   joueur;
	private Monstre monstre;

	
	// Avancée de la partie
	private int     numEtage;
	private int     numSalle;
	private static boolean victoire = false;


	public Attache(String nomJoueur)
	{
		this.joueur   = new Joueur(nomJoueur);
		this.numEtage = 1;
		this.numSalle = 1;
		
	}

	public static void main(String[] args) 
	{
		Attache latache = new Attache("Nouch");

		while (!latache.getVictoire() )
		{

			System.out.println(latache);
			
			while( ( latache.getNumEtage()!=3 || latache.getNumSalle() !=5 ) && latache.getJoueur().getNbHealth() > 0)
			{
				new Combat(latache.getJoueur(), (int) (Math.random() * 5) + 1);
				latache.nouvelleSalle();
			}

			Attache.setVictoire(true);
			
		}
		if ( latache.getJoueur().getNbHealth() > 0 )
		{
			System.out.println("Vous avez gagné, félicitation !");
		}	
		else
		{
			System.out.println("Vous-avez perdu. Mais la prochaine peut être la bonne !");
		}
	}


	public void nouvelleSalle()
	{
		if (this.getNumSalle() == 5)
		{
			this.setNumEtage(this.getNumEtage()+1);
			this.setNumSalle(1);
		}
		else
		{
			this.setNumSalle(this.getNumSalle()+1);
		}
	}

	public String toString()
	{
		return
		("Le joueur " + getJoueur().getNomJoueur() + " se situe à l'étage " + getNumEtage() + ", dans la salle numéro "
		+ getNumSalle() + "");
	}

	public Joueur getJoueur() {
		return this.joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Monstre getMonstre() {
		return this.monstre;
	}

	public void setMonstre(Monstre monstre) {
		this.monstre = monstre;
	}

	public int getNumEtage() {
		return this.numEtage;
	}

	public void setNumEtage(int numEtage) {
		this.numEtage = numEtage;
	}

	public int getNumSalle() {
		return this.numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}

	public boolean getVictoire() {
		return this.victoire;
	}

	public static void setVictoire(boolean bOk) {
		Attache.victoire = bOk;
	}

	
}