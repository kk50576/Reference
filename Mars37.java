package tw.org.iii;

import java.io.File;
import java.io.FileReader;

public class Mars37 {

	public static void main(String[] args) {
		File f1=new File("dir1/Mars1.txt");
		try{
            FileReader reader=new FileReader(f1);
            int c;
            do{ 
            	c=reader.read();
            	System.out.print((char) c);
            }while(c!=-1);
		reader.close();
		}
		catch(Exception e){
			
		}
	}

}
