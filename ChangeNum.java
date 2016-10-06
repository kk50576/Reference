package com.Joseph;
import java.io.*;

public class ChangeNum {

	public static void main(String[] args) {
           new ChangeNum().change();
	}
	//下面這個method 會要求輸入一個阿拉伯數字，並將數字轉國字
	public void change(){
		try{
			System.out.println("請輸入一個正整數");
			BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
			String s=input.readLine();
			int num=s.length();
			
		     String[] suit={"","拾","百","千","萬","拾","百","千","億","拾","百","千","兆","拾","百","千"};
			 String[] word={"\t","壹","貳","叁","肆","伍","陸","柒","捌","玖"};
			 for(int i=0;i<num;i++){
				 
				 System.out.print(word[s.charAt(i)-48]+suit[num-1-i]);   //'0'換成 int 是 48,'1'是 49,...
			 }
			 System.out.print("元整");
		}
		catch(Exception ex){}
		
	}//close method change

}
