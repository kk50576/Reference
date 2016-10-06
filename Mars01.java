package tw.org.iii;

public class Mars01 {

	public static void main(String[] args) {
	  int a=10,b=3;
	  int c=032;   //八進位
	  int d=10,e=3;
	  int f=d&e;
	  System.out.println(f);
	  if(a-->=10&&++b<=3){
		  System.out.println("OK:a="+a+",b="+b);
	  }
	  else{
		  System.out.println("XX:a="+a+",b="+b);
	  }
//	  //System.out.println(c);
	}

}
