package tw.org.iii;

import java.io.File;

public class Mars35 {

	public static void main(String[] args) {
		File dir2=new File("dir1/dir3/4/dir5/dir6");
        if(!dir2.exists()){
             if(dir2.mkdirs()){
            	 System.out.println("create OK");
             }
             else{
            	 System.out.println("create false");
             }
        }
	}

}
