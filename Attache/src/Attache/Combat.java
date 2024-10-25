package Attache;

import java.util.Scanner;

public class Combat
{

	private Joueur  monJoueur ;
	private Monstre monMonstre;

	private boolean estFini = false;

	public Combat(Joueur joueur, int nombre)
	{

		Scanner scanner = new Scanner(System.in);
		this.monJoueur  = joueur;
		this.monMonstre = Monstre.creerMonstre(nombre);

		while ( !estFini )
		{
			if (monMonstre.getNbHealth()<=0 || monJoueur.getNbHealth() <= 0)
			{
				estFini = true;
			}
			else
			{
				System.out.println("<--------------------------------------------------------------------------------------->");
				System.out.println(this);
				System.out.println("Que voulez-vous faire ? (A : attaquer ; D : défense ; P : se préparer ; R : se régénérer)");

				if ( !this.choixMouvement (scanner.nextLine() ) )
					System.out.println("Il me semble que vous ayez fait une erreur, vous perdez donc votre tour.");

				if(monMonstre.getNbHealth()>0)
					System.out.println(this.monMonstre);
				
				

				monstreMouvement((int) (Math.random() * 4) + 1);
				if(!monJoueur.getJoueurMort())
					System.out.println(this.monJoueur);
			}
			

		}
		if (monJoueur.getNbHealth() > 0)
			this.messageMort();

		this.monJoueur.resetStat();
	}


	public boolean choixMouvement(String mvt)
	{
		switch (mvt)
		{
			case "A" : this.monMonstre.estAttaque  (this.monJoueur.getNbDamage  ()  ); break;
			case "D" : this.monJoueur.setNbDefense (this.monJoueur.getNbDefense ()+1); break;
			case "P" : this.monJoueur.setNbStrength(this.monJoueur.getNbStrength()+1); break;
			case "R" : this.monJoueur.setNbHealth  (this.monJoueur.getNbHealth  ()+3); break;
			default : return false;
		}
		
		return true;
	}

	public boolean monstreMouvement(int choix)
	{
		switch (choix)
		{
			case 1 : this.monJoueur.enCombat      (this.monMonstre.getNbStrength()  ); break;
			case 2 : this.monMonstre.setNbHealth  (this.monMonstre.getNbHealth() + 5); break;
			case 3 : this.monMonstre.setNbDef     (this.monMonstre.getNbDef()+1     ); break;
			case 4 : this.monMonstre.setNbStrength(this.monMonstre.getNbStrength()+1); break;
			default : return false;
		}
		
		return true;
	}


	public void messageMort()
	{
		System.out.println("Le "+ this.monMonstre.getNomMonstre() +" est mort, vous l'avez tué !");
	}



	public String toString()
	{
		return this.monJoueur.getNomJoueur() + " affronte un " + this.monMonstre.getNomMonstre();
	}

}
