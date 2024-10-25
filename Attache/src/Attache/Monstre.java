package Attache;

public class Monstre
{
	private String nomMonstre       ;
	private int    nbHealthMonstre  ;
	private int    nbStrengthMonstre;
	private int    nbDefenseMonstre ;

	// Constructeur
	Monstre(String nom, int hp, int force, int def)
	{
		this.nomMonstre        = nom  ;
		this.nbHealthMonstre   = hp   ;
		this.nbStrengthMonstre = force;
		this.nbDefenseMonstre  = def  ;
	}

	//Factory
	public static Monstre creerMonstre(int numMonstre) {
		switch (numMonstre) {
			case 1:
				return new Monstre("Gobelin", (int) (Math.random() * 5) + 15, (int) (Math.random() * 4) + 3, (int) (Math.random() * 2));
			case 2:
				return new Monstre("Zombie", (int) (Math.random() * 5) + 30, (int) (Math.random() * 2) + 5, (int) (Math.random() * 2));
			case 3:
				return new Monstre("Troll", (int) (Math.random() * 5) + 15, (int) (Math.random() * 10) + 1, (int) (Math.random() * 5));
			case 4:
				return new Monstre("Gang de Gobelins", (int) (Math.random() * 5) + 15, (int) (Math.random() * 4) + 3, (int) (Math.random() * 2));
			case 5:
				return new Monstre("Dragon", 400, 40, 10);
			
			default:
				throw new IllegalArgumentException("Le monstre numéro : " + numMonstre + " est inconnu.");
		}
	}


	public boolean estAttaque(int degat)
	{
		this.setNbHealth(this.getNbHealth()-degat);

		if (this.nbHealthMonstre <= 0)
		{
			return true;
		}

		return false;	
	}


	public String getNomMonstre()
	{
		return this.nomMonstre;
	}

	public int getNbDef()
	{
		return this.nbDefenseMonstre;
	}
	public void setNbDef( int nvlDef)
	{
		this.nbDefenseMonstre = nvlDef;
	}

	public int getNbHealth()
	{
		return this.nbHealthMonstre;
	}
	public void setNbHealth(int newHpMonstre)
	{
		this.nbHealthMonstre = newHpMonstre;
	}

	public int getNbStrength()
	{
		return this.nbStrengthMonstre;
	}
	public void setNbStrength(int nvlStrength)
	{
		this.nbStrengthMonstre = nvlStrength;
	}

	public String toString()
	{
		return "Le " + this.getNomMonstre() + " à " + this.getNbHealth() + " HP.";
	}

}
