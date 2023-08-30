package item;

public class SCV extends GroundUnit implements Repairable {
	public SCV() {
		super(60);
	}

	public void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit unit = (Unit) r;
			unit.healthPoint = unit.MAX_HP;
		}
	}
	
	@Override
	public void fix() {
		healthPoint = (int)Math.round(MAX_HP*0.8);
	}
}