/**
 * Une partie de cartes abstraite.
 * @author Antoine Lafouasse
 */

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Jeu
{
	protected ArrayList<LinkedList<Carte>> table;

	/**
	 * Initialise une table pour une partie de cartes.
	 * @param nbrPiles Le nombre de piles que doit contenir la table.
	 */
	public Jeu(int nbrPiles)
	{
		this.table = new ArrayList<LinkedList<Carte>>(nbrPiles);
		for (int i = 0; i < nbrPiles; i++)
		{
			this.table.add(i, new LinkedList<Carte>());
		}
	}
}
