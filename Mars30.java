package tw.org.iii;

public class Mars30 {

	public static void main(String[] args) {
		Mars301 obj1=new Mars301();
		Mars302 obj2=new Mars302();
		Mars301 obj3=new Mars302();
		//Mars302 obj4=new Mars301();
		//obj1.m1();
		//obj2.m1();
		obj3.m1();
	}

}

class Mars301{
	int a=1;
	void m1(){System.out.println("Mars301:m1():"+a);}
}
class Mars302 extends Mars301{
	int a=2;
	void m1(){System.out.println("Mars302:m1():"+a);}
}