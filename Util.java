/**
 * Une classe regroupant des méthodes-outils servant dans toute l'application.
 * @author Antoine Lafouasse
 */
import java.util.NoSuchElementException;
import java.util.LinkedList;

public class Util
{
	/**
	 * Cherche un objet dans un tableau et renvoie son indice.
	 * @param liste Le tableau dans lequel il faut chercher.
	 * @param o l'objet à chercher dans le tableau.
	 * @return L'indice de l'objet dans le tableau s'il est trouvé.
	 * @throws NoSuchElementException Si l'objet n'a pas été trouvé.
	 */
	public static int indexOf(Object [] liste, Object o)
	{
		for(int i = 0; i < liste.length; i++)
		{
			if (liste[i].equals(o)) return i;
		}
		throw new NoSuchElementException();
	}

	/**
	 * Transfère un certain nombre d'éléments de la fin d'une pile à la fin
	 * d'une autre.
	 * @param orig La pile d'origine, de laquelle les éléments seront retirés.
	 * @param dest La pile de destination, à laquelle les éléments seront
	 * ajoutés.
	 * @param nbr Le nombre d'éléments à transférer.
	 * @throws RuntimeException Si orig ne contient pas assez d'éléments ou est
	 * vide.
	 */
	public static <T> void deplacer(LinkedList<T> orig,
									LinkedList<T> dest,
									int nbr)
	{
		if (nbr >= orig.size())
			throw new IllegalArgumentException(
				"La pile d'origine ne contient pas assez d'éléments.");
		LinkedList<T> temp = new LinkedList<T>();
		for (int i = 0; i < nbr; i++)
		{
			temp.addFirst(orig.pollLast());
		}
		while (temp.size() > 0)
		{
			dest.addLast(temp.pollFirst());
		}
	}
}
