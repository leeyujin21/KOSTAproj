package ex9;

class Q9_3 {
	public static void main(String[] args) {
		String fullPath = "c:\\jdk1.5\\work\\PathSeparateTest.java";
		System.out.println(fullPath);
		/*
		 * (1) 알맞은 코드를 넣어 완성하시오.
		 */
		int idx = fullPath.lastIndexOf('\\');
		System.out.println("path: " + fullPath.substring(0, idx));
		System.out.println("fileName: " + fullPath.substring(idx + 1));
	}
}