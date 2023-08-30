package ex6;
class Student{
	String name;
	int ban;	//반
	int no;		//번호
	int kor;	//국어점수
	int eng;	//영어점수
	int math;	//수학점수
	
	int getTotal() {
		return kor + eng + math;
	}
	float getAverage() {
		float avg = (float)getTotal()/3;
		return Math.round(avg*10)/10.0f;
		//75.545 => 76
		//755.545*100 => 7554.5 => 7555(round)/100.0 => 75.55
	}
	String info() {
		return  name + ", "+ban+", "+no+", "+kor+", "+eng+", "+math;
	}
}
public class Q6_3_4_5 {
	public static void main(String[] args) {
		Student s = new Student();
		s.name = "홍길동";
		s.ban = 1;
		s.no = 1;
		s.kor = 100;
		s.eng = 60;
		s.math = 76;
		
		System.out.println("이름: "+s.name);
		System.out.println("총점: "+s.getTotal());
		System.out.println("평균: "+s.getAverage());	
		System.out.println(s.info());
	}
}