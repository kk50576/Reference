package tw.org.iii;

public class Mars31 {

	public static void main(String[] args) {
		int a=10,b=0;
		int[] c={1,2,3};
		try{
			System.out.println(c[3]);
            System.out.println(a/b);
            
		}
		catch(Exception e){
			System.out.println("Giant");
		}
//		catch(ArrayIndexOutOfBoundsException e){
//			System.out.println("III");
//		}
//		catch( ArithmeticException ae){
//			//ae.printStackTrace();
//			System.out.println("Mars");
//		}
	}

}
