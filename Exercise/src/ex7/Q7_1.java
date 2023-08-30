package ex7;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		/*
		 * (1) 배열 SutdaCard를 적절히 초기화 하시오.
		 */
		int length = CARD_NUM / 2;
		for (int i = 0; i < length; i++) {
			if ((i + 1) == 1 || (i + 1) == 3 || (i + 1) == 8) {
				cards[i] = new SutdaCard(i + 1, true);
			} else {
				cards[i] = new SutdaCard(i + 1, false);
			}
			cards[10 + i] = new SutdaCard(i + 1, false);
		}
	}
	void shuffle() {
		for (int i = 0; i < 1000; i++) {
			int idx1 = (int) (Math.random() * CARD_NUM);
			int idx2 = (int) (Math.random() * CARD_NUM);
			
			SutdaCard tmp = cards[idx1];
			cards[idx1] = cards[idx2];
			cards[idx2] = tmp;
		}
	}
	SutdaCard pick(int index) {
		return cards[index];
		
	}
	SutdaCard pick() {
		int idx = (int) (Math.random() * 20);
		return cards[idx];
	}
}

class SutdaCard {
	final int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// info()대신 Object클래스의 toString()을 오버라이딩했다.
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Q7_1 {
	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
	}
}