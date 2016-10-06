package org.Mars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

public class ChatClientSocket extends Thread{
    private Socket skt;
    private InetAddress host;
    private int port;
    
    private BufferedReader theInputStream;
    private PrintStream theOutputStream;
    private String message;
    private Talkingroom talkBox;//聊天程式介面
    
    public ChatClientSocket(String ip,int port){
    	try{
    		host=InetAddress.getByName(ip);
    		this.port=port;
    	}
    	catch(IOException ie){
    		JOptionPane.showMessageDialog(null, ie.toString(),
                    "錯誤", JOptionPane.ERROR_MESSAGE);
    	}
    }//close constructor ChatClientSocket
    
    public void setMessageObserver(Talkingroom box){
    	talkBox=box;
    }//close method setMessageObserver
    
    public String getMessage(){
    	return message;
    }//close method getMessage()
    
    public void run(){
    	try{
    	    message="嘗試連線....";
    	    talkBox.update();
    	    
    	    skt=new Socket(host,port);
    	    message="連線成功!\n";
    	    talkBox.update();
    	    theInputStream=new BufferedReader(new InputStreamReader(skt.getInputStream()));
    	    theOutputStream=new PrintStream(skt.getOutputStream());
    	    
    	    while((message=theInputStream.readLine())!=null){
    	    	message= message+"\n";
    	    	talkBox.update();
    	    }//close while
    	    if(message==null){
    	    	skt.close();
    	    	message="連線中斷";
    	    	talkBox.update();
    	    }
    	}
    	catch(IOException ie){
    		ie.printStackTrace();
    	}
    }//close method run
    public void dataOutput(String data) {
        theOutputStream.println(data);
    }//close method dateOutput

}//close class
