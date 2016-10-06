package com.Joseph;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;

public class Lotty {
	JFrame frame;
    JLabel label;
    JPanel background;
    JPanel panel;
    JLabel la;
    JLabel la2;
	public static void main(String[] args) {
		Lotty lotty=new Lotty();
		lotty.gui();
        
	}//close method main()

	void gui(){
		background=new JPanel();
		BoxLayout box=new BoxLayout(background,BoxLayout.Y_AXIS);
		background.setLayout(box);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		JButton button=new JButton("按下按鈕，然後產生一組威力彩號碼");
//		la=new JLabel("第一區號碼");
//		la.setPreferredSize(new Dimension(100, 70));
//		la2=new JLabel("第二區號碼");
//		la2.setPreferredSize(new Dimension(100,70));
		go();
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				background.removeAll();
//				ActionWork worker=new ActionWork();
//				worker.execute();
				go();
				panel.updateUI();
			}
		});
	    frame=new JFrame("給一組威力彩號碼");
		frame.setSize(200,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER,background);
		frame.getContentPane().add(BorderLayout.NORTH,button);
		frame.setVisible(true);
	}//close method gui
	void go(){
		la=new JLabel("第一區號碼");
		//設定JLabel的大小 數字代表像素
		la.setPreferredSize(new Dimension(70, 70));
		la2=new JLabel("第二區號碼");
		la2.setPreferredSize(new Dimension(70,70));
	try{
		int rand;
		GridLayout grid=new GridLayout(2,3);
		grid.setVgap(1);
		grid.setHgap(2);
	    panel=new JPanel(grid);
		String[] num=new String[6];
		int[] nums=new int[6];
		for(int i=0;i<nums.length;i++){
			boolean isOK=false;	
            do{
               rand=(int) (Math.random()*39+1);
		       for(int j=0;j<i;j++){
		    	   if(nums[j]==rand){
		    		   isOK=true;
		    		   break;
		    	   }
		       }//end for loop
		    }while(isOK);
            nums[i]=rand;
		}//end for loop
		//到上面為止亂數產生一個int[6] 元素由1~39的亂數組成<且不重複
		//然後將陣列的元素做排序(由小到大)
            Arrays.sort(nums);
        //下面的迴圈是將數字轉換成String並加到標籤中
        for(int i=0;i<num.length;i++){
            num[i]=Integer.toString(nums[i]);
		    JLabel label=new JLabel(num[i]);
		    label.setPreferredSize(new Dimension(70, 70));
		    panel.add(label);
		}// end for loop(for(int i=...))
		background.add(la);
		background.add(panel);
		background.add(la2);
		String rand2=Integer.toString((int)(Math.random()*9+1));
		JLabel label2=new JLabel(rand2);
		background.add(label2);
	}
	catch(Exception ex){go();}
	}//close go method
	//由於在GUI按鈕事件中執行六次以上迴圈是相當耗時，會使得GUI無法法應，導致GUI在按下按鈕時會沒有會應，
	//可使用SwingWorker來解決
//	class ActionWork extends SwingWorker{
//	     void doInBackground() throws Exception{
//		   go();
//		}
//	}//close inner class ActionWork
}//close class Lotty
