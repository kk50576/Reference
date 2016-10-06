package tw.org.iii;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Mars54 {

	public static void main(String[] args) {
//		HashSet<Integer> set=new HashSet<>();
		String answer=createAnswer(4);
		System.out.println(answer);
		System.out.println("---------------");
		String answerNew=createAnswerv2(5);
        System.out.println(answerNew);
	}
    static String createAnswer(int n){
    	HashSet<Integer> set=new HashSet<>();
    	while(set.size()<n){
    		set.add((int) (Math.random()*10));
    	}
    	StringBuffer sb=new StringBuffer(n);
    	for(Integer i:set) sb.append(i);
    	return sb.toString();
    }//close method createAnswer()
    
    static String createAnswerv2(int n){
    	LinkedList<Integer> list=new LinkedList<Integer>();
    	for(int i=0;i<10;i++)  list.add(i);
    	Collections.shuffle(list);
    	StringBuffer sb=new StringBuffer();
    	for(int i=0;i<n;i++) sb.append(list.get(i));
    	return sb.toString();
    }
}
