package tw.org.iii;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Mars36 {

	public static void main(String[] args) {
		File f1=new File("dir1/Mars1.txt");
		long c=f1.length();
		try{
		    FileInputStream fin=new FileInputStream(f1);
		    
		    byte[] temp=new byte[(int) c];
		    	c=fin.read(temp);
		    	System.out.print(new String(temp));
		    fin.close();
		    //System.out.println("OK");
		}
		catch(FileNotFoundException fe){
			System.out.println(fe.toString());
		}
		catch(IOException ie){
			System.out.println(ie.toString());
		}
	}

}
