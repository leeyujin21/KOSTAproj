package ex6;

class Q6_20 {
	static int[] shuffle(int[] arr) {
//		int[] origin = new int [arr.length];
//		System.arraycopy(arr, 0, origin, 0, arr.length);
		int[] origin = arr.clone();
		for (int i = 0; i < 100; i++) {
			int idx1 = (int) (Math.random() * arr.length);
			int idx2 = (int) (Math.random() * arr.length);
			int tmp = origin[idx1];
			origin[idx1] = origin[idx2];
			origin[idx2] = tmp;
		}
		return origin;
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));
		System.out.println("---------------------------");
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(original));
		System.out.println(java.util.Arrays.toString(result));
		System.out.println(original == result);
//		shuffle(original);
//		System.out.println(java.util.Arrays.toString(original));
	}
}