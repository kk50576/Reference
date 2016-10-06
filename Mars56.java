package tw.org.iii;

public class Mars56 {

	public static void main(String[] args) {
		Mars561 obj1=new Mars561("A");
        Mars561 obj2=new Mars561("B");
        obj1.start();
        obj2.start();
	}//close method main()
 
}//close class Mars56

class Mars561 extends Thread{
	private String name;
	Mars561(String name){this.name=name;}
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(name+":"+i);
			try{
			    Thread.sleep(100);
			}
			catch(InterruptedException ite){
				
			}
		}
		
	}//close method run()
}