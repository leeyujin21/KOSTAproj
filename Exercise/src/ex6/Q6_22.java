package ex6;

class Q6_22 {
	/*
	 * (1) isNumber메서드를 작성하시오.
	 */
//	static boolean isNumber(String str) {
//		if(str==null || str.length()==0)return false;
//		for(int i = 0; i<str.length(); i++) {
//			char ch = str.charAt(i);
//			if(!(ch>='0' && ch<'9')) {
//				return false;
//			}
//		}
//		return true;
//	}
	static boolean isNumber(String str) {
		if(str==null || str.length()==0)return false;
		boolean flag = true;
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(!(ch>='0' && ch<'9')) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}
}