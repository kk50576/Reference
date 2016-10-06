package tw.org.iii;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Mars40 {

	public static void main(String[] args) {
		try{
            FileInputStream fin=new FileInputStream("dir1/staff.csv");	 
            InputStreamReader irs=new InputStreamReader(fin);
            BufferedReader br=new BufferedReader(irs);
            
            String line=br.readLine();
            String[] row=line.split(",");
            for(String data:row){
            	System.out.println(data);
            }
		}
		catch(Exception e){}
	}

}
