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
		f.jouer();
		System.out.println(f.toString());
	}
}
