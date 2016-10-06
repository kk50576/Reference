package tw.org.iii;

import java.io.*;
public class Mars20 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		boolean check=false;
		do{
		   System.out.println("請輸入手機號碼");
		   String num=input.readLine();
		   if(num.matches("^09[0-9]{8}")){
			System.out.println("這是個正確的手機號碼");
		   }
		   else{
			   System.out.println("這不是手機號碼，請從新輸入");
			   check=true;
		   }
		}while(check);
	}

}
