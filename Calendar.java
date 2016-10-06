package com.Joseph;
import java.io.*;
import java.util.*;
public class Calendar {
	
	public static void main(String[] args) throws IOException{
	 int chose=0,year=0,month=0,first_day=0,end_day=0;
	 boolean temp_year,temp_month,check=true;
	 Date date=new Date();
	 while(check){
     BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
     System.out.println("--------------�U�~��------------------------");
     System.out.println("   (1).�C�L���w�~���Τ��(���)");
     System.out.println("   (2).�C�L���w�~�����");
     System.out.println("   (0).���}");
      chose=Integer.parseInt(input.readLine());
     switch(chose){
     case 0:
    	 System.out.println("The program will be exit");
    	 check=false;
    	 break;
     case 1:
    	 temp_year=true;
    	 temp_month=true;
    	 while(temp_year){
    	   System.out.println("�п�J�~��");
           year=Integer.parseInt(input.readLine());
    	   if(year<0||year>30000000){
    		  System.out.println("�п�J�X�z���~��");
    	   }
    	   else{
    		 temp_year=false;
    	   }
    	 }//end while
    	 while(temp_month){
    	   System.out.println("�п�J���");
    	   month=Integer.parseInt(input.readLine());
    	   if(month<0||month>12){
    		   System.out.println("�Э��s��J�X�z�����");
    	   }
    	   else{
    		   temp_month=false;
    	   }
    	 }//end while  
    	 System.out.println("---------------�U�~��------------------");
    	 System.out.println("�褸 \t"+year+"\t�~\t"+month+"\t��\t");
    	 int theFirst_day=date.count_first_day(year,month);
    	 end_day=date.count_days(year,month);
		 System.out.println("---------------");
    	 if(year==1752&&month==9){
    		 date.special_program();
    	 }
    	 else{
    	 date.print(theFirst_day,end_day);
    	 }
    	 break;
     case 2:
     temp_year=true;
     while(temp_year){
        System.out.println("�п�J�~��");
        year=Integer.parseInt(input.readLine());
        if(year<0||year>300000000){
    	System.out.println("�п�J�X�z���~��");
        }
        else{
        	temp_year=false;
        }
     }//end while
     for( month=1;month<=12;month++){
       theFirst_day=date.count_first_day(year,month);
       end_day=date.count_days(year, month);
       if(year==1752&&month==9){
       date.special_program();
       }
       else{
       System.out.println("�褸 \t"+year+"\t�~\t"+month+"\t��\t");
       date.print(theFirst_day, end_day);   
       }
     }
     break;
     }//end switch
	 }//end while
  }//close method main

}//cloes class

class Date{
	//�H�U���p��Ӧ~�Ӥ릳�h�֤ѡA�]���^����k�b1752�~�e�ĥ|�~�@�|�F
	//1752�~��|�s�@�|�A�{�ʤ��|�A���C�|�ʦ~�S�m�|�~
	
	static int  count_days(int year,int month){
		int days;
		if(year<=1752&&year%4==0&&month==2){
			days=29;
		}
		else if(year>1752&&((year%4==0&&year%100!=0)||year%400==0)&&month==2){
			days=29;
		}
		else if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			days=31;
		}
		else if(month==4||month==6||month==9||month==11){
			days=30;
		}
		else{
			days=28;
		}
		return (days);
	}//close method count_days
	//�M�w�Ӧ~�Ӥ�Ĥ@�ѬO�P���X�A�|�����X�ӳ����B��
	//(1)�b�褸1752�~�K��(�]�t�K��)�H�褸1�~1��1��P��������ǡA
	//��mod 7���l�ƨӭp��ҨD�~�몺�Ĥ@�Ѭ��P���X
	//(2)�^����k�b�褸1752�~9�릳�վ�L�A1752�~10~12��H1752�~10��1��P���鬰����I�A��mod 7�l��
	//�ӭp��ҨD�Ӧ~�Ӥ�Ĥ@�ѬO�P���X
	//(3)�褸1753�~�H��H1753�~1��1��P���@�̬���ǡA��mod7�l�ƨӭp��
	//1752�~��|�s�@�|�A�{�ʤ��|�A���C�|�ʦ~�S�m�|�~)
      static int count_first_day(int year,int month){
    	  int f_day=0;
    	  if(year<1752||(year==1752&&month<=8)){
    		  f_day=6;
    		  //�p��Ӧ~�@��@�鬰�P���X
    		  for(int i=1;i<year;i++){
    			  if(i%4==0){
    				  f_day=(f_day+366)%7;    				 
    			  }
    			  else{
    				  f_day=(f_day+365)%7; 
    			  }
    		  }//end for loop(�p��Ӧ~�Ĥ@�Ѭ��P���X)
    		  for(int j=0;j<month;j++){
    			  f_day=(f_day+count_days(year,j))%7;
    		  }//end for loop (�p��Ӥ�Ĥ@�Ѭ��P���X)
    	  }
    	  else if(year==1752&&month>=10){
    		  f_day=0;
    		  for(int j=10;j<month;j++){
    			  f_day=(f_day+count_days(year,j))%7;
    		  }//end for loop(�p��1752�~�Q���ҨD������Ĥ@�Ѭ��P���X)
    	  }
    	  else if(year>1752){
    		  f_day=1;
    		  for(int i=1753;i<year;i++){
    			  if((i%4==0&&i%100!=0)||i%400==0){
    				  f_day=(f_day+366)%7;
    			  }
    			  else{
    				  f_day=(f_day+365)%7;
    			  }
    		  }//end for loop (�p��Ӧ~�Ĥ@��(1/1)���P���X)
    		  for(int j=1;j<month;j++){
    			f_day=(f_day+count_days(year,j))%7;  
    		  }//end for loop(�p��Ӥ�Ĥ@�Ѭ��P���X)
    	  }
    	  return (f_day);
      } //close method count_first_day
	 /* �����S�Ҥ��Ƶ{���A�ѩ�1752�~9��L3��13��A�G�g�@�M���B�z�Ӧ~�뤧�Ƶ{���C */
	  static void special_program(){
	        int counter,days,first_day,end_day;
	        first_day=2;
	        end_day=30;
	        System.out.println("\t   �褸     1752       �~        �E        �� ");
	        String s="��\t�@\t�G\t�T\t�|\t��\t��\n";
	        for(counter=0;counter<first_day;counter++){
	           s+="\t";
	        }//end for loop
	        for(days=1;days<=end_day;days++){
			  s+=Integer.toString(days)+"\t"; 	
	          if((first_day+days)%7==4&&days!=2){
	             s+="\n";
	          }
	          if(days==2){
	               days=14;
	              s+=Integer.toString(days)+"\t";
	          }			 
	        }//end for loop
	       System.out.println(s);
    }//close method special_program
	//�H�U���C�L��䤧method�A�ǥѸӤ�Ĥ@�Ѭ��P���X�θӤ릳�X�ѨӨM�w�p��C�L  
	void print(int first_day,int end_day){
		String[][] num=new String[7][7]; 
		num[0]=new String[]{"��","�@","�G","�T","�|","��","��"};
		for(String s:num[0])
		System.out.print(s+"\t");
		System.out.println();
        int k=1;
        int i=1;

        for( i=1;i<num.length;i++){
        	for( int j=0;j<num[0].length;j++){
//        		if(k>end_day){
//        			k=0;
//        		}
        		String s=String.valueOf(k);
        		if(i==1&&j<first_day){
        		  System.out.print("\t");
        		}
        		else{
        			if(k<=end_day){
        			num[i][j]=s;
        			k++;
        			System.out.print(s+"\t");
        			}
        		}
        		
        	}//end for loop
        	System.out.println();
        }//end for loop
	}//close method print(int first_day,end_day)
}//close  class
