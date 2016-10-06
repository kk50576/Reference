package tw.org.iii;

import java.util.*;
public class Mars51 {

	public static void main(String[] args) {
		TreeSet<Integer> set=new TreeSet();
//		set.add(12);
//		set.add("Mars");
//		set.add("Mingying,I like you");
//		set.add(12.3);
//		set.add("Mingying,I like you");
//		set.add(123.15);
//		set.add(12);
//		set.add(true);
//		set.add("Mingying,I like you");
//		set.add("Mingying,I like you");
//		set.add(10>12);
		while(set.size()<6){
			int rand=(int) (Math.random()*42+1);
			set.add(rand);
		}
        System.out.println(set);
        System.out.println(set.size());
        Iterator it=set.iterator();
        while(it.hasNext()){
        	System.out.print(it.next()+",");
        }//end while loop
        System.out.println();
        System.out.println("----------------------");
        for(Integer in:set){
        	System.out.print(in+",");
        }
	}

}
