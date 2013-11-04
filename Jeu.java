/**
 * Une Classe abstraite représentant une partie de cartes, quelle qu'elle soit.
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

	/**
	 * Déplace un nombre de cartes donné en argument d'une pile à une autre
	 * de la table, en conservant leur ordre. À noter que cette méthode
	 * n'effectue des vérifications que sur le nombre de cartes dans chaque
	 * pile et le nombre de cartes à déplacer.
	 * @param orig L'indicatif de la pile d'origine (dont les cartes seront
	 * retirées.
	 * @param dest L'indicatif de la pile de destination (à laquelle les cartes
	 * seront ajoutées).
	 * @param nbrCartes Le nombre de cartes à déplacer.
	 */
	public void deplacer(int orig, int dest, int nbrCartes)
	{
		if (orig < 0 || orig >= this.table.size())
			throw new IllegalArgumentException(
				"Pile d'origine invalide: " + orig);
		else if (dest < 0 || dest >= this.table.size())
			throw new IllegalArgumentException(
				"Pile de destination invalide: " + dest);
		else if (nbrCartes >= this.table.get(orig).size())
			throw new IllegalArgumentException(
				"Il n'y a pas " + nbrCartes + "dans la pile: " + orig);

		LinkedList<Carte> temp = new LinkedList<Carte>();
		for (int i = 0; i < nbrCartes; i++)
		{
			temp.addFirst(this.table.get(orig).pollLast());
		}
		for (int i = 0; i < nbrCartes; i++)
		{
			this.table.get(dest).addLast(temp.pollFirst());
		}
	}
}
