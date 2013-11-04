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
}
