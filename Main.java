/**
 * Le point d'entrée de l'application
 * @author Antoine Lafouasse
 */

public class Main
{
	public static void main(String[] args)
	{
		FortyAndEight f = new FortyAndEight();
		System.out.println(f.toString());
		while (true)
		{
			try
			{
				f.piocher();
				System.out.println(f.toString());
			}
			catch (RuntimeException e)
			{
				System.out.println(e.getMessage());
				break ;
			}
		}
		f.deplacer(1, 2, 3);
		System.out.println(f.toString());
	}
}
