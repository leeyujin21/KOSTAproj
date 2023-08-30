package ex4;

public class Q4_15 {

	public static void main(String[] args) {
		int number = 12321;
		int tmp = number;
		int result = 0; //변수 number를 거꾸로 변환해서 담을 변수
		
		// 1*10(4)+2*10(3)+3*10(2)+2*10(1)+1*10(0)=1+20+300+2000+10000=12321
		int sq = 4;
		while (tmp != 0) {
			result += tmp%10*(int)(Math.pow(10, sq));
			tmp /= 10;
			sq--;
		}
//		while (tmp != 0) {
//			result = result*10+tmp%10;
//			tmp /=  result;
//		}
		System.out.println(result);
		if(number == result) {
			System.out.println(number+"는 회문수 입니다.");
		}
		else {
			System.out.println(number+"는 회문수가 아닙니다.");
		}
	}

}
