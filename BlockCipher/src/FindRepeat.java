import java.util.HashMap;

public class FindRepeat {
	public static void main (String[] args)
	{
//		HashMap <String, Integer> map = new HashMap<String,Integer>();
//		System.out.println(map.get("AAA"));
//		map.put("AAA", 0);
//		map.put("AAA", map.get("AAA")+1);
//		map.put("AAA", map.get("AAA")+1);
//		map.put("AAA", map.get("AAA")+1);
//		
		//HashMap <String, Integer> map = getOccurenceMap("PVBWFGB VSJKMQA RDHRPOC BPLEZFA KZWZCIL LPVDPOC DVSOLGF BQPIMQNFPMJKVB AKYJKQK HIAKZKE COVDXVM GZYJKGO WCJAYHS BWFRNFG JNRKKCW SUEAFEA");
		HashMap <String, Integer> map = getOccurenceMap("GLCFDLCYYMLYOXQLYYEZDLCLYYEZQIRYYML"); // HW4 question1
		for (String str : map.keySet())
			{
				if (map.get(str) > 1)
				{
					System.out.println(str + ": " + map.get(str));
				}
			}
//		String input1 = "RSZWZORRSCKGOCKPCVZTJZYTRSZYTRCNTP";
//		HashMap <String, Integer> map = getOccurenceMap(input1);
//		for (String str : map.keySet())
//			{
//				if (map.get(str) > 1)
//				{
//					System.out.println(str + ": " + map.get(str));
//				}
//			}
	}
	public static HashMap<String, Integer> getOccurenceMap(String input)
	{
		HashMap <String, Integer> map = new HashMap<String,Integer>();
		input = input.replaceAll("\\s+", ""); // remove all the spaces in the String
//		for (int i = 0; i < input.length(); i++)
//		{
//			String word = input.substring(i, i + 1);
//			if (!map.containsKey(word))
//			{
//				map.put(word, 1);
//			}
//			else
//			{
//				map.put(word, map.get(word) + 1);
//			}
//		}
		int sequence_length = 5;
		for (int i = 0; i < input.length() - (sequence_length - 1); i++)
		{
			String word = input.substring(i, i + sequence_length); // Look for 3-letter repetitive sequence
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
}
