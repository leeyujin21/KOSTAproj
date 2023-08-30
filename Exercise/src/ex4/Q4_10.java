package ex4;

public class Q4_10 {

	public static void main(String[] args) {
		// int 타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라.
		// 만일 변수 num의 값이 12345라면, '1+2+3+4+5'의 결과인 15를 출력하라.
		// (1)에 알맞은 코드를 넣으시오.
		int num = 12345678;
		int sum = 0;
//		(ex)
//		sum += num%10;	//5
//		num /= 10;		//1234
//		sum += num%10;	//4
//		num /= 10;		//123
//		sum += num%10;	//3
//		num /= 10;		//123
//		sum += num%10;	//2
//		num /= 10;		//12
//		sum += num%10;	//1
//		num /= 10;		//1
//		sum += num%10;	//1
//		num /= 10;		//0

		while (true) {
			if (num == 0)
				break;
			sum += num % 10;
			num /= 10;
		}
		System.out.println("sum=" + sum);
	}

}