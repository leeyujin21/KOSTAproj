package ex5;
public class Q5_4 {

	public static void main(String[] args) {
		int [][] arr = {
				{5,5,5,5,5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
		};

		int total = 0;
		float average = 0;
		
		for (int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		float num = 0;
		for (int i = 0; i<arr.length; i++) {
			num += arr[i].length;
		}
		
		average = (float)total / num;
		
		System.out.println("totat="+total);
		System.out.println("average="+average);
	}	// end of main
}	// end of class
