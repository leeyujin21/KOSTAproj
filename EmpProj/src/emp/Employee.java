package emp;

public abstract class Employee {
	int id;
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String info() {
		return "사번: " + getId() + ", 이름: " + getName();
	}
	
//	public int getPay() {
//		return 0;
//	}
	
	public abstract int getPay();
}