/**
 * Le point d'entrée de l'application
 * @author Antoine Lafouasse
 */

public class Main
{
	public static void main(String[] args)
	{
		Deck d = new Deck(2);
		while (true)
		{
			try
			{
				System.out.println(d.piocher().toString());
			}
			catch (RuntimeException e)
			{
				System.out.println(e.getMessage());
				break ;
			}
		}
	}
}
