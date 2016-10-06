package tw.org.iii;

public class Mars29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mars291 obj1=new Mars291();
        Mars292 obj2=new Mars293();   //多型
		Mars293 obj3=new Mars293();
		Mars293 obj4=(Mars293)obj2;
		obj3.m1();
		obj3.m2();
		obj3.m3();
		obj2.m1();
		obj2.m2();
		//obj2.m3();
		obj4.m3();
	}

}

class Mars291{
	void m1(){}
	void m2(){}
}

abstract class Mars292{
	Mars292(){System.out.println("Mars292:");}
	void m1(){System.out.println("Mars292:m1()");}
	abstract void m2();
}

class Mars293 extends Mars292{
	void m2(){System.out.println("Mars293:m2()");}
	void m3(){System.out.println("Mars293:m3()");}
}
final class Mars294{
	
}