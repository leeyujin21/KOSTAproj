package acc;

import java.io.Serializable;

import exc.BankException;

public class SpecialAccount extends Account implements Serializable{
	String grade = "Normal";
	double interest = 0.01;

	// 등급 정보를 반환하는 메서드
	public String getGrade() {
		return grade;
	}

	// 등급을 설정하는 메서드
	public void setGrade(String grade) {
		switch (grade.charAt(0)) {
		case 'V':
		case 'v':
			this.grade = "VIP";
			interest = 0.04;
			break;
		case 'G':
		case 'g':
			this.grade = "Gold";
			interest = 0.03;
			break;
		case 'S':
		case 's':
			this.grade = "Silver";
			interest = 0.02;
			break;
		case 'N':
		case 'n':
			this.grade = "Normal";
			interest = 0.01;
			break;
		}
	}

	// 기본 생성자
	public SpecialAccount() {
	}

	// 매개변수를 받는 생성자
	public SpecialAccount(String id, String name, int money, String grade) {
		super(id, name, money);
		setGrade(grade);
	}

	// 예금을 처리하는 메서드 (오버라이딩)
	@Override
	public void deposit(int money) throws BankException {
		super.deposit((int) (Math.round(money + money * interest)));
	}

	@Override
	public String toString() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d, 등급: %s", getId(), name, balance, grade);
	}
// 	  계좌 정보를 반환하는 메서드 (오버라이딩)
//    @Override
//    public String info() {
//        return super.info() + ", 등급: " + grade + " ";
//    }
//	public void deposit(int money) {
//	balance += money + money*getGrade();
//}
//double getGrade() {
//	if(grade.equals("V")) return 0.04;
//	else if(grade.equals("G")) return 0.03;
//	else if(grade.equals("S")) return 0.02;
//	else return 0.01;
//}
}