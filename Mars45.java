package tw.org.iii;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Mars45 {

	public static void main(String[] args) {
		try{
			ObjectInputStream oin=new ObjectInputStream(
					new FileInputStream("dir1/student.txt"));
			Object obj=oin.readObject();
            Student s1=(Student) obj;
            Student s2=(Student)oin.readObject();
			oin.close();
			System.out.println(s1.pm+":"+s1.name+":"+s1.calTotal());
			System.out.println(s2.pm+":"+s2.name+":"+s2.calTotal());
		}
		catch(IOException | ClassNotFoundException e){e.toString();}

	}

}
