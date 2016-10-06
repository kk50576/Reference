package tw.org.iii;

public class Mars25 {
   public static void main(String[] args){
	   Mars254 car=new Mars254();
	   Mars252 t1=new Mars252();
	   Mars253 t2=new Mars253();
	   car.m1(t1);
	   car.m1(t2);
   }
}
 
// 因為它是public abstract的 
interface Mars251{
	void m1();
	void m2();
}

class Mars252 implements Mars251{
	public void m1(){
		System.out.println("Mars252:m1()");
	}
	public void m2(){
		System.out.println("Mars252:m2()");
	}
	void m3(){
		System.out.println("Mars252:m3()");
	}
}

class Mars253 implements Mars251{
	public void m1(){
		System.out.println("Mars252:m1()");
	}
	public void m2(){
		System.out.println("Mars252:m2()");
	}
	void m4(){
		System.out.println("Mars252:m4()");
	}
	
}

class Mars254{
	void m1(Mars251 obj1){
		obj1.m1();
		obj1.m2();
	}
}