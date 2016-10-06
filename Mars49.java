package tw.org.iii;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class Mars49 {

	public static void main(String[] args) {
		byte[] buf=new byte[1024];
		while(true){
		try{
			DatagramSocket socket=new DatagramSocket(8888);
			DatagramPacket packet=new DatagramPacket(buf,buf.length);
			System.out.println("before");
			socket.receive(packet);
			System.out.println("after");
			socket.close();
			byte[] data=packet.getData();
			int len=packet.getLength();
			InetAddress urip=packet.getAddress();
			System.out.println("Rec OK!"+urip);
			
		}
		catch(Exception e){
			e.toString();
		}

	}
	}

}
