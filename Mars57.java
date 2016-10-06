package tw.org.iii;

public class Mars57 {

	public static void main(String[] args) {
		Mars571 obj1=new Mars571("A",200);
		Mars571 obj2=new Mars571("B",100);
		Mars572 obj3=new Mars572("C",150);
		Thread t3=new Thread(obj3);
        obj1.start();
        obj2.start();
        t3.start();
		try {
			obj2.join();
		} catch (InterruptedException e) {
		}
		System.out.println("main");
	}//close method main()

}//close class

class Mars571 extends Thread {
	private String name;
	private int delay;
	Mars571(String name, int delay){this.name = name;
	this.delay = delay;}
	@Override
	public void run() {
		for (int i=0; i<10; i++){
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				
			}
		}
	}
}
class Mars572 implements Runnable {
	private String name;
	private int delay;
	Mars572(String name, int delay){this.name = name;
	this.delay = delay;}
	@Override
	public void run() {
		for (int i=0; i<10; i++){
			System.out.println(name + ":" + i);
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				
			}
		}
	}
}