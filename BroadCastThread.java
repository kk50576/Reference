package org.Mars;

import java.io.*;
import java.net.*;
import java.util.*;

public class BroadCastThread extends Thread{

  private Vector _clientVector;//儲存連線的客戶端
  private Vector _messageVector;//儲存廣播訊息
  
  public BroadCastThread(){
	  setDaemon(true);
	  _clientVector=new Vector();
	  _messageVector=new Vector();
  }//close constructor BroadCastThread
  
  public void addClientThread(ClientThread client){
	  _clientVector.addElement(client);
  }//close method addClientThread
   
  public void removeClientThread(ClientThread client){
	  _clientVector.removeElement(client);
  }//close method removeClientThread
  
  public void addMessage(String message){
	  _messageVector.addElement(message);
  }//close method addMessage
  
  public void run(){
	  ClientThread client=null;
	  String message=null;
	  try{
		  while(true){
			  //每兩秒廣播一次
			  Thread.sleep(2000);
			  //取出要廣播的訊息
			  //目前沒有訊息就不處理接下來的內容
			  if(_messageVector.isEmpty()){
				  continue;
			  }  
			  message=(String) _messageVector.firstElement();
			  _messageVector.removeElement(message);
			  
			  //將訊息一個一個丟給客戶端
			  for(int i=0;i<_clientVector.size();i++){
				  client=(ClientThread) _clientVector.elementAt(i);
				  client.sendMessage(message);
			  }//end for loop
		  }//end while loop
	  }
	  catch(InterruptedException ie){
		  System.out.println(ie.toString());
	  }
  }
}//close class BroadCastThread
