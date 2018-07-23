import java.util.ArrayList;

public class BinaryStrings {
	public static String getBinaryStrings(String text)
	{
		String str = "";
		text = text.replaceAll("\\s+", "");
		char[] arr = text.toCharArray();
		for (int i = 0; i < arr.length; i++)
		{
			str = str.concat(Integer.toBinaryString((int)arr[i]));
		}
		// System.out.println(str);
		// System.out.println();
		return str;
	}
	public static void main(String[] args) {
		//getBinaryStrings("TALK"); // HW4 Q4 a
		encipher(getBinaryStrings("TALK"));
	}
	public static ArrayList<Integer> getBitArray(String bitArray)
	{
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i < bitArray.length(); i++)
		{
			arr.add(Integer.parseInt(bitArray.substring(i, i + 1)));
		}
		return arr;
	}
	public static void encipher(String bitArray)
	{
		ArrayList<Integer> arr = getBitArray(bitArray);
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add(0);
		arr1.add(1);
		LFSRbits.generateBits(arr1, arr.size());
		for (int i = 0; i < arr.size(); i++)
		{
			System.out.print(arr.get(i));
		}
		System.out.println();
		for (int i = 0; i < arr.size(); i++)
		{
			System.out.print(arr1.get(i));
		}
		System.out.println();
		for (int i = 0; i < arr.size(); i++)
		{
			System.out.print(arr.get(i) ^ arr1.get(i)); // HW4 Q4 c, encipher TALK using the stream
		}
		System.out.println();
	}
}
