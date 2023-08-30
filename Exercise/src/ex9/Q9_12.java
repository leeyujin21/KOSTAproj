package ex9;

public class Q9_12 {
	public static int getRand(int from, int to) {
		//Math.random()과 절대값을 반환하는 Math.abs(int a),
		//그리고 둘 중에 작은 값을 반환하는 Math.min(int a, int b)를 사용하라
//		int min = Math.min(from, to);
//		int max = Math.max(from, to);
//		return (int)(Math.random()*(max-min+1))+min;
		
		//max - min <=> Math.abs(from-to) <=> Math.abs(to-from)
		return (int)(Math.random()*(Math.abs(from-to)+1))+Math.min(from, to);
	}
	/*
	 * (1) getRand메서드를 작성하시오.
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 20; i++)
			System.out.print(getRand(1, -3) + ",");
	}
}