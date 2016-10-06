package tw.org.iii;
import java.io.*;
public class Mars13 {

	public static void main(String[] args) {
		int num=0,sum=0;
	try{
	   System.out.println("請輸入一個數字");
       BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        num=Integer.parseInt(input.readLine());
    
		}
	catch(Exception e){};
	int i=1;
	while( i<=num){
		sum+=i++;	
	}
	System.out.print("1+2+3+...+"+(i-1)+"="+sum);
	}

}
