package ex5;

public class Q5_6 {

	public static void main(String[] args) {
		// 큰 금액의 동전을 우선적으로 거슬러 줘야한다.
		int[] coinUnit = { 500, 100, 50, 10 };
		int[] arr = new int[coinUnit.length];

		int money = 2680;
		System.out.println("money: " + money + "원");

		for (int i = 0; i < coinUnit.length; i++) {
			arr[i] = money / coinUnit[i];
			money = money - (arr[i] * coinUnit[i]);
			System.out.println(coinUnit[i] + "원: " + arr[i] + "개");
		}
	} // main
}