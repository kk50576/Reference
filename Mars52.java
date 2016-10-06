package tw.org.iii;

import java.util.LinkedList;

public class Mars52 {

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		list.add(12);
		list.add("Mars");
		list.add(12);
		list.add(12);
		list.add("Mars");
		list.add(2,"iii");
		list.add(6,34);
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(4));
		list.remove(4);
		System.out.println(list);
		for(Object c:list){
			System.out.print(c+",");
		}

	}

}
