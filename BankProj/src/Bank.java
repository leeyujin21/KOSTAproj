import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import acc.Account;
import acc.SpecialAccount;
import exc.BankError;
import exc.BankException;

public class Bank {
	Map<String, Account> accs = new TreeMap<>();
	Scanner sc = new Scanner(System.in);

	int menu() throws BankException {
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전체계좌조회");
		System.out.println("0. 종료");
		System.out.print("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		if (!(sel >= 0 && sel <= 5)) {
			try {
				throw new BankException("메뉴 오류", BankError.MENU);
			} catch (BankException e) {
				System.out.println(e);
				menu();
			} // try, catch 안쓰고 throw만 하면 던지기만 하고 해결은 안 하기 때문에
				// throws를 써줘야함
		}
		return sel;
	}

	void selAccMenu() throws BankException {
		System.out.println("[계좌개설]");
		System.out.println("1. 일반계좌");
		System.out.println("2. 특수계좌");
		System.out.println("선택>>");
		int sel = Integer.parseInt(sc.nextLine());
		switch (sel) {
		case 1:
			makeAccount();
			break;
		case 2:
			makeSpecialAccount();
			break;
		default:
//			try {
			throw new BankException("메뉴 오류", BankError.MENU);
//			}catch(BankException e) {
//				System.out.println(e);
//				selAccMenu();
//			}
		}
//		if (sel == 1)
//			makeAccount();
//		else
//			makeSpecialAccount();
	}

	void makeAccount() throws BankException {
		System.out.println("[일반계좌 개설]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		if (accs.containsKey(id)) {
			throw new BankException("계좌 중복", BankError.EXISTID);
		}
//		if (acc != null) {
//			System.out.println("계좌번호가 중복됩니다.");
//			return;
//		}
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int money = Integer.parseInt(sc.nextLine());
		accs.put(id, new Account(id, name, money));
	}

	void makeSpecialAccount() throws BankException {
		System.out.println("[특수계좌 개설]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		if (accs.containsKey(id)) {
			throw new BankException("계좌 중복", BankError.EXISTID);
		}
//		if (acc != null) {
//			System.out.println("계좌번호가 중복됩니다.");
//			return;
//		}
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int money = Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP-V, Gold-G, Silver-S, Normal-N): ");
		String grade = sc.nextLine();
		if (!grade.equals("V") && !grade.equals("G") && !grade.equals("S") && !grade.equals("N")) {
			System.out.println("잘못된 등급입니다. Normal 등급으로 설정되었습니다");
		} else
			accs.put(id, new SpecialAccount(id, name, money, grade));
	}

//	Account searchAccById(String id) {
//		for(Account acc : accs) {
//			if(acc.getId().equals(id)) return acc;
//		}
//		return null;
//	}

	void deposit() throws BankException {
		System.out.println("[입금]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
//		try {
		if (!accs.containsKey(id))
			throw new BankException("계좌 오류", BankError.NOID);
//		}catch(BankException e) {
//			System.out.println(e);
//			deposit();
//		}
		System.out.print("입금액: ");
		int money = Integer.parseInt(sc.nextLine());
//		Account acc = accs.get(id);
//		acc.deposit(money);
		accs.get(id).deposit(money);
//		if (acc == null) {
//			System.out.println("계좌번호가 틀립니다.");
//			return;
//		}
	}

	void withdraw() throws BankException {
		System.out.println("[출금]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
//		try {
		if (!accs.containsKey(id))
			throw new BankException("계좌 오류", BankError.NOID);
//		}catch(BankException e) {
//			System.out.println(e);
//			withdraw();
//		}
//		if (acc == null) {
//			System.out.println("계좌번호가 틀립니다.");
//			return;
//		}
		System.out.print("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
		accs.get(id).withdraw(money);
	}

	void accountInfo() throws BankException {
		System.out.println("[계좌조회]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		if (!accs.containsKey(id))
			throw new BankException("계좌 오류", BankError.NOID);
//		if (acc == null) {
//			System.out.println("계좌번호가 틀립니다.");
//			return; // for문의 break와 비슷
//		}
		System.out.println(accs.get(id));
	}

	void allAccountInfo() {
		System.out.println("[전체 계좌 조회]");
		Iterator<Account> it = accs.values().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
//		for(Account acc: accs) {
//			System.out.println(acc);
//		}
	}

	public static void main(String[] args) throws BankException {
		Bank bank = new Bank();
		int sel;
		while (true) {
			try {
				sel = bank.menu();
				if (sel == 0)
					break;
				switch (sel) {
				case 1:
					bank.selAccMenu();
					break;
				case 2:
					bank.deposit();
					break;
				case 3:
					bank.withdraw();
					break;
				case 4:
					bank.accountInfo();
					break;
				case 5:
					bank.allAccountInfo();
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("입력형식이 맞지 않습니다. 다시 선택하세요.");
			} catch (BankException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}
}