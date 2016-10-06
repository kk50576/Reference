package tw.org.iii;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
public class Mars41 {

	public static void main(String[] args){
		int a=123;
		boolean b=true;
		double c=12.3;
		try{
			DataOutputStream dout=new DataOutputStream(new FileOutputStream("dir1/data.txt"));
			int data1=123;
			
			dout.writeInt(a);
			dout.writeBoolean(b);
			dout.writeDouble(c);
			dout.flush();
			dout.close();
		}
		catch(Exception e){}

	}

}
