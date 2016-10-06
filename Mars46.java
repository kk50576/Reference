package tw.org.iii;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.Serializable;

public class Mars46 {

	public static void main(String[] args) {
		
		Mars464 obj=new Mars464(15,25);
		try{
			ObjectOutputStream oout=
					new ObjectOutputStream(
							new FileOutputStream("dir1/Mars46"));
			oout.writeObject(obj);
			oout.flush();
			oout.close();
			System.out.println("OK1");
		}
		catch(Exception e){}
		System.out.println("-----------------");
		try{
			ObjectInputStream oin=
					new ObjectInputStream(
							new FileInputStream("dir1/Mars46"));
			Mars464 obj2=(Mars464)oin.readObject();
			oin.close();
			System.out.println("OK2");
		}
		catch(Exception e){}
	}
  
}//close class Mars46

class Mars461 {
	Mars461(){System.out.println("Mars461()");}
}
class Mars462 extends Mars461  {
	Mars462(){System.out.println("Mars462()");}
}

class Mars463 extends Mars462 {
	Mars463(){System.out.println("Mars463()");}
}

class Mars464 extends Mars463 implements Serializable {
	int a,b,c;
	Mars464(int a,int b){
		this.a=a;
		this.b=b;
		c=this.a+this.b;
		System.out.println("Mars464()");
		System.out.println(c);
	}//close constructor
    
}//close closes