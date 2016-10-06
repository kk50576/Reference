package tw.org.iii;
import java.io.File;
import java.io.IOException;

public class Mars34 {

	public static void main(String[] args) {
//	   String[] pathSeparator={};
//	   System.out.println(pathSeparator);
//	   String separator="";
//	   System.out.println(separator);
	   File f1=new File("dir1/Mars2.txt");
	   System.out.println(f1.getAbsolutePath());
	   if(f1.isFile()){
		   System.out.println("exist");
	   }
	   else{
		   try{
		       if(f1.createNewFile()){
		    	   System.out.println("create OK");
		       }
		       else{
		    	   System.out.println("create fail");
		       }
		   }
		   catch(IOException ie){
			   System.out.println(ie.toString());
		   }
	   }
	}//close method main()

}//close class
