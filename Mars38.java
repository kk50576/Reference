package tw.org.iii;

import java.io.File;
import java.io.FileOutputStream;

public class Mars38 {

	public static void main(String[] args) {
		File f1=new File("dir1/Mars3.txt");
		try{
		    FileOutputStream fout=new FileOutputStream(f1,true);
            fout.write("Hello,Mars2".getBytes());
            fout.write("\n 明瑩我喜歡你\n".getBytes());
            fout.flush();
		    fout.close();
		    System.out.println("OK");
		}
		catch(Exception e){
		   System.out.println(e.toString());	
		}
	}

}
