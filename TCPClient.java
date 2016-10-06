package tw.org.iii;

import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.OutputStream;

public class TCPClient {
      //sender
	public static void main(String[] args) {
		
		
		try{
            Socket socket=new Socket(InetAddress.getByName("10.2.24.148"),7777);
		    
		    OutputStream out=socket.getOutputStream();
		    
		    out.write("Hello,我是許用。我喜歡 Mingying".getBytes());
		    
		    out.flush();
		    out.close();
		    
		    socket.close();
		}
		catch(IOException e){
			
		}

	}

}
