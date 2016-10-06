package tw.org.iii;

public class Bike {
	   private double speed;
       static int count;
       public Bike(){
    	  count++;
    	  speed=1;
    	  System.out.println("Bike():"+speed);
       }
       
       protected void upSpeed(){
    	   speed=speed<1?1:speed*1.2;   
       }
       void downSpeed(){
    	   speed=speed>2?speed*0.7:(speed+1);
       }
       public double getSpeed(){
    	return speed;   
       }
}
