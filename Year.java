package tw.org.iii;
import java.util.Scanner;
public class Year {

	public static void main(String[] args) {
     
	
    	 System.out.println("請輸入西元年分");
    	 Scanner scan=new Scanner(System.in);
    	 String Input;
    	 Input=scan.nextLine();
    	 int Output=Integer.parseInt(Input);
    	 if (Output%400==0){
    	  
    			  System.out.println("西元 "+Input+" 年是閏年，二月有29天!");
    		  }
    	 
    	 else if(Output%100!=0){
    		 if(Output%4==0){
    			 System.out.println("西元 "+Input+" 年是閏年，二月有29天!"); 
    		 }
    		 else{
    			 System.out.println("西元 "+Input+" 年不是閏年，二月只有28天!");
    		 }
    		 
    	 }
    	 else{
    		 System.out.println("西元 "+Input+" 年不是閏年，二月只有28天!");
    	 }
     }
}
