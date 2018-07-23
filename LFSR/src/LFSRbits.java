import java.util.ArrayList;


public class LFSRbits {
	public static ArrayList<Integer> generateBits(ArrayList<Integer> arr, int num_bits)
	// HW4 Q4 b
	{
		for (int i = 3; i < num_bits; i++)
		{
			arr.add(arr.get(i - 1) ^ arr.get(i - 3)); // This is the add operation in Z2
		}
//		int t = 0;
//		for (int i : arr)
//		{
//			t++;
//			System.out.print(i);
//			if (t % 3 == 0)
//			{
//				System.out.println();
//			}
//		}
		return arr;
		// easy to see the period is 7
	}
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(0);
		arr.add(1);
		System.out.println(generateBits(arr, 30));
	}
}
