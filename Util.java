import java.util.NoSuchElementException;

public class Util
{
	public static int indexOf(Object [] liste, Object o)
	{
		for(int i = 0; i < liste.length; i++)
		{
			if (liste[i].equals(o)) return i;
		}
		throw new NoSuchElementException();
	}
}
