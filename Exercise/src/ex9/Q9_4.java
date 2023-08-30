package ex9;

import java.net.MulticastSocket;

class Q9_4 {
	static void printGraph(int[] dataArr, char ch) {
		/*
		 * (1) printGraph메서드를 작성하시오.
		 */
//		for(int i = 0; i<dataArr.length; i++) {
//			System.out.println("");
//			for (int j = 0; j<dataArr[i]; j++) {
//				System.out.print("*");
//			}System.out.print(dataArr[i]);
//		}
		for (int n : dataArr) {
			for(int i = 0; i<n; i++) {
				System.out.print(ch);
			}
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
		printGraph(new int[] { 3, 7, 1, 4 }, '*');
	}
}