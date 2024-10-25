package Attache;

public class Joueur
{

	// Personnalisation du personnage
	private String nomJoueur;

	// Statistique du personnage
	private int nbHealth  ;
	private int nbDamage  ;
	private int nbStrength;
	private int nbDefense ;

	private boolean joueurMort;

	public Joueur(String nom)
	{
		this.nomJoueur  = nom;
		this.nbHealth   = 100;
		this.nbDamage   = 5  ;
		this.nbStrength = 0  ;
		this.nbDefense  = 0  ; 

		this.joueurMort = false;
	}

	public void resetStat()
	{
		setNbDamage  (5);
		setNbDefense (0);
		setNbStrength(0);
	}

	public boolean enCombat(int degat)
	{
		degat -= this.getNbDefense();
		if (degat < 0)
			degat = 0;

		this.setNbHealth(this.getNbHealth()-degat);

		if (this.getNbHealth() <= 0)
		{
			this.joueurMort = true;
			return true;
		}

		return false;	
	}

	public String toString()
	{
		return "Le joueur " + this.getNomJoueur() + " à une force de " + this.getNbDamage() + ", " + this.getNbHealth()
		+ " de vitalité, et une défense de " + this.getNbDefense();
	}

	public boolean getJoueurMort()
	{
		return this.joueurMort;
	}

	public String getNomJoueur() {
		return this.nomJoueur;
	}
	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public int getNbHealth() {
		return this.nbHealth;
	}
	public void setNbHealth(int nbHealth) {
		this.nbHealth = nbHealth;
	}
	public int getNbDamage() {
		return this.nbDamage + this.getNbStrength();
	}
	public void setNbDamage(int nbDamage) {
		this.nbDamage = nbDamage;
	}
	public int getNbStrength() {
		return this.nbStrength;
	}
	public void setNbStrength(int nbStrength) {
		this.nbStrength = nbStrength;
	}
	public int getNbDefense() {
		return this.nbDefense;
	}
	public void setNbDefense(int nbDefense) {
		this.nbDefense = nbDefense;
	}

}
