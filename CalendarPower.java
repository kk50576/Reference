package com.Joseph;

//import com.Joseph.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.io.*;
public class CalendarPower {
	 int chose=0,year=0,month=0,first_day=0,end_day=0;
	 boolean temp_year,temp_month,check=true;
	 NewDate date;
	 //static boolean checkS;
	 public static void main(String[] args){
		String cal;
		try{
	    BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
	    boolean checkS=true;
		 do{
			System.out.println("--------------�U�~��------------------------");
			System.out.println("(Ita) �����:1582�~10��15��(�q�B��B����)");
			System.out.println("(F) �����:1582�~12��20��(�k��)");
			System.out.println("(CN) �����:1752�~9��14��(�^�B����)");
			System.out.println("(CE) �����:1700�~3��1��(�����B���µ�)");
			System.out.println("�п�J�Q�n��ܪ���k(�Ҧp��J:Ita ��F��...)");
		    cal=input.readLine();
		    if(cal.contentEquals("Ita")||cal.equals("F")||cal.equals("CN")||cal.equals("CE")){
		    //f(cal!="Ita"&&cal!="F"&&cal!="CN"&&cal!="CE"){
		        checkS=false;
		    }
		    else{
		        System.out.println("�Э��s��J");
			}
		}while(checkS);
		 new CalendarPower().go(cal);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
    }//close method main

void go(String d){
	//NewDate date;
	 switch(d){
	 //NewDate date;
	 case "Ita":
	            date=new ItaDate();
	        break;
	 case  "F":
	           date=new FDate();
	        break;
	 case "CN":
		      date=new CNDate();
		     break;
	 case "CE":
		     date=new CEDate();
		     break;
     default:
    	     System.out.println("�Э��s��J");
    	     break;
	 }//close switch
	 try{
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
			 if(d.equals("Ita")&&year==1582&&month==10){
	    		 date.special_program();
	    	 }
			 else if(d.equals("F")&&year==1582&&month==12){
	    		 date.special_program();
	    	 }
	    	 else if(d.equals("CN")&&year==1752&&month==9){
	    		 date.special_program();
	    	 }
	    	 else if(d.equals("CE")&&year==1700&&month==2){
	    		 date.special_program();
	    	 }
	    	 else{
	    	 date.prical(theFirst_day,end_day);
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
	       if(d.equals("Ita")&&year==1582&&month==10){
	    		 date.special_program();
	    	 }
			 else if(d.equals("F")&&year==1582&&month==12){
	    		 date.special_program();
	    	 }
	    	 else if(d.equals("CN")&&year==1752&&month==9){
	    		 date.special_program();
	    	 }
	    	 else if(d=="CE"&&year==1700&&month==2){
	    		 date.special_program();
	    	 }
	       else{
	       System.out.println("�褸 \t"+year+"\t�~\t"+month+"\t��\t");
	       date.prical(theFirst_day, end_day);   
	       }
	     }
	     break;
	     }//end switch
		 }//end while
}
catch(Exception ex) {
	ex.printStackTrace();
}
}//close method void go
}//close class

abstract class NewDate{
	abstract  int count_days(int year,int month);
	abstract  int count_first_day(int year,int month);
	abstract  void special_program();
	//�H�U���C�L��䤧method�A�ǥѸӤ�Ĥ@�Ѭ��P���X�θӤ릳�X�ѨӨM�w�p��C�L
	void prical(int first_day,int end_day){
		String[][] num=new String[7][7]; 
		num[0]=new String[]{"��","�@","�G","�T","�|","��","��"};
		for(String s:num[0]){
		System.out.print(s+"\t");
		}
		System.out.println();
        int k=1;
        int i=1;

        for( i=1;i<num.length;i++){
        	for( int j=0;j<num[0].length;j++){
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
	}//close method prical(int first_day,end_day)
}//close class NewDate
class ItaDate extends NewDate{
	/*�H�U���p��Ӧ~�Ӥ릳�X�Ѥ��Ƶ{���G�]��1582�~���e���|�~�@�|�A
	 1582�~�H���|�~�@�|�A�{�ʤ��|�A�ӥ|�ʤS�n�|�A�G�����H�U���p�C*/
	int  count_days(int year,int month){
		int days;
		if(year<=1582&&year%4==0&&month==2){
			days=29;
		}
		else if(year>1582&&((year%4==0&&year%100!=0)||year%400==0)&&month==2){
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
	//(1)�b�褸1582�~�Q��(�]�t�Q��)�H�褸1�~1��1��P��������ǡA
	//��mod 7���l�ƨӭp��ҨD�~�몺�Ĥ@�Ѭ��P���X
	//(2)�q�B��B������k�b�褸1582�~10�릳�վ�L�A1582�~11~12��H1582�~11��1��P���@������I�A��mod 7�l��
	//�ӭp��ҨD�Ӧ~�Ӥ�Ĥ@�ѬO�P���X
	//(3)�褸1582�~�H��H1583�~1��1��P�����̬���ǡA��mod7�l�ƨӭp��
	//1583�~��|�s�@�|�A�{�ʤ��|�A���C�|�ʦ~�S�m�|�~)
      int count_first_day(int year,int month){
    	  int f_day=0;
    	  if(year<1582||(year==1752&&month<=9)){
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
    	  else if(year==1582&&month>=11){
    		  f_day=1;
    		  for(int j=10;j<month;j++){
    			  f_day=(f_day+count_days(year,j))%7;
    		  }//end for loop(�p��1752�~�Q���ҨD������Ĥ@�Ѭ��P���X)
    	  }
    	  else if(year>1582){
    		  f_day=6;
    		  for(int i=1583;i<year;i++){
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
 	 /* �����S�Ҥ��Ƶ{���A�ѩ�1582�~10��L5��14��A�G�g�@�M���B�z�Ӧ~�뤧�Ƶ{���C */
	   void special_program(){
	        int counter,days,first_day,end_day;
	        first_day=1;
	        end_day=31;
	        System.out.println("\t   �褸     1582       �~        10        �� ");
	        String s="��\t�@\t�G\t�T\t�|\t��\t��\n";
	        for(counter=0;counter<first_day;counter++){
	           s+="\t";
	        }//end for loop
	        for(days=1;days<=end_day;days++){
			  s+=Integer.toString(days)+"\t"; 	
	          if((first_day+days)%7==3&&days!=2){
	             s+="\n";
	          }
	          if(days==4){
	               days=15;
	              s+=Integer.toString(days)+"\t";
	          }			 
	        }//end for loop
	       System.out.println(s);
   }//close method special_program
}//close class ItaDate


class FDate extends NewDate{
	/*�H�U���p��Ӧ~�Ӥ릳�X�Ѥ��Ƶ{���G�]��1582�~���e���|�~�@�|�A
	 1582�~�H���|�~�@�|�A�{�ʤ��|�A�ӥ|�ʤS�n�|�A�G�����H�U���p�C*/
	int  count_days(int year,int month){
		int days;
		if(year<=1582&&year%4==0&&month==2){
			days=29;
		}
		else if(year>1582&&((year%4==0&&year%100!=0)||year%400==0)&&month==2){
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
	//(1)�b�褸1582�~11��(�]�t11��)�H�褸1�~1��1��P��������ǡA
	//��mod 7���l�ƨӭp��ҨD�~�몺�Ĥ@�Ѭ��P���X
	//(2)�k���k�b�褸1582�~12�릳�վ�L
	//�ӭp��ҨD�Ӧ~�Ӥ�Ĥ@�ѬO�P���X
	//(3)�褸1582�~�H��H1583�~1��1��P�����̬���ǡA��mod7�l�ƨӭp��
	//1583�~��|�s�@�|�A�{�ʤ��|�A���C�|�ʦ~�S�m�|�~)
      int count_first_day(int year,int month){
    	  int f_day=0;
    	  if(year<1582||(year==1752&&month<=11)){
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
    	  
    	  
    	  else if(year>1582){
    		  f_day=6;
    		  for(int i=1583;i<year;i++){
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
 	 /* �����S�Ҥ��Ƶ{���A�ѩ�1582�~12��L10��19��A�G�g�@�M���B�z�Ӧ~�뤧�Ƶ{���C */
	   void special_program(){
	        int counter,days,first_day,end_day;
	        first_day=6;
	        end_day=31;
	        System.out.println("\t   �褸     1582       �~        12        �� ");
	        String s="��\t�@\t�G\t�T\t�|\t��\t��\n";
	        for(counter=0;counter<first_day;counter++){
	           s+="\t";
	        }//end for loop
	        for(days=1;days<=end_day;days++){
			  s+=Integer.toString(days)+"\t"; 	
	          if(((first_day+days)%7==0&&days!=22&&days!=29)||days==25){
	             s+="\n";
	          }
	          if(days==9){
	               days=20;
	              s+=Integer.toString(days)+"\t";
	          }			 
	        }//end for loop
	       System.out.println(s);
   }//close method special_program
}//close class FDate
class CNDate extends NewDate{
	//�H�U���p��Ӧ~�Ӥ릳�h�֤ѡA�]���^����k�b1752�~�e�ĥ|�~�@�|�F
	//1752�~��|�s�@�|�A�{�ʤ��|�A���C�|�ʦ~�S�m�|�~
	
	 int  count_days(int year,int month){
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
      int count_first_day(int year,int month){
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
	   void special_program(){
	        int counter,days,first_day,end_day;
	        first_day=2;
	        end_day=30;
	        System.out.println("\t   �褸     1752       �~        9       �� ");
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
}//close  class CNDate

class CEDate extends NewDate{
	//�p��Ӧ~�Ӥ릳�h�֤ѡA�]�������B���µ���b1700�~�H�e�ĥ|�~�@�|�A
	//1700��ĥ|�~�@�|�A�C�@�ʦ~���|�A�C�|�ʦ~�S�m�|�~
	int count_days(int year,int month){
		int days;
		if(year<1700&&year%4==0&&month==2){
			days=29;
		}
		else if(year>1700&&(year%4==0&&year%100!=0)||year%400==1&&month==2){
			days=29;
		}
		else if(year==1700&&month==2){
			days=18;
		}
		else if(month==1||month==3||month==5||month==7||month==8||month==10|month==12){
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
		//(1)�b�褸1700�~2��(���]�t2��)�H�褸1�~1��1��P��������ǡA
		//��mod 7���l�ƨӭp��ҨD�~�몺�Ĥ@�Ѭ��P���X
		//(2)�^����k�b�褸1700�~2�릳�վ�L�A1700�~3~12��H1700�~3��1��P���@������I�A��mod 7�l��
		//�ӭp��ҨD�Ӧ~�Ӥ�Ĥ@�ѬO�P���X
		//(3)�褸1701�~�H��H1701�~1��1��P�����̬���ǡA��mod7�l�ƨӭp��
		//1700�~��|�s�@�|�A�{�ʤ��|�A���C�|�ʦ~�S�m�|�~)
	int count_first_day(int year,int month){
		int f_day=0;
		if(year<1700||(year==1700&&month==1)){
			f_day=6;
			for(int i=1;i<year;i++){
				if(year%4==0){
					f_day=(f_day+366)%7;
				}
				else{
					f_day=(f_day+365)%7;
				}
			}//end for loop(�p��ҨD�Ӧ~�@��@�鬰�P���X)
			for(int j=1;j<month;j++){
				f_day=(f_day+count_days(year,j))%7;
			}//end for loop(�p��ҨD�Ӧ~�Ӥ�@�鬰�P���X)
		}
		
		else if(year==1700&&month>=3){
			f_day=1;
			for(int j=3;j<month;j++){
				f_day=(f_day+count_days(year,j))%7;
			}
		}
		else if(year>1700){
			f_day=6;
			for(int i=1701;i<year;i++){
				if((year%4==0&&year%100!=0)||year%400==0){
					f_day=(f_day+366)%7;
				}
				else{
					f_day=(f_day+365)%7;
				}
			}//end for loop(�p��ҨD�Ӧ~�@��@�鬰�P���X)
			for(int j=1;j<month;j++){
				f_day=(f_day+count_days(year,j))%7;
			}//end for loop(�p��ҨD�Ӧ~�Ӥ�@�鬰�P���X)
		}
		//�٦�1700�~2��o�ӯS�ҡA�ڭ̿W�ߥX�@��method�ӱM���B�z
		return (f_day);
	}//close method int count_first_day
	void special_program(){
		int counter,days,first_day,end_day;
		first_day=4;
		end_day=18;
		System.out.println("\t   �褸     1700       �~        2      �� ");
		String s="��\t�@\t�G\t�T\t�|\t��\t��\n";
		for(counter=0;counter<first_day;counter++){
			s+="\t";
		}//end for loop
		for(days=1;days<=end_day;days++){
			s+=Integer.toString(days)+"\t";
			if((first_day+days)%7==0){
				s+="\n";
			}
		}//end for loop
		System.out.println(s);
	}//close method special_program
}//close class CEDate