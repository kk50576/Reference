package tw.org.iii;

public class Mars22 {

	public static void main(String[] args) {
		String a="0123";
		System.out.println(a.concat("Mars"));
		System.out.println(a.replace('2', 'k'));
		System.out.println(a);
		StringBuffer sb1=new StringBuffer();
		System.out.println(sb1.capacity());
		sb1.append("abc");
		System.out.println(sb1);
		System.out.println(sb1.capacity());
		sb1.append("1234567891011121314151617181920");
		System.out.println(sb1);
		sb1.append("yozi");
		System.out.println(sb1.capacity());
		System.out.println(sb1);
	}

}
