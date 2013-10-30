/**
 * Une carte.
 * @author Caroline Brogniez
 */

public class Carte implements Comparable<Carte>
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

	/**
	 * Retourne la différence entre la valeur de la Carte courante et la valeur
	 * de la Carte comparée. Si Cette différence est égale à -1 ou à 1 cela
	 * signifie que ce sont deux Cartes consécutives.
	 * @return La valeur de comparaison.
	 */
	public int compareTo(Carte c)
	{
		return (Util.indexOf(Valeurs.valeurs, this.valeur)
				- Util.indexOf(Valeurs.valeurs, c.valeur));
	}

	/**
	 * Permet de savoir si la Carte courante est de la même couleur que la Carte
	 * comparée.
	 * @return true si la couleur est la même, false sinon.x
	 */
	public boolean compareCouleur(Carte c)
	{
		return this.couleur.equals(c.getCouleur());
	}
}
