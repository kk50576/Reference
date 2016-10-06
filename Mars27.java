package tw.org.iii;

public class Mars27 {
     //static final int a=10;
	public static void main(String[] args) {
         System.out.println(Mars275.a);
          new Mars276();
	}
    
}

interface Mars271{
	//String f="明瑩";
	void m1();
}
interface Mars272{
	void m2();
}
class Mars273 implements Mars271,Mars272{
	public void m1(){}
	public void m2(){}
}

interface Mars274 extends Mars271{
	void m3();
}
interface Mars275 extends Mars274,Mars272{int a=10;}//public static int
class Mars276 implements Mars275{
	int b;
	final int c;
	Mars276(){
		c=12;
		System.out.println(c);
	}
	public void m1(){b++;}
	public void m2(){}
	public void m3(){}
}