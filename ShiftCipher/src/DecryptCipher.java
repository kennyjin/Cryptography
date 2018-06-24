
public class DecryptCipher {
	public static void main(String[] args) {
		decrypt("SEOYKJOEJ"); // The answer is WISCONSIN
		System.out.println('S' - 'W');
		System.out.println('S' - 'W' + 26);
	}
	
	public static void decrypt(String input) {
		char[] arr = input.toCharArray();
		for(int m = 0; m < 26; m++) 
		{
			for (int i = 0; i < arr.length; i++) 
			{
				if ((int)(arr[i] + 1) > 90)
				{
					arr[i] = 'A'; // This can only be used for upper-case letters
				}
				else 
				{
					arr[i] = (char)((int)(arr[i] + 1));
				}
			}
			System.out.println(String.valueOf(arr));
		}
	}
}
