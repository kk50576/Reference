package org.Mars;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientThread extends Thread{
    private Socket _skt;
    private BroadCastThread _broadCastThread;
    private PrintStream _printStream;
    private static int _clientNum=0;//客戶連線數
    
    public ClientThread(Socket skt,BroadCastThread broad){
	    setDaemon(true);
    	_skt=skt;
    	_broadCastThread=broad;
    	
    	try{
    	   _printStream=new PrintStream(_skt.getOutputStream());
    	}
    	catch(IOException ie){
    		System.out.println(ie.toString());
    	}
    	_clientNum++;
    }//close constructor ClientThread
    
    public void sendMessage(String message){
    	_printStream.println(message);
    }//close method sendMessage()
    
    @Override
    public void run() {
    	BufferedReader reader=null;
    	String userMessage=null;
    	String nickName=null;//使用者名稱
    	
    	try{
    		reader=new BufferedReader(new InputStreamReader(_skt.getInputStream()));
    		
    		sendMessage("連線成功!請輸入使用者名稱......");
    		nickName=reader.readLine();	
    		if(nickName.equals("")){
    			 sendMessage("名稱定為guest");
    			 nickName="guest";
    		}	 
    		sendMessage(nickName+"歡迎你! 目前有"+_clientNum+" 人在線上");
    		_broadCastThread.addMessage("::"+nickName+"進入聊天室");
    		
    		//讀取客戶端訊息
    		
    		while((userMessage=reader.readLine())!=null){
    			//離開指令為/bye
    			if(userMessage.equals("/bye")) break;
    		    _broadCastThread.addMessage(nickName+": "+userMessage);
    		}//end for loop
    	}
    	catch(IOException ie){
    	}
    	finally{
    		//連念終止
    		_clientNum--;
    		_broadCastThread.addMessage(nickName+"出聊天室了");
    		_broadCastThread.removeClientThread(this);
    		try{
    			_skt.close();
    		}
    		catch(IOException ie){
    			
    		}
    	}
    }//close method run()
}//close class ClientThread
