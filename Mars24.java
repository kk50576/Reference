package tw.org.iii;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Mars24 extends JFrame implements ActionListener{
//	public Mars24(){
//		super("My Window App");
//		setSize(640,480);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//}
	 static JButton open,save,exit;
	public static void main(String[] args)throws NullPointerException {
		
		Mars24 obj=new Mars24();
		 open=new JButton("Open");
		 save=new JButton("Save");
		 exit=new JButton("Exit");
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        JTextArea edit=new JTextArea();
        //panel.setLayout(new BorderLayout());
//        panel.add(BorderLayout.CENTER,save);
//        panel.add(BorderLayout.NORTH,open);
//        panel.add(BorderLayout.SOUTH,exit);
        panel.add(save);
        panel.add(open);
        panel.add(exit);
        frame.getContentPane().add(BorderLayout.NORTH,panel);
        frame.getContentPane().add(BorderLayout.CENTER,edit);
//        frame.getContentPane().add(save);
//        frame.getContentPane().add(open);
//        frame.getContentPane().add(exit);
        frame.setSize(100,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        open.addActionListener(obj);
        save.addActionListener(obj);
        exit.addActionListener(obj);
        open.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent a){
				obj.doOpen();
			}});
	}
        void doOpen(){
        	System.out.println("InnerListener");
        }

	
@Override
public void actionPerformed(ActionEvent event) {
	if(event.getSource()== open){
	System.out.println("open");
    }
    else if(event.getSource()==save){
    	System.out.println("save");
    }
    else{
    	System.out.println("exit");
    }
}



}//close class
