package emp;

public class Sales extends Permanent implements IBusinessTrip{
	int incentive;

	public int getIncentive() {
		return incentive;
	}

	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}

	public Sales() {
	}

	public Sales(int id, String name, int salary, int incentive) {
		super(id, name, salary);
		this.incentive = incentive;
	}

	@Override
	public int getPay() {
		return super.getPay() + getIncentive();
	}

	@Override
	public String info() {
		return super.info();
	}

	@Override
	public void goBusinessTrip(int day) {
		incentive += 300000*(day);
	}
}