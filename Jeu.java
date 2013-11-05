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
	 * Retourne une représentation textuelle de la partie, c'est-à-dire de la
	 * table au moment ou la méthode est appelée.
	 * @return String Une liste commençant par un (1) des piles de carte sur la
	 * table.
	 */
	public String toString()
	{
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < this.table.size(); i++)
		{
			s.append("[" + (i + 1) + "]");
			for (Carte c : this.table.get(i))
			{
				s.append(" " + c.toString());
			}
			s.append("\n");
		}
		return (s.toString());
	}

	/**
	 * Déplace un nombre de cartes donné en argument d'une pile à une autre
	 * de la table, en conservant leur ordre. À noter que cette méthode
	 * n'effectue des vérifications que sur le nombre de cartes dans chaque
	 * pile et le nombre de cartes à déplacer.
	 * @param orig L'indicatif de la pile d'origine (dont les cartes seront
	 * retirées), à partir de 1.
	 * @param dest L'indicatif de la pile de destination (à laquelle les cartes
	 * seront ajoutées), à partir de 1.
	 * @param nbrCartes Le nombre de cartes à déplacer.
	 */
	public void deplacer(int orig, int dest, int nbrCartes)
	{
		orig--;
		dest--;
		if (orig < 0 || orig >= this.table.size())
			throw new IllegalArgumentException(
				"Pile d'origine invalide: " + (orig + 1));
		else if (dest < 0 || dest >= this.table.size())
			throw new IllegalArgumentException(
				"Pile de destination invalide: " + (dest + 1));
		else if (nbrCartes < 1)
			throw new IllegalArgumentException(
				"Impossible de déplacer " + nbrCartes + " cartes");
		else if (nbrCartes >= this.table.get(orig).size())
			throw new IllegalArgumentException(
				"Il n'y a pas " + nbrCartes + "dans la pile: " + (orig + 1));

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
