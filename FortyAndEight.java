/**
 * Une partie de réussite selon la variante Forty and eight.
 * @author Antoine Lafouasse
 */

import java.util.ArrayList;
import java.util.LinkedList;

public class FortyAndEight extends Jeu
{
	private ArrayList<LinkedList<Carte>> bases;
	private LinkedList<Carte> talon;
	private LinkedList<Carte> pot;
	private boolean deuxiemeTalon;

	/**
	 * Construit une nouvelle partie de Forty and eight, en initialisant les
	 * huit piles de la table, le pot et le talon.
	 */
	public FortyAndEight()
	{
		super(8);
		this.bases = new ArrayList<LinkedList<Carte>>(8);
		for (int i = 0; i < 8; i++)
			this.bases.add(i, new LinkedList<Carte>());
		Deck d = new Deck(2);
		this.pot = new LinkedList<Carte>();
		this.talon = new LinkedList<Carte>();
		this.deuxiemeTalon = false;
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
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < 8; i++)
		{
			s.append("[B" + (i + 1) + "]");
			for (Carte c : this.bases.get(i))
			{
				s.append(" " + c.toString());
			}
			s.append("\n");
		}
		s.append(super.toString());
		s.append("[Pot] ");
		if (this.pot.size() == 0)
			s.append("X\n");
		else
			s.append(this.pot.peekFirst().toString() + "\n");
		s.append("[Talon] ");
		if (this.talon.size() == 0)
			s.append("X\n");
		else
			s.append("O\n");
		return (s.toString());
	}

	/**
	 * Pioche une carte du talon et la pose au sommet du pot. Le talon est
	 * retourné si besoin.
	 * @return RuntimeException Si le talon est vide pour la deuxième fois.
	 */
	public void piocher()
	{
		if (this.talon.size() == 0)
		{
			if (this.deuxiemeTalon == false)
			{
				this.talon = new LinkedList<Carte>(this.pot);
				this.pot = new LinkedList<Carte>();
				this.deuxiemeTalon = true;
			}
			else
				throw new RuntimeException("Le talon ne peut pas être"
										   + " retourné deux fois.");
		}
		else
		{
			this.pot.addFirst(this.talon.pollFirst());
		}
	}
}
