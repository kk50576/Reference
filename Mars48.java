package tw.org.iii;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Mars48 {
     //sender
	public static void main(String[] args) {
		while(true){
		String data="Hello,我想要休息";
		byte[] sendData=data.getBytes();
		try{
		    DatagramSocket socket=new DatagramSocket();
		    DatagramPacket packer=new DatagramPacket(sendData,sendData.length,
		    		InetAddress.getByName("10.2.24.118"),8888);
		    socket.close();
		}
		catch(SocketException se){
			
		}
		catch(UnknownHostException ue){
			
		}
		catch(IOException io){
			
		}
		}
	}

}
