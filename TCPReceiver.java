package tw.org.iii;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.IOException;

public class TCPReceiver {
//Listener
	public static void main(String[] args) {
		try{
			ServerSocket server=new ServerSocket(7777);
			//System.out.println("before");
			Socket socket=server.accept();
			//System.out.println("after");
			InputStream in=socket.getInputStream();
			int c;
			StringBuffer sb=new StringBuffer();
			while((c=in.read())!=-1){
				sb.append((char) c);
			}
			server.close();
			//System.out.println("Rec OK");
			System.out.println(sb);
		}
		catch(IOException e){
			
		}

	}

}
