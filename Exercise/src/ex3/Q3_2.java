package ex3;

public class Q3_2 {
	public static void main(String[] args) {
		int numOfApples = 123; // 사과의 개수
		int sizeOfBucket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수
		int numOfBucket = 0;
		if (numOfApples % sizeOfBucket == 0) {
			numOfBucket = numOfApples / sizeOfBucket;
		} else {
			numOfBucket = numOfApples / sizeOfBucket + 1;
		}
		System.out.println("필요한 바구니의 수 : " + numOfBucket);
	}
}