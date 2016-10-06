package tw.org.iii;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Mars44 {

	public static void main(String[] args) {
		Student s1=new Student(new PM(),"Dave",90,50,75);
		Student s2=new Student(new PM(),"Mingying",80,70,45);
		System.out.println(s1.calTotal());
		System.out.println(s1.calAvg());
        try{
        	ObjectOutputStream oout=new ObjectOutputStream
        			(new FileOutputStream("dir1/student.txt"));
        	oout.writeObject(s1);
        	oout.writeObject(s2);
        	oout.flush();
        	oout.close();
        }
        catch(IOException e){e.toString();}
	}

}//close Mars44


class Student implements Serializable{
	String name;
	PM pm;
	int ch,eng,math;
	Student(PM pm,String name,int ch,int eng,int math){
		this.name=name;
		this.ch=ch;
		this.eng=eng;
		this.math=math;
	}//close constructor
	int calTotal(){return ch+eng+math;}
	double calAvg(){return (ch+eng+math)/3.0;}
}//close class Student

class PM implements Serializable {
	
}