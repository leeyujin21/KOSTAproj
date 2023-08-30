package emp;

public class PartTime1 extends Employee implements IBusinessTrip {
   int time;
   int payPerTime;
   
   public int getTime() {
      return time;
   }
   public void setTime(int time) {
      this.time = time;
   }
   public int getPayPerTime() {
      return payPerTime;
   }
   public void setPayPerTime(int payPerTime) {
      this.payPerTime = payPerTime;
   }
   public PartTime1() {}
   public PartTime1(int id, String name, int time, int payPerTime) {
      super(id, name);
      this.time = time;
      this.payPerTime = payPerTime;
   }
   public int getPay() {
      return getTime()*getPayPerTime();
   }
   @Override
   public String info() {
      return super.info()+", 급여:"+getPay();
   }
   public void goBusinessTrip(int day) {
      time += day*24;
   }
}