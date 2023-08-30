package ex9;

public class Q9_10 {
	public static String format(String str, int length, int alignment) {
		//1
		if(length < str.length()) return str.substring(length);
		//2
		char[] carr = new char[length];
		for(int i = 0; i < length; i++) {
			carr[i] = ' ';
		}
		//3
		int space = 0;
		if(alignment == 0) {
			System.arraycopy(str.toCharArray(), 0, carr, 0, str.length());
		}else if(alignment == 1) {
			space = (length-str.length())/2;
			System.arraycopy(str.toCharArray(), 0, carr, space, str.length());
		}else if(alignment == 2) {
			space = length - str.length();
			System.arraycopy(str.toCharArray(), 0, carr, space, str.length());
;		}
		return new String(carr);
//		StringBuffer sb = new StringBuffer();
//		sb.append(ch);
//		int lm = (int)(length / 2) - 1;
//		//3
//		if(alignment == 0) 	sb.replace(0, str.length(), str);
//		else if(alignment == 1)
//			sb.replace(lm, lm + str.length(), str);
//		else if(alignment == 2) sb.replace(length - str.length(), length , str);
//		
//		return new String(sb);
	}
//	public static String format(String str, int length, int aligment) {
//		if (length < str.length()) {
//			return str.substring(0, length);
//		} else {
//			char[] carr = new char[length];
//			for (int i = 0; i < carr.length; i++) {
//				carr[i] = ' ';
//			}
//			System.arraycopy(str.toCharArray(), 0, carr, aligment, str.length());
//
//			return String.valueOf(carr);
//		}
//	}

	/*
	 * (1) format메서드를 작성하시오.
	 * 1. length의 값이 str의 길이보다 작으면 length만큼만 잘라서 반환한다.
	 * 2. 1의 경우가 아니면, length크기의 char배열을 생성하고 공백으로 채운다.
	 * 3. 정렬조건(alignment)의 값에 따라 문자열(str)을 복사할 위치를 결정한다. (System.arraycopy()사용)
	 * 4. 2에서 생성한 char배열을 문자열로 만들어서 반환한다.
	 */
	public static void main(String[] args) {
		String str = "가나다";
		System.out.println(format(str, 7, 0)); // 왼쪽 정렬
		System.out.println(format(str, 7, 1)); // 가운데 정렬
		System.out.println(format(str, 7, 2)); // 오른쪽 정렬
	}
}