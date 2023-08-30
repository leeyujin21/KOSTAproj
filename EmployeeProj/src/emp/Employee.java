package emp;
public class Employee{
	private int id;
	String name;
	String dep;
	int sal;
	int bonus;
	public Employee(){}
	public Employee(int id, String name, String dep, int sal){
		this.setId(id);
		this.name = name;
		this.dep = dep;
		this.sal = sal;
	}
	
	public void payBonus(int money) {
		bonus += money;
	}
	public String info() {
//		return String.format("사번: %d, 이름: %s, 부서: %s, 급여: %d"
//				, id, name, dep, sal);
		return "사번: "+getId()+", 이름: "+name+", 부서: "+dep+", 급여: "+(sal+bonus);
	}
	public int getPay() {
		return sal + bonus;
	}
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
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
