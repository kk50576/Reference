package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.InetAddress;
public class TCPClient2 {

	public static void main(String[] args) {
	  long start=System.currentTimeMillis();
	  try{
		  Socket client=new Socket(InetAddress.getByName("10.2.24.148"),5566);
		  BufferedOutputStream bout = 
					new BufferedOutputStream(client.getOutputStream());
				BufferedInputStream bin = 
					new BufferedInputStream(
						new FileInputStream("dir1/pili.jpg"));
				int b;
				while ( (b = bin.read()) != -1){
					bout.write(b);
				}
				bin.close();
				bout.flush();
				bout.close();
				client.close();
				System.out.println(System.currentTimeMillis() - start);
				System.out.println("Send OK");
	     }
	      catch(IOException ie){
		  
	  }

	}

}
