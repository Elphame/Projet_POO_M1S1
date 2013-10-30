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
		this(1);
	}

	/**
	 * Construit une nouvelle instance de jeu de cartes, en y plaçant
	 * nbr jeux complets.
	 * @param nbr Le nombre de jeux complets (52 cartes) à intégrer.
	 */
	public Deck(int nbrDecks)
	{
		this.ptr = 0;
		this.jeu = new ArrayList<Carte>(52 * nbrDecks);
		for (int i = 0; i < nbrDecks; i++)
		{
			for (String c : Couleurs.valeurs)
			{
				for (String v : Valeurs.valeurs)
				{
					this.jeu.add(new Carte(v, c));
				}
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
		int size = this.jeu.size();
		for (int i = 0; i < size; i++)
		{
			c = this.jeu.get(i);
			j = r.nextInt(size);
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
		if (ptr >= this.jeu.size())
			throw new RuntimeException("Paquet vide.");
		Carte c = this.jeu.get(this.ptr);
		this.ptr++;
		return (c);
	}
}
