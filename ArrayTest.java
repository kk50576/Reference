package com.Joseph;
import java.util.*;
public class ArrayTest {

	public static void main(String[] args) {
		String[][] num=new String[6][7]; 
		num[0]=new String[]{"日","一","二","三","四","五","六"};
		for(String s:num[0])
		System.out.print(s+"\t");
		System.out.println();
		int k=1;
		for(int i=0;i<5;i++){
			for(int j=0;j<7;j++){
				if(k>31){
		        	System.out.print("");
		        	break;
	            }
				  String s=String.valueOf(k);
				
		          num[i+1][j]=s;
		          System.out.print(num[i+1][j]+"\t");
		          k++;
		          
		    }
			System.out.println();
		}
		
		System.out.println(num.length);
	}

}
