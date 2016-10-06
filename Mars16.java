package tw.org.iii;

public class Mars16 {
 public static void main(String[] args){
	 TWId myId=new TWId("A123456789");
	 
	 TWId id1=new TWId(true);
	 System.out.println(id1.getId());
	 //TWId urId=new TWId("B234567890");
//	 if(TWId.isRight(id1.getId())){
//		 
//	 }
	 
	 System.out.println(myId.getId());
	 System.out.println(myId.getGender()?"男生":"女生");
	 System.out.println(myId.getArea());
//	 System.out.println(urId.getId());
//	 System.out.println(urId.getGender()?"男生":"女生");
//	 System.out.println(urId.getArea());
//	 
 }
}
