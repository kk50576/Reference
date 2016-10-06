package org.Mars;

import java.io.*;
import java.net.*;
import java.util.*;

//伺服器執行序
public class ServerThread extends Thread{
 
	private ServerSocket _serverSkt;
	private BroadCastThread _broadCastThread;
	public ServerThread(int port){
		setDaemon(true);
		//啟動廣播執行序
		_broadCastThread=new BroadCastThread();
		_broadCastThread.start();
		try{
		  _serverSkt=new ServerSocket(port);
		}
		catch(IOException ie){
			System.out.println(ie.toString());
		}
	}//close constructor ServerThread
	public void addSysopMessage(String message){
		_broadCastThread.addMessage(message);
	}//close method addSysopMessage
	
	public void run(){
		Socket clientSkt=null;
		ClientThread client=null;
		try{
			while(true){
				System.out.println("傾聽客戶端....");
				clientSkt=_serverSkt.accept();
				System.out.println(clientSkt.getInetAddress()+"連線......");
			    //啟動一個客戶端執行序，第二個參數指定廣播執行序物件
				client=new ClientThread(clientSkt,_broadCastThread);
				client.start();
				
				//將客戶端加入廣播執行序中管理
				_broadCastThread.addClientThread(client);
			}//end while loop
		}
		catch(IOException ie){
			System.out.println(ie.toString());
		}
	}//close method run()
	public void finallize(){
		try{
			_serverSkt.close();
		}
		catch(IOException ie){
			System.out.println(ie.toString());
		}
	}
}//close class ServerThread