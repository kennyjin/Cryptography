import java.util.HashMap;

public class IndexOfCoincidence {
	// Can only be used for upper-case letters
	public static double calculate (String text)
	// Calculates the IC for text
	{
		double ic = 0;
		HashMap<String, Integer> map = getOccurenceMap(text);
		for(String str: map.keySet())
		{
			int a = map.get(str); // a is how many times the letter shows up
			ic += a * (a - 1);
		}
		ic /= text.length() * (text.length() - 1);
		return ic;
	}
	public static char toChar(int i) // i has to be between 0 and 25
	{
		return (char)(i + 65);
	}
	public static int toInt(char c)
	{
		return c - 65;
	}
	public static HashMap<String, Integer> getOccurenceMap(String input)
	{
		HashMap <String, Integer> map = new HashMap<String,Integer>();
		input = input.replaceAll("\\s+", ""); // remove all the spaces in the String
		for (int i = 0; i < input.length(); i++)
		{
			// get how many times all the one-letter string shows up
			String word = input.substring(i, i + 1); 
			if (!map.containsKey(word))
			{
				map.put(word, 1);
			}
			else
			{
				map.put(word, map.get(word) + 1);
			}
		}
		return map;
	}
	public static void printMap(HashMap<String, Integer> map)
	{
		for(String str: map.keySet())
		{
			System.out.println(str + ": " + map.get(str));
		}
	}
	public static String[] splitText(int blk_length, String text)
	// Split given text to pieces.
	// If we want to split "HELLOWORLD" and the given blk_length is 2,
	// We get HLOOL and ELWRD
	{
		String[] arr = new String[blk_length];
		for (int i = 0; i < blk_length; i++)
		{
			String str = new String("");
			for (int j = i; j < text.length(); j += blk_length)
			{
				str = str.concat(text.substring(j, j + 1));
			}
			arr[i] = str;
		}
		return arr;
	}
	public static double calculateAVG(int blk_length, String text)
	// Calculate the average IC using an anticipated block length
	{
		String[] arr = splitText(blk_length, text);
		double total = 0;
		for (String str : arr)
		{
			total += calculate(str);
		}
		return total / blk_length;
	}
	public static void printAVGs(int max_blk_length, String text)
	{
		for (int i = 1; i <= max_blk_length; i++)
		{
			System.out.println("blk_length: " + i + " IC: " + calculateAVG(i, text));
		}
	}
	public static void main(String[] args) {
		// HW4 Q1
		printMap(getOccurenceMap("GLCFDLCYYMLYOXQLYYEZDLCLYYEZQIRYYML"));
		System.out.println(calculate("GLCFDLCYYMLYOXQLYYEZDLCLYYEZQIRYYML")); // prints the index of coincidence of text
		printAVGs(17,"GLCFDLCYYMLYOXQLYYEZDLCLYYEZQIRYYML");
		//printAVGs(4, "HOWOWHHB");
	}
}
