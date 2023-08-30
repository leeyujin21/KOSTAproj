import emp.Employee;
import emp.IBusinessTrip;
import emp.PartTime;

public class Company {
	Employee[] emps = new Employee[100];
	int empCnt = 0;
	int add;

	public void enter(Employee emp) { // Employee emp = emp1 //upcastsing
		emps[empCnt++] = emp;
	}

	public void allEmployeeInfo() {
		for (int i = 0; i < empCnt; i++) {
			System.out.println(emps[i].info());
		}
	}
	
	public int getTotalPay() {
		int tot = 0;
		for(int i = 0; i<empCnt; i++) {
			tot += emps[i].getPay();
		}
		return tot;
	}
	public void regBusinessTrip(IBusinessTrip emp, int day){
        emp.goBusinessTrip(day);
    }
}