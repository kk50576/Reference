package com.Joseph;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
//import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GuessNum {
    JFrame frame;
    JButton button;
    JPanel panel,panel2;
    JLabel label;
    JTextField textField;
    JTextArea textArea;
    static int count;
    static String answer=createAnswer(4);
	public static void main(String[] args) {
         GuessNum guessNum=new GuessNum();
         guessNum.gui();
//         if(count==11){
//    		 JOptionPane.showMessageDialog(null, "��, �|�D, \n���׬O:"+answer);	
//    	 }
	}
 void gui(){
	 //�H�U�O�����t�m
	 frame=new JFrame("GuessNumber");
	 button=new JButton("�q");
	 textField=new JTextField(20);         //��O�̦h��J�G�Q�r�A���O����
	 textArea=new JTextArea(20,100);
	 label=new JLabel("�п�J�|�ӼƦr");
	 panel=new JPanel();
	 panel2=new JPanel();
	 //�s�W�@�ӱ���ʽL
	 JScrollPane scroller=new JScrollPane(textArea);
	 //���}����W�U���ʪ���
	 scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 //���ϥΤ������b
	 scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	 panel.add(label);
	 panel.add(textField);
	 panel.add(button);
	 panel2.add(scroller);
	 frame.setSize(200,400);
	 frame.setVisible(true);
	 frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	 frame.getContentPane().add(BorderLayout.NORTH,panel);
	 frame.getContentPane().add(BorderLayout.CENTER,panel2);
	 //�H�U�O���s�\��
	 button.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent ae){
			 go();
			 //count++;
			 System.out.println(count);
			 if(count>10){
				 JOptionPane.showMessageDialog(frame, "��, �|�D, \n���׬O:"+answer);	
			 }
		 }
	 });
	 //�]��count�O�bbutton.addActionListener����go��k��count++�A���M�Nint count
	 //�w��static int count�A��java�èS��global ��variable�A���Xbutton.addActionListener
	 //�o�Ӥ�k�ɡAcount�|�q�s���� �Ȭ��s�A�ҥH�|�ɭP�U����if�z�y���|�Q����
	 //�ѨM��k���G�A�@�O�Nif�z�y���go()���A�G�O�Nif�z�y���button.addActionListener��
//	 if(count>10){
//		 JOptionPane.showMessageDialog(frame, "��, �|�D, \n���׬O:"+answer);	
//	 }
	 
 }//close method gui
	

void go(){
	 String playerGuess=textField.getText();
	 textField.setText("");
	 String result=checkAB(answer,playerGuess);
		 if(playerGuess.equals(answer)){
	          textArea.append(playerGuess+"=>"+result+"\n");
	          JOptionPane.showMessageDialog(null, "���ߦѷ�,�P�ߤҤH...");
		 }
		 else{
			 textArea.append(playerGuess+"=>"+result+"\n");
		 }
	 count++;
//	 if(count>10){
//		 JOptionPane.showMessageDialog(frame, "��, �|�D, \n���׬O:"+answer);	
//	 }
 }//close method go()
 
 static String checkAB(String answer,String playerGuess){
	 int A=0,B=0;
	 for(int i=0;i<playerGuess.length();i++){
		 if(playerGuess.charAt(i)==answer.charAt(i)){
			A++; 
		 }
		 else if(answer.indexOf(playerGuess.charAt(i))!=-1){
			 B++;
		 }
	 }
	 return A+"A"+B+"B";
 }
 
 static String createAnswer(int n){
		// �~�P
		int[] poker = new int[n];	// 0,0,...0
		int rand;
		boolean isOK;
		for (int i=0; i<poker.length; i++){
			
			do {
				rand = (int)(Math.random()*10);
				// �ˬd����
				isOK = true;
				for (int j=0;j<i;j++){
					if (poker[j]==rand){
						isOK = false;
						break;
					}
				}
				
			}while (!isOK);
			
			poker[i] = rand;
			//System.out.println(poker[i]);
		}
		StringBuffer ret =new StringBuffer("");
		for (int v : poker) ret.append(v);
		  String rets=ret.toString();
		return rets;
	}//close method
}//close class
