package tw.org.iii;

import java.util.Timer;
import java.util.TimerTask;

public class Mars58 {

	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new MyTask1(), 3000);
        timer.schedule(new MyTask2(timer), 1000,1000);
	}

}

class MyTask1 extends TimerTask{
	public void run(){
		System.out.println("MyTask1");
	}
}

class MyTask2 extends TimerTask{
	private int i;
	private Timer timer;
	MyTask2(Timer timer){this.timer=timer;}
	public void run(){
		System.out.println("MyTask2:"+ i++);
		if(i>10){
		   	timer.cancel();
		}
		
	}
}