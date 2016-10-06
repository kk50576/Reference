package tw.org.iii;
import java.util.Scanner;

public class Year2 {

	public static void main(String[] args) {
      new Year2().go();
	}
	
	public void go(){
		System.out.println("請輸入西元年月份");
		Scanner san=new Scanner(System.in);
		String Input;
		Input=san.nextLine();
		int Output=Integer.parseInt(Input);
		
		if(Output%4==0&&Output%100!=0 || Output%400==0){
			System.out.println("西元 "+Input+" 年是閏年，二月有29天!");
		}
		else{
			System.out.println("西元 "+Input+" 年不是閏年，二月只有28天!");
		}
		
	}

}
