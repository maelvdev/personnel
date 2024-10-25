package Demineur;

import java.util.Random;

public class Carte
{

	private int taille;
	private int nbMine;

	private char[][] maCarte;

	Carte(int taille, int nbMine)
	{
		this.taille = taille;
		this.nbMine = nbMine;
		this.maCarte = new char[taille][taille];

		for (int i=0; i<taille;i++)
			for (int j=0; j<taille;j++)
			{
				this.maCarte[i][j] = '-';
			}
	}

	public Carte creerCarte(int taille, int nbMine)
	{
		if (taille < nbMine)
		{
			System.out.println("Impossible de créer une carte valide, création d'une carte basique.");
			return new Carte(8, 18);
		}
		return new Carte(taille, nbMine);
	}

	public boolean placerMine()
	{
		return false;
	}

	public boolean placerNum()
	{
		return false;
	}
}