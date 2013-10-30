/**
 * Une partie de réussite selon la variante Forty and eight.
 * @author Antoine Lafouasse
 */

import java.util.LinkedList;

public class FortyAndEight extends Jeu
{
	private LinkedList<Carte> talon;

	public FortyAndEight()
	{
		Deck d = new Deck(2);
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
	}
}
