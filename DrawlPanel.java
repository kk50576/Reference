package tw.org.iii;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//serializable按鈕會將LinkedList<HashSet<String,Integer>> 給續列化成單一檔案在次按下按鈕後，
//新的序列畫會蓋掉原先的檔案，較不自由，會在另外做save,可以自由選擇儲存位置，也不會蓋掉舊檔
public class DrawlPanel extends JFrame{
	private MyPainter painter;
	private JButton clear,undo,redo,savePng,serializable,restore,save,load;
	private MyClock clock;
    public  DrawlPanel(){
         setLayout(new BorderLayout());
         clear = new JButton("Clear");
         undo=new JButton("undo");
         redo=new JButton("redo");
         savePng=new JButton("savePng");
         //按下按鈕，將  LinkedList<HashSet<String,Integer>> 給續列化
         serializable=new JButton("serializable");
         //按下按鈕，將LinkedList<HashSet<String,Integer>> 解序列化
         restore=new JButton("restore");
         save=new JButton("save");
         load=new JButton("load");
         clock=new MyClock();
         JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
         top.add(clock);
 		 top.add(clear);
 		 top.add(undo);
 		 top.add(redo);
 		 top.add(savePng);
 		 top.add(serializable);
 		 top.add(restore);
 		 top.add(save);
 		 top.add(load);
 		 add(top, BorderLayout.NORTH);
		 
		 
		 painter = new MyPainter();
		 add(painter, BorderLayout.CENTER);
		
		 setSize(800, 600);
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		 setupEvent();
    }//close constructor
    private void setupEvent(){
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doClear();
			}
		});//end clear ActionListener
		
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doUndo();
			}
		});//end undo ActionListener
		
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doRedo();
			}
		});//end redo AactionListener
		savePng.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				doSaveJpg();
			}
		});//ene savePng ActionListener
		
		serializable.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				doserializable();
			}
		});//end serializabel ActionListener
		
		restore.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			  doRestore();
			}
		});
		
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				doSave();
			}
		});//end save ActionListener
		
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				doLoad();
			}
		});//end load ActionListener
	}//close method setupEvent
	
	private void doClear(){
		painter.clear();
	}//close method doClear
	
	private void doUndo(){
		painter.undo();
	}//close method doUndo
	
	private void doRedo(){
		painter.redo();
	}//close method doRedo
	private void doSaveJpg(){
		BufferedImage bi=new BufferedImage(painter.getWidth(),
				painter.getHeight(),BufferedImage.TYPE_INT_ARGB);
		Graphics g=bi.createGraphics();
		painter.paint(g);
		g.dispose();
		try{
			ImageIO.write(bi,"png", new File("dir1/test.png"));
		}
		catch(Exception e){}
	}//close method doSaveJpg
	
	private void doserializable(){
		painter.serializable();
	}//close method deserializable
	
	private void doRestore(){
		painter.Restore();
		repaint();
	}//close method doRestore
	
	private void doSave(){
		painter.Save();
	}//close method doSave
	private void doLoad(){
		painter.Load();
		repaint();
	}
    public static void main(String[] args){
    	new DrawlPanel();
    }//close main
}//close class DrawlPanel
