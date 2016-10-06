package tw.org.iii;

public class Mars33 {

	public static void main(String[] args){
       Mars333 obj1=new Mars333();
       try{
           obj1.m3();
       }
       catch(Exception e){}
	}

}

class Mars331{
	void m1()throws Exception{
		throw new Exception();
	}
}
class Mars332 extends Mars331{
	void m2()throws Exception{m1();}
}
class Mars333 extends Mars332{
		
	void m3()throws Exception{m2();}
}