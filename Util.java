public class Util
{
	public static int indexOf(String [] liste, String s)
	{
		for(int i = 0; i < liste.length; i++)
		{
			if (liste[i].equals(s)) return i;
		}
		return -1;
	}
}
