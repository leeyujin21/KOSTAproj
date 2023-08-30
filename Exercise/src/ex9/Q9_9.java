package ex9;

public class Q9_9 {
	/*
	 * (1) delChar메서드를 작성하시오.
	 */
	public static StringBuffer delChar(String src, String delCh) {
		StringBuffer sb = new StringBuffer();
		sb.append(src);
		for(int i = 0; i<sb.length(); i++) {
			for(int j = 0; j<delCh.length(); j++) {
				if(sb.charAt(i) == delCh.charAt(j)) {
					sb.deleteCharAt(i);
				}
			}
		}
		return sb;
	}
	public static void main(String[] args) {
		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));
		System.out.println("(1 2 3 4\t5)" + " -> " + delChar("(1 2 3 4\t5)", " \t"));
	}
}