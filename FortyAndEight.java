/**
 * Une partie de réussite selon la variante Forty and eight.
 * @author Antoine Lafouasse
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;

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
				this.talon.addLast(d.piocher());
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
				this.table.get(i).add(this.talon.pollLast());
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
			s.append(this.pot.peekLast().toString() + "\n");
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
			this.pot.addLast(this.talon.pollLast());
		}
	}
	/**
	 * Exécute un tour de jeu. Cette méthode utilise l'entrée standard pour
	 * demander à l'utilisateur quel mouvement il veut exécuter, vérifie
	 * sa légalité et l'applique.
	 */
	public void jouer()
	{
		Scanner s = new Scanner(System.in);
		int input;
		Carte c = null;
		Carte cible = null;
		LinkedList<Carte> orig = null;
		LinkedList<Carte> dest = null;
		while (true)
		{
			try
			{
				System.out.print("Origine ? 0: piocher, 1: pot, 2: pile > ");
				input = s.nextInt();
				if (input == 0)
				{
					this.piocher();
					break ;
				}
				else if (input == 1)
				{
					if (this.pot.size() == 0)
						throw new RuntimeException("Le pot est vide.");
					else
						orig = this.pot;
				}
				else if (input == 2)
				{
					System.out.print("Choisir une pile (1~8) > ");
					input = s.nextInt() - 1;
					if (input < 0 || input > 7)
						throw new RuntimeException("Entrée invalide.");
					else if (this.table.get(input).size() == 0)
						throw new RuntimeException("Cette pile est vide.");
					else
						orig = this.table.get(input);
				}
				else
					throw new RuntimeException("Entrée invalide.");
				c = orig.peekLast();
				System.out.print("Destination ? 0: pile, 1: base > ");
				input = s.nextInt();
				if (input == 0)
				{
					System.out.print("Choisir une pile (1~8) > ");
					input = s.nextInt() - 1;
					if (input < 0 || input > 7)
						throw new RuntimeException("Entrée invalide.");
					else
					{
						if (this.table.get(input).size() == 0)
						{
							if (c.getValeur().equals("R"))
								dest = this.table.get(input);
							else
								throw new RuntimeException("Mouvement illégal.");
						}
						else
						{
							cible = this.table.get(input).peekLast();
							if (c.compareCouleur(cible)
								&& c.compareTo(cible) == -1)
								dest = this.table.get(input);
							else
								throw new RuntimeException("Mouvement illégal.");
						}
					}
				}
				else if (input == 1)
				{
					System.out.print("Choisir une base (1~8) > ");
					input = s.nextInt() - 1;
					if (input < 0 || input > 7)
						throw new RuntimeException("Entrée invalide.");
					else
					{
						if (this.bases.get(input).size() == 0)
						{
							if (c.getValeur().equals("A"))
								dest = this.bases.get(input);
							else
								throw new RuntimeException("Mouvement illégal.");
						}
						else
						{
							cible = this.bases.get(input).peekLast();
							if (c.compareCouleur(cible)
								&& c.compareTo(cible) == 1)
								dest = this.bases.get(input);
							else
								throw new RuntimeException("Mouvement illégal.");
						}
					}
				}
				else
					throw new RuntimeException("Entrée invalide.");
				Util.deplacer(orig, dest, 1);
				break ;
			}
			catch (InputMismatchException e)
			{
				System.out.println("Entrée invalide.");
				s.nextLine();
				continue ;
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				continue ;
			}
		}
	}
}
