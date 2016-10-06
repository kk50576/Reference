package tw.org.iii;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStream;

public class Mars50 {

	public static void main(String[] args) {
		try{
		    URL url=new URL("http://www.pdfmyurl.com/?url=http://www.ncku.edu.com.tw");
		    HttpURLConnection conn=(HttpURLConnection) url.openConnection();
		    conn.connect();
//		    BufferedReader reader=new BufferedReader(
//		    		new InputStreamReader(
//		    				conn.getInputStream()));
//		    
//		    String line;
//		    while((line=reader.readLine())!=null){
//		    	System.out.println(line);
//		    }
//		    reader.close();
		    InputStream in=conn.getInputStream();
		    FileOutputStream fout=new FileOutputStream("upload/ncku.pdf"); 
		    int b;
		    while((b=in.read())!=-1){
		    	
		    }
		    fout.flush();
		    fout.close();
		    in.close();
		    System.out.println("OK");
		}

		catch(IOException me){
		   System.out.println(me.toString());	
		}
	}//close method main()

}//close class
