
public class Inverse {
	public static int findInverse(int num, int range)
	// This method find the Inverse of a number in Z-range.
	// Only numbers relatively prime to range have inverses.
	{
		for (int a = 0; a < range; a++)
		{
			if ((1 - a * num) % range == 0)
			{
				return a;
			}
		}
		return -1; // If inverse does not exist, return -1.
	}
	public static void main(String[] args)
	{
		for (int i = 1; i < 26; i += 2)
		{
			System.out.println(findInverse(i,26));
		}
	}
}
