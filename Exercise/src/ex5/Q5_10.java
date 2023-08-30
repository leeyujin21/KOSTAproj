package ex5;

public class Q5_10 {
	public static void main(String[] args) {
//		다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다.
//		(1)에 알맞은 코드를 넣어서 완성하시오.
//		아스키코드 참조
		char [] abcCode =
			{
				'`','~','!','@','#','$','%','^','&','*',
				'(',')','-','_','+','=','|','[',']','{',
				'}',';',':',',','.','/'};
						// 0	1	2	3	4	5	6	7	8	9
		char[] numCode = {'q','w','e','r','t','y','u','i','o','p'};
		
		String src = "abc123";
		String result = ""; 
		
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		
		// 'a' => '`' : abcCode['a'-'a']
		// 'f' => '$' : abcCode['f'-'a']
		// '5' => 'y' : numCode['5'-'0']
		
		// 'a' : abcCode[0] : abcCode['a'-'a'] == abcCode[97-97] == abcCode[0]
		// 'b' : abcCode[1] : abcCode['b'-'a'] == abcCode[98-97] == abcCode[1]
		// 'c' : abcCode[2] : abcCode['c'-'a'] == abcCode[99-97] == abcCode[2]
		// 'z' : abcCode[25] : abcCode['z'-'a'] == abcCode[122-97] == abcCode[25]
		// '0' : numCode[0] : numCode['0'-'0'] == abcCode[48-48] == abcCode[0]
		// '1' : numCode[1] : numCode['1'-'0'] == abcCode[49-48] == abcCode[1]
		// '9' : numCode[8] : numCode['9'-'0'] == abcCode[56-48] == abcCode[8]
		
		for (int i = 0; i<src.length(); i++) {
			char ch = src.charAt(i);
			//(1)
			if(ch>='a' && ch<='z') {
				result += abcCode[ch-'a'];
			}else if (ch>='0' && ch<='9') {
				result += numCode[ch-'0'];	//48
			}
		}
		System.out.println("src: "+src);
		System.out.println("result: "+result);
	}	//end of main
}	//end of class
