package org.Mars;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.io.OutputStream;
import java.net.Socket;

public class Talkingroom {
static String userName;
JFrame frame;
JPanel background;
JPanel panel;
JPanel panel2;
JTextField incoming,tfAddress,tfPort;
JTextArea outgoing;
JScrollPane scroller;
JButton sendIt,connect;
private ChatClientSocket clientSkt;
	public static void main(String[] args) {
		Talkingroom tRoom=new Talkingroom();
		tRoom.gui(args[0]);
	}//close method main()
	
	public void gui(String name){
	    userName=name;
		frame=new JFrame(userName+"'s MultiChatroom");
		background=new JPanel();
		panel=new JPanel();
		ClockPanel clock=new ClockPanel();
		BoxLayout boxLayout=new BoxLayout(background,BoxLayout.Y_AXIS);
		background.setLayout(boxLayout);
		outgoing=new JTextArea(10,20);
		outgoing.setLineWrap(true);
		scroller=new JScrollPane(outgoing);
		//scroller.add(outgoing);
		incoming=new JTextField(20);
		sendIt=new JButton("發送");
		panel.add(incoming);
		
		sendIt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				go();
			}
		});
		
		panel.add(sendIt);
		panel2=new JPanel();
		JLabel label1=new JLabel("要連結的ip");
		tfAddress=new JTextField(10);
		JLabel label2=new JLabel("連結的port");
		tfPort=new JTextField(10);
		connect=new JButton("Connect");
		//設定connect按鈕事件處理
		connect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				setConnect();
				tfAddress.setText("");
				tfPort.setText("");
			}
		});
		panel2.add(label1);
		panel2.add(tfAddress);
		panel2.add(label2);
		panel2.add(tfPort);
		panel2.add(connect);
		//
		background.add(clock);
	    background.add(scroller);
	    background.add(panel);
	    background.add(panel2);
	    frame.getContentPane().add(BorderLayout.CENTER,background);
	    
	    frame.setSize(320,400);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}//close method gui(String)
	
	public void go(){
		clientSkt.dataOutput(incoming.getText());
		//String sb=incoming.getText();
		incoming.setText("");
		//outgoing.append(userName+":"+sb+"\n");
		
	}//close method go()
	public void update() {
        outgoing.append(clientSkt.getMessage());
}
	public void setConnect(){
		try{
			int port=Integer.parseInt(tfPort.getText());
		    clientSkt=new ChatClientSocket(tfAddress.getText(),port);
		    clientSkt.setMessageObserver(this);
		    clientSkt.start();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		    
	}//close method setingNetwork
	//處理客戶端連線的Thread ChatClientSocket
	//(採用inner class的方式，可以另外獨立一個public class,
	//
	
}//close class Talkingroom








































































































































































































































































































































































































































































































































































































































































































































































































