package item;

public class Tank extends GroundUnit implements Repairable {
	public Tank() {
		super(150);
	}
	
	@Override
	public void fix() {
		healthPoint = (int)Math.round(MAX_HP*0.9);
	}
}