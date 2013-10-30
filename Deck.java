/**
 * Un jeu de cartes.
 * @author Caroline Brogniez
 */

import java.util.Random;
import java.util.ArrayList;

public class Deck
{
	private int ptr;
	private ArrayList<Carte> jeu;

	/**
	 * Construit une nouvelle instance de jeu de cartes.
	 */
	public Deck()
	{
		this.ptr = 0;
		this.jeu = new ArrayList<Carte>();
		for (String c : Couleurs.valeurs)
		{
			for (String v : Valeurs.valeurs)
			{
				this.jeu.add(new Carte(v, c));
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
			c = this.jeu.get(i);
			j = r.nextInt(52);
			this.jeu.set(i, this.jeu.get(j));
			this.jeu.set(j, c);
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
		Carte c = this.jeu.get(this.ptr);
		this.ptr++;
		return (c);
	}
}
