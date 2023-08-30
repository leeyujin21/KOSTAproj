package item;

public class Unit {
	int healthPoint;
	final int MAX_HP;

	Unit(int hp) {
		MAX_HP = hp;
		healthPoint = MAX_HP;
	}
}