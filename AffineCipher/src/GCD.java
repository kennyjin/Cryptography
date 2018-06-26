
public class GCD {
	public static int findGCD(int a, int b)
	{
		int g = a >= b ? a : b;
		int s = a < b ? a : b;
		int r = g % s;
		if (r == 0)
		{
			return s;
		}
		return findGCD(s,r);
	}
	public static void main(String[] args) {
		System.out.println(findGCD(32,50));
	}
}
