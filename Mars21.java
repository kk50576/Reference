package tw.org.iii;

public class Mars21 {

	public static void main(String[] args) {
		Mars211 obj1=new Mars211();
		Mars211 obj2=new Mars211(10);
		Byte b=13;
		
		Mars211 obj3=new Mars211( b);

	}

}//close class

class Mars211{
	Mars211(){
		System.out.println("A");
	}
	Mars211(int a){
		System.out.println("B");
	}
	Mars211(byte a){
		System.out.println("C");
	}
}

