package ex4;

import java.util.Scanner;

public class Q4_14 {

	public static void main(String[] args) {
		//1~100 사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int)Math.random()*100+1;
		int input = 0; // 사용자 입력을 저장할 공간
		int count = 0; //시도 횟수를 세기 위한 변수
		// 화면으로부터 사용자 입력을 받기 위해서 Scanner 클래스 사용'
		Scanner s = new Scanner(System.in);
		do {
			if (count==0) {
				System.out.print("1과 100 사이의 값을 입력하세요.");
			}else {
				if(input>answer) {
					System.out.print("입력한 값보다 작습니다 :");
				}else {
					System.out.print("입력한 값보다 큽니다 :");
				}
			}
			count++;
			input = s.nextInt(); // 입력 받은 값을 변수 input에 저장한다.
			if(answer == input) {
				System.out.println("맞췄습니다. \n시도횟수는 "+count+"입니다.");
				break;
			}
		} while (true); //무한반복문
	}

}
