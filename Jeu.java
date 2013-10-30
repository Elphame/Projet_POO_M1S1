/**
 * Une partie de cartes abstraite.
 * @author Antoine Lafouasse
 */

import java.util.ArrayList;

public abstract class Jeu
{
	protected LinkedList<Carte>[] table;

	/**
	 * Initialise une table pour une partie de cartes.
	 * @param nbrPiles Le nombre de piles que doit contenir la table.
	 */
	public Jeu(int nbrPiles)
	{
		this.table = new LinkedList<Carte>[nbrPiles];
		for (int i = 0; i < nbrPiles; i++)
		{
			this.table[i] = new LinkedList<Carte>();
		}
	}
}
