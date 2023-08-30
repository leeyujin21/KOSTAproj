package etc;
public class Q12 {
	public static void main(String[] args) {
//		3m 짜리 우물에 바닥에 달팽이가 있다.
//		달팽이는 낮 동안 55cm 올라올 수 있다.
//		하지만 날이 지면 잠을 자야 한다.
//		자는 동안 3cm를 미끄러져 내려간다.
//		달팽이가 우물 밖으로 나오는데 며칠이 걸릴까?
//		55cm 이하는 하루 걸림.
//		반복문과 조건물을 이요하여 프로그램을 작성하시오.
		int len = 300;
		int up = 55;
		int down = 3;
		int day = 1; // day = 0 day++가 while문 안에 젤 위에 써야함.
		//while문 사용
		while (len>0) {
			len -= up;
			if(len<=0)break;
			len += down;
			day++;
		}
		System.out.println("day: "+day);
	}
}