package ex5;

public class Q5_5 {

	public static void main(String[] args) {
		int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] ball3 = new int[3];

		// 배열 ballArr의 임의의 요소 2개를 골라서 위치를 바꾼다. 20번 반복
		for (int x = 0; x < 20; x++) {
			int i = (int) (Math.random() * ballArr.length);
			int j = (int) (Math.random() * ballArr.length);
			int tmp = 0;
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
		}

		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		for (int i = 0; i < ball3.length; i++) {
			ball3[i] = ballArr[i];
		}

		for (int i = 0; i < ball3.length; i++) {
			if (i == 2) {
				System.out.println(ball3[i]);
			} else
				System.out.print(ball3[i] + ",");
		}
	} // end of main
} // end of class
