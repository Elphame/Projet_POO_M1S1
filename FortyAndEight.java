/**
 * Une partie de réussite selon la variante Forty and eight.
 * @author Antoine Lafouasse
 */

import java.util.LinkedList;

public class FortyAndEight extends Jeu
{
	private LinkedList<Carte> talon;
	private LinkedList<Carte> pot;

	public FortyAndEight()
	{
		super(8);
		Deck d = new Deck(2);
		this.pot = new LinkedList<Carte>();
		this.talon = new LinkedList<Carte>();
		while (true)
		{
			try
			{
				this.talon.add(d.piocher());
			}
			catch (RuntimeException e)
			{
				break ;
			}
		}
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				this.table.get(i).add(this.talon.poll());
			}
		}
	}

	/**
	 * Retourne une représentation textuelle de la partie, c'est-à-dire
	 * de la table au moment où la méthode est appelée.
	 * @return String Une représentation textuelle de la table, c'est-à-dire
	 * des huit piles, de la première carte du pot (X s'il est vide), et un
	 * O si le talon contient au moins une carte, X s'il est vide.
	 */
	public String toString()
	{
		StringBuffer s = new StringBuffer(super.toString());
		s.append("[Pot] ");
		if (this.pot.size() == 0)
			s.append("X\n");
		else
			s.append(this.pot.pollFirst().toString() + "\n");
		s.append("[Talon] ");
		if (this.talon.size() == 0)
			s.append("X\n");
		else
			s.append("O\n");
		return (s.toString());
	}
}
