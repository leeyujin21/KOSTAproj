package ex5;

public class Q5_10_1 {
	public static void main(String[] args) {
//		다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다.
//		(1)에 알맞은 코드를 넣어서 완성하시오.
//		아스키코드 참조
		char [] abcCode =
			{	// a~z
				'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'};
						// 0	1	2	3	4	5	6	7	8	9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		String result = "`~!wer";
		String src = ""; 
		
		for(int i = 0; i<result.length(); i++) {
			char ch = result.charAt(i);
			if(ch > 'a' && ch < 'z') {
				for(int j = 0; j<numCode.length; j++) {
					if(ch == numCode[j]) {
						src += j;
					}
				}
			}else {
				for(int k = 0; k<abcCode.length; k++) {
					if(ch == abcCode[k]) {
						src += (char)(k+'a');
					}
				}
			}
		}
		System.out.println("result: "+result);
		System.out.println("src: "+src);
	}	//end of main
}	//end of class
