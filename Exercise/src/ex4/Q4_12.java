package ex4;

public class Q4_12 {

	public static void main(String[] args) {
		// 구구단의 일부분을 다음과 같이 출력하시오
		for(int i = 0, dan = 2; i<3; i++, dan+=3) {
			for(int j = 1; j<=3; j++) {
				for(int k = dan; k<=((dan+2<10)?dan+2:9); k++) {
					System.out.print(String.format("%d*%d=%d\t", k, j , k*j));
				}System.out.println();
			}
			System.out.println();
		}
//		for(int i=1; i<=3; i++) {
//			for(int dan =2; dan<=4; dan++) {
//				System.out.print(String.format("%d*%d=%d\t", dan, i, dan*i));
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=1; i<=3; i++) {
//			for(int dan =5; dan<=7; dan++) {
//				System.out.print(String.format("%d*%d=%d\t", dan, i, dan*i));
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i=1; i<=3; i++) {
//			for(int dan =8; dan<=9; dan++) {
//				System.out.print(String.format("%d*%d=%d\t", dan, i, dan*i));
//			}
//			System.out.println();
//		}
		
	}

}
