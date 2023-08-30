package ex5;
public class Q5_3 {

	public static void main(String[] args) {
		int [] arr = {10,20,30,40,50};
		int sum = 0;
		for (int i=0; i<arr.length; i++) {  //숫자 대신 arr.length로 쓰기
			sum += arr[i];
		}

		System.out.println("sum=" +sum);
	}

}
