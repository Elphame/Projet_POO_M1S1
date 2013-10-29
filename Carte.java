/**
 * Une carte.
 * @author Caroline Brogniez
 */

public class Carte
{
	private final String valeur;
	private final String couleur;

	/**
	 * Crée une nouvelle instance de carte.
	 * @param v La valeur de la carte (As, 2, 3, ...)
	 * @param c La couleur de la carte (Coeur, Carreau, Pique, Trèfle)
	 */
	public Carte(String v, String c)
	{
		this.valeur = v;
		this.couleur = c;
	}

	/**
	 * Retourne la valeur de la carte.
	 * @return La valeur de la carte.
	 */
	public String getValeur()
	{
		return (this.valeur);
	}

	/**
	 * Retourne la couleur de la carte.
	 * @return La couleur de la carte.
	 */
	public String getCouleur()
	{
		return (this.couleur);
	}

	/**
	 * Retourne une représentation textuelle de la carte.
	 * @return La valeur de la carte, suivie de sa couleur.
	 */
	public String toString()
	{
		return (this.valeur + " " + this.couleur);
	}

	public int compareValeur(Carte c)
	{
		if (Util.indexOf(Valeurs.valeurs, this.valeur)
			== Util.indexOf(Valeurs.valeurs, c.getValeur()))
		{
			return 0;
		}
		else if (Util.indexOf(Valeurs.valeurs, this.valeur)
			> Util.indexOf(Valeurs.valeurs, c.getValeur()))
		{
			return 1;
		}
		else
	   	{
			return -1;
		}
	}
}
