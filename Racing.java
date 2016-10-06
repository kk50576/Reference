package tw.org.iii;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Racing extends JFrame{
	private JButton go;
	private JLabel[] lanes;
    private int rank=1;
    private Car[] cars;
    MyClock clock=new MyClock();
	public Racing(){
		setLayout(new GridLayout(10,1));
		add(clock);
		add(go=new JButton("Go!"));
		lanes=new JLabel[8];
		for(int i=0;i<lanes.length;i++){
			add(lanes[i] = new JLabel((i+1) + ". "));
		}//end for loop
		
		setSize(1024,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		go.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				go();
			}
		});
	}//close constructor
	private void go(){
		cars=new Car[8];
		for (int i=0; i<lanes.length; i++){
			lanes[i].setText((i+1) + ". ");
		}//end for loop
		for(int i=0;i<cars.length;i++){
			cars[i]=new Car(i);
		}//end for loop
		for (int i=0; i<cars.length; i++){
			cars[i].start();
		}//end for loop
	}
	private class Car extends Thread{
		private int whichLane;
		Car(int n){whichLane=n;}
		public void run(){
			for(int i=0;i<100;i++){
				lanes[whichLane].setText(
					lanes[whichLane].getText()+">");
				try{
					Thread.sleep((int)(Math.random()*200));
					if(i==99){
						lanes[whichLane].setText(
								lanes[whichLane].getText()+">WINNER");
						stopGame();
						break;
					}
				}
				catch(InterruptedException e){
					  break;
				}
			}//end for loop
		}//close method run()
	}// inner class Car
	private void stopGame(){
		for(int i=0;i<cars.length;i++){
			cars[i].interrupt();
		}
	}
	public static void main(String[] args) {
		new Racing();

	}

}
