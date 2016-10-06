package tw.org.iii;

public class test07 {

	public static void main(String[] args) {
	 int year=2016;
		if(year%4==0){
			if(year%100==0){
				if(year%400==0){
					//29
				}
				else{
					//28
				}
			}
			else{
				//29
			}
		}
		else{
			//28
		}
	}

}
