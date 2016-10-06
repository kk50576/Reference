package tw.org.iii;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Mars32 {

	public static void main(String[] args){
		Bird b1=new Bird();
		System.out.println();
		try{
		   BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		   int leg=Integer.parseInt(input.readLine());
		   b1.setLeg(leg);
		   System.out.println(b1.leg);
		}
		
		catch(RuntimeException re){
		     System.out.println("這不是鳥，請重新輸入");
		}
		catch(Exception ie){
			System.out.println("請重新輸入");
		}
	}

}

class Bird{
	int leg;
	void setLeg(int n){
		if(n<0||n>2){
			throw new RuntimeException();
		}
		else{
		    leg=n;
		}
	}
}