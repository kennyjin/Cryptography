
public class VigenereCipher {
	
	public static int toInt(char c)
	{
		return c - 65;
	}
	
	public static char toChar(int i) // i has to be between 0 and 25
	{
		return (char)(i + 65);
	}
	
	public static void encryption(String key, String plainText)
	{
		char[] keyArr = key.toCharArray();
		char[] textArr = plainText.toCharArray();
		for (int i = 0; i < textArr.length; i++)
		{
			 int txt = toInt(keyArr[i % keyArr.length]) + toInt(textArr[i]);
			 txt = txt % 26;
			 textArr[i] = toChar(txt);
		}
		System.out.println(String.valueOf(textArr));
	}
	
	public static void decryption(String key, String cipherText)
	{
		char[] keyArr = key.toCharArray();
		char[] cipherArr = cipherText.toCharArray();
		for (int i = 0; i < cipherArr.length; i++)
		{
			 int txt = toInt(cipherArr[i]) - toInt(keyArr[i % keyArr.length]);
			 txt = txt % 26;
			 if (txt < 0)
			 {
				 txt += 26;
			 }
			 cipherArr[i] = toChar(txt);
		}
		System.out.println(String.valueOf(cipherArr));
	}
	
	public static void main(String[] args) {
		encryption("MAMA", "BECOOL");
		decryption("MAMA", "NEOOAL");
		String input = "PVBWFGB VSJKMQA RDHRPOC BPLEZFA KZWZCIL LPVDPOC DVSOLGF BQPIMQNFPMJKVB AKYJKQK HIAKZKE COVDXVM GZYJKGO WCJAYHS BWFRNFG JNRKKCW SUEAFEA";
		input = input.replaceAll("\\s+", "");
		decryption("WHY", input);
		String input1 = "GLCFDLCYYMLYOXQLYYEZDLCLYYEZQIRYYML"; // HW4 Q1
		decryption("KEYS", input1);
	}
	
	
	
	
	
	
	
	
}
