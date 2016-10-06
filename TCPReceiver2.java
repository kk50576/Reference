package tw.org.iii;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPReceiver2 {

	public static void main(String[] args) {
		try {
			ServerSocket server = 
				new ServerSocket(5566);
			Socket socket = server.accept();
			
			BufferedInputStream bin = 
				new BufferedInputStream(socket.getInputStream());
			
			BufferedOutputStream bout = 
				new BufferedOutputStream(
					new FileOutputStream("upload/pili.jpg"));
			
			int b;
			while ( (b = bin.read()) != -1){
				bout.write(b);
			}
			
			bout.flush();
			bout.close();
			
			bin.close();
			
			server.close();
			System.out.println("Rec OK!");
		} catch (IOException e) {
			System.out.println("Server:" + e.toString());
		}

	}

}
