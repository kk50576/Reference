package tw.org.iii;

public class TWId {

	
        private String id=null;
        static String check="ABCDEFGHJKLMNPQRSTUVXYWZIO";
        //constructor 如果沒有定義任何constructor，JVM會自動給一個沒參數的constructor
        //但若你有定義任何constructor
        TWId(){
        	this((int)(Math.random()*2)==0,(int)(Math.random()*26));
        }
        TWId(boolean gender){
        	this(gender,(int)(Math.random()*26));
        }
        TWId(int area){
        	this((int)(Math.random()*2)==0,area);
        }
        TWId(boolean gender,int area){
//        	String c0=check.substring(area,area+1);
//        	String c1=gender?"1":"2";
//        	String c2=""+(int)(Math.random()*10);
        	StringBuffer temp=new StringBuffer(check.substring(area,area+1));
        	temp.append(gender?"1":"2");
        	for(int i=0;i<7;i++){
        		temp.append((int)(Math.random()*10));
        	}
        	for(int i=0;i<10;i++){
        		if(isRight(temp.toString()+i)){
        			id=temp.append(i).toString();
        			break;
        		}
        	}//end for loop
        }//end for loop
        TWId(String id){
        	this.id=id;
        }
        //傳回身分證字串
        String getId(){
        	return id;
        }
        //傳回性別
        boolean getGender(){
        	return id.charAt(1)=='1';
//        	int check=id.charAt(1)-48;
//        	if(check==1){
//        	  return true;
//        	}
//        	else{
//        		return false;
//        	}
        	
        }
        //傳回地區
        String getArea(){
        	return "台中市";
        } 
        //是否正確
	   static boolean isRight(String testId){
		   boolean ret=false;
		   if(testId.matches("^[ABCDEFGHIJKLMNOPQXYZ][12][0-9]{8}$")){
			   //String check="ABCDEFGHJKLMNPQRSTUVXYWZIO";
			   int n12=check.indexOf(testId.charAt(0))+10;
			   int n1=n12/10;
			   int n2=n12%10;
			   
			   int n3=Integer.parseInt(testId.substring(1,2));
			   int n4=Integer.parseInt(testId.substring(2,3));
			   int n5=Integer.parseInt(testId.substring(3,4));
			   int n6=Integer.parseInt(testId.substring(4,5));
			   int n7=Integer.parseInt(testId.substring(5,6));
			   int n8=Integer.parseInt(testId.substring(6,7));
			   int n9=Integer.parseInt(testId.substring(7,8));
			   int n10=Integer.parseInt(testId.substring(8,9));
			   int n11=Integer.parseInt(testId.substring(9,10));
			   int total=n1*1+n2*9+n3*8+n4*7+n5*6+n6*5+n7*4+n8*3+n9*2+n10*1+n11;
			   ret= total%10==0;
		   }
		   else{
			   ret=false;
		   }
	    	return ret;
	    }
	   
//	   static boolean preCheck(String testId){
		   
//		   if(testId.length()==10){
//			   if(testId.charAt(1)=='1'||testId.charAt(1)=='2'){
//				   //抽出第一碼=>testId.charAt(0)
//				   //是否為A-Z=>"ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf()"
//			   
//			   }
//			   
//		   }
//		   return checck;
//	   }

}
