package ex6;

public class Q6_23 {
	static int max(int[] arr) {
		if(arr == null || arr.length == 0) {
			return -999999;
		}
		int maxval = arr[0];
		for(int i = 0; i<arr.length; i++) {
			if(arr[i]>maxval) {
				maxval = arr[i];
			}
		}return maxval;
	}
	public static void main(String[] args) {
		int[] data = { 3, 2, 9, 4, 7 };
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("최대값:" + max(data));
		System.out.println("최대값:" + max(null));
		System.out.println("최대값:" + max(new int[] {})); // 크기가 0인 배열
	}
}