
public class HillCipher {
	public static void encryption(int[][] key, String plaintext) // the key has to be a square matrix
	{
		if (key.length != key[0].length)
		{
			System.out.println("The key is not a square matrix.");
			return;
		}
		if (plaintext.length() % key.length != 0)
		{
			for (int i = 0; i < plaintext.length() % key.length; i++)
			{
				plaintext += "Z";
			}
		}
		char[] textArr = plaintext.toCharArray();
		char[] cipherArr = new char[textArr.length];
		char[] blockArr = new char[key.length];
		for (int i = 0; i < plaintext.length(); i++)
		{
			if (i % key.length == 0)
			{
				for (int m = 0; m < key.length; m++)
				{
					blockArr[m] = textArr[i+m]; // update the block array
				}
			}
			int txt = 0;
			for (int j = 0; j < key.length; j++)
			{
				txt += key[i % key.length][j] * toInt(blockArr[j]);
			}
			txt %= 26;
			cipherArr[i] = toChar(txt);
		}
		System.out.println(String.valueOf(cipherArr));
	}
	
	public static void decryption(int[][] key, String ciphertext)
	{
		encryption(getInverseMatrix(key), ciphertext);
	}
	public static void main(String[] args) {
		int[][] key = new int[][] {{9,2},{13,3}};
		decryption(key, "YIFZMA");
	}
	public static int toInt(char c)
	{
		return c - 65;
	}
	
	public static char toChar(int i) // i has to be between 0 and 25
	{
		return (char)(i + 65);
	}
	
	public static int[][] getInverseMatrix(int[][] key) // This function can only be used for 2*2 invertible matrices.
	{
		int a = key[0][0];
		int b = key[0][1];
		int c = key[1][0];
		int d = key[1][1];
		int t = findInverse(a * d - b * c, 26);
		int[][] inverseM = new int[][] {{t * d, -b * t},{-c * t, a * t}};
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				inverseM[i][j] %= 26;
				if (inverseM[i][j] < 0)
				{
					inverseM[i][j] += 26;
				}
			}
		}
		return inverseM;
	}
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
	
	public static void printMatrix(int[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
}
