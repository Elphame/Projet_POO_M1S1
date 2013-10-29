/**
 * Un jeu de cartes.
 * @author Caroline Brogniez
 */

import java.util.Random;

public class Deck
{
	private Carte[] jeu;
	private int ptr;

	/**
	 * Construit une nouvelle instance de jeu de cartes.
	 */
	public Deck()
	{
		this.ptr = 0;
		int i = 0;
		this.jeu = new Carte[52];
		for (String c : Couleurs.valeurs)
		{
			for (String v : Valeurs.valeurs)
			{
				this.jeu[i] = new Carte(v, c);
				i++;
			}
		}
		this.melanger();
	}

	/**
	 * Mélange le jeu.
	 */
	public void melanger()
	{
		Random r = new Random();
		Carte c;
		int j;
		for (int i = 0; i < 52; i++)
		{
			c = this.jeu[i];
			j = r.nextInt(52);
			this.jeu[i] = this.jeu[j];
			this.jeu[j] = c;
		}
	}

	/**
	 * Retourne la première carte disponible dans le jeu.
	 * @return Carte La première carte disponible dans le jeu.
	 * @throws RuntimeException Si le jeu de carte est vide.
	 */
	public Carte piocher()
	{
		if (ptr >= 52)
			throw new RuntimeException("Paquet vide.");
		Carte c = this.jeu[this.ptr];
		this.ptr++;
		return (c);
	}
}
