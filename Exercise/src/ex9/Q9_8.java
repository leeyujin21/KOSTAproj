package ex9;

public class Q9_8 {
	public static double round(double d, int n) {
		double p = Math.pow(10, n);
		return Math.round(d*p)/p;
	}

	/*
	 * (1) round메서드를 작성하시오.
	 */
	public static void main(String[] args) {
		System.out.println(round(3.1415, 1)); //Math.round(3.1415*Math.pow(10,1))/Math.pow(10,1)
		System.out.println(round(3.1415, 2)); //Math.round(3.1415*Math.pow(10,2))/Math.pow(10,2)
		System.out.println(round(3.1415, 3)); //Math.round(3.1415*Math.pow(10,3))/Math.pow(10,3)
		System.out.println(round(3.1415, 4)); //Math.round(3.1415*Math.pow(10,4))/Math.pow(10,4)
		System.out.println(round(3.1415, 5)); //Math.round(3.1415*Math.pow(10,5))/Math.pow(10,5)
	}
}