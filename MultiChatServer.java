package org.Mars;

import java.io.*;
import java.net.*;
import java.util.*;
public class MultiChatServer {
    
	public static void main(String[] args) {
		BufferedReader user;
	    String sysopMessage=null;
	    int port=0;
	    
	    System.out.println("多人聊天室伺服器....");
	    System.out.println("連接埠:");
        try{
        	user=new BufferedReader(new InputStreamReader(System.in));
        	port=Integer.parseInt(user.readLine());
        	//啟動伺服器執行序
            ServerThread server=new ServerThread(port);
            System.out.println("伺服器正在啟動.....");
            System.out.println("繫結至連接埠:"+port+"........");
            server.start();
            System.out.println("Ok");
            
            //後台的廣播站
            while((sysopMessage=user.readLine())!=null){
            	if(sysopMessage.equals("shutdown")){
            		System.out.println("伺服器將在五秒後關閉");
            		server.addSysopMessage("伺服器廣播:網站將於五秒後關閉");
            		
            		try{
            			for(int i=0;i<5;i++){
            				Thread.sleep(1000);
            				System.out.println(".");
            			}//end for loop
            		}
            		catch(InterruptedException ire){
            			
            		}
            		break;
            	}//end if
            	else{
            		System.out.println("站台廣播"+sysopMessage);
            	}
            }
        }
        catch(IOException e){
        	System.out.println(e.toString());
        }
        System.out.println("伺服器關閉");
	}//close method main()
}//class MultiChatServer
