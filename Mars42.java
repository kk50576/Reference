package tw.org.iii;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class Mars42 {

	public static void main(String[] args) {
		try{
			DataInputStream din=new DataInputStream(new FileInputStream("dir1/data.txt"));
			int data1=din.readInt();
			boolean data2=din.readBoolean();
			double data3=din.readDouble();
			din.close();
			System.out.println(data1);
			System.out.println(data2);
			System.out.println(data3);
		}
		catch(Exception e){}

	}

}
