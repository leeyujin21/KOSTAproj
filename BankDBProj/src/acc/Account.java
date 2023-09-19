package acc;

import java.io.Serializable;

import exc.BankError;
import exc.BankException;

// Account에 등급(grade) 추가됨. grade: VIP, Gold, Silver, Normal
// 등급에 따라 차등으로 입금시마다 이자를 준다.
// 입금액에 다음과 같은 비율로 지급
// VIP: 0.04, Gold: 0.03, Silver: 0.02, Normal: 0.01
//(ex) grade(VIP), 10000원 입금시 10400이 입금
//정보 호출시 등급도 포함
//(ex) 계좌번호: 10001, 이름: 홍길동, 잔액: 100000, 등급: VIP
public class Account implements Serializable{
	String id;
	String name;
	int balance;

	public Account() {
	} // 기본생성자

	public Account(String id, String name, int money) { // 이름이 같을 경우에는 가장 가깝게 선언된 변수를 인식
		setId(id);
		this.name = name;
		this.balance = money;
	}

	@Override
	public String toString() {
		return "계좌번호: " + id + ", 이름: " + name + ", 잔액: " + balance;
	}
//	public String info() {
////		return "계좌번호: " + id + ", 이름: " + name + ", 잔액: " + balance+", 등급: "+  grade;
//		return String.format("계좌번호: %s, 이름: %s, 잔액: %d", getId(), name, balance);
//	}

	public void deposit(int money) throws BankException {
		if (money <= 0) {
			throw new BankException("입금 오류", BankError.MINUS);
		}
		balance += money;
	}

	public void withdraw(int money) throws BankException {
		if (balance < money) {
			throw new BankException("출금 오류", BankError.LACK);
		}
		balance -= money;
//		if (balance >= money)
//			balance -= money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}