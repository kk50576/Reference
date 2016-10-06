package tw.org.iii;

public class Mars23 {

	public static void main(String[] args) {

		 //Mars231 obj11=new Mars231();
		 //Mars231.m1();
		 Mars232.m1();
		//Mars232 obj12=new Mars232();

	}

}

class Mars231{
	static int a=12;
	static{
		System.out.println("Mars231:static{}");
	}
	{
		System.out.println("Mars231:{}:"+ ++a);
	}
	Mars231(){System.out.println("Mars231()");}
	static void m1(){
		System.out.println("Mars231:m1()");
	}
}

class Mars232 extends Mars231{
	{System.out.println("Mars232:{}:"+ ++a);}
	Mars232(){System.out.println("Mars232()");}}
