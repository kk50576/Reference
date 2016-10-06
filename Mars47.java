package tw.org.iii;

import java.net.InetAddress;
//import java.net.Inet4Address;
import java.net.UnknownHostException;
public class Mars47 {

	public static void main(String[] args) {
		try{
            InetAddress[] ips=InetAddress.getAllByName("www.facebook.com");//getByName()
		    for(InetAddress ip:ips){
            System.out.println(ip.getHostAddress());
		    }
		}
		catch(UnknownHostException ue){
			System.out.println("XX");
		}

	}

}
