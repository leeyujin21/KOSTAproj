package ex6;

class Marine {
	int x = 0, y = 0; // Marine의 위치 좌표(x,y)
	int hp = 60;
	int weapon = 6;
	int armor = 0;

	void weaponUP() {
		weapon++;
	}

	void armorUp() {
		armor++;
	}

	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Q6_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}