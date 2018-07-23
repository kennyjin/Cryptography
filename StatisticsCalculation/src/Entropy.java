
public class Entropy {

	public static void calculate(double[] arr)
	{
		double entropy = 0;
		for (double p : arr)
		{
			entropy -= p * Math.log(p) / Math.log(2);
		}
		System.out.println(entropy);
	}
	
	public static void main(String[] args) {
//		double[] arr = new double[26];
//		for (int i = 0; i < 26; i++)
//		{
//			arr[i] = 1.0 / 26;
//		}
		double[] arr = new double[] {1.0/12, 1.0/12, 1.0/6, 2.0/3}; // HW4 Q3 a
		calculate(arr);
		double[] arr1 = new double[] {1.0/6, 5.0/6}; // HW4 Q3 b
		calculate(arr1);
	}
}
