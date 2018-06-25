
public class EncryptCipher {
	
	public static int toInt(char c)
	{
		return c - 65;
	}
	
	public static void main(String[] args) {
		encryptString("BADGERS");
//		decryptString("EBKTNAD");
//		System.out.println(encryptChar('B')); // problem 4
//		System.out.println(encryptChar('C')); // problem 4
		System.out.println(toInt('C'));
		System.out.println(toInt('R'));
		System.out.println(toInt('H'));
		System.out.println(toInt('A'));
		encryptString("CRWWZ"); // problem 5 decrypt
	}
	public static char toChar(int i) // i has to be between 0 and 25
	{
		return (char)(i + 65);
	}
	public static char encryptChar(char c) { // encryption function is 3x + 1, and this is the decryption function for problem 5
		int x = toInt(c);
		x = 3 * x + 1;
		// x = 3 * x + 23; // problem 4
		x = x % 26;
		return toChar(x);
	}
	public static char decryptChar(char c) { // decryption function is 9 (x - 1), where 9 is the inverse of 3 in [0, 25]
		int x = toInt(c);
		x = (x - 1) * 9;
		x = x % 26;
		if (x < 0) 
		{
			x += 26;
		}
		return toChar(x);
	}
	public static void encryptString(String c) {
		char[] arr = c.toCharArray();
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = encryptChar(arr[i]);
		}
		System.out.println(String.valueOf(arr));
	}
	public static void decryptString(String c) {
		char[] arr = c.toCharArray();
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = decryptChar(arr[i]);
		}
		System.out.println(String.valueOf(arr));
	}

}
