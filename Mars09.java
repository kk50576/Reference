package tw.org.iii;

public class Mars09 {
	public static void main(String[] args){
     for(int j=0;j<10;j++){
		for(int i=1;i<=10;i++){
			int v=j*10+i;
			//判斷是否為質數
		 boolean isOK=true;
		 for(int k=2;k<=v/2;k++){
			 if(v%k==0){
				 //你不是質數
				 isOK=false;
				 break;
			 }
		 }
    	 System.out.print(v+(isOK?"*":"")+"  ");
        }//end for loop
		System.out.println();
     }//end for loop	

	}

}
