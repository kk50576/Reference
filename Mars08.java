package tw.org.iii;

public class Mars08 {
 public static void main(String[] args) {
  for(int k=0;k<5;k++){
	for(int j=1;j<10;j++){
		for(int i=2;i<=5;i++){
		int newi=i+k*4;
		System.out.print(newi+"x"+j+"="+newi*j+" " );
		}
		System.out.println();
	}
	System.out.println("--------------------------------------");
  }		
  }   
}


