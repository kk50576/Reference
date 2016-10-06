package tw.org.iii;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.HashMap;

public class MyPainter extends JPanel{
	MyPainter painter;
	private LinkedList<LinkedList<HashMap<String,Integer>>> lines,recycle;
	public MyPainter(){
		//setBackground(new Color(100,0,80));  //Color(r,g,b)  r:red,g:green,b:blue
		MyAdapter adapter = new MyAdapter();
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
		lines=new LinkedList();
		recycle=new LinkedList();
	}
    protected void paintComponent(Graphics g){
    	super.paintComponent(g);
    	Graphics2D g2d=(Graphics2D) g;
    	g2d.setColor(new Color(100,0,100));
    	g2d.setStroke(new BasicStroke(4));
    	for(LinkedList<HashMap<String,Integer>> line:lines){
    	    for(int i=1;i<line.size();i++){
    		    HashMap<String,Integer> p0=line.get(i-1);
    		    HashMap<String,Integer> p1=line.get(i);
    		    int p0x=p0.get("x"),p0y=p0.get("y");
    		    int p1x=p1.get("x"),p1y=p1.get("y");
    		    g2d.drawLine(p0x,p0y,p1x,p1y);
    	    }//end for loop
    	}//end for loop
    }//close method paintComponent
    void clear(){
    	lines.clear();
    	repaint();
    }//close method clear
    void undo(){
    	if(lines.size()>0){
    		recycle.add(lines.removeLast());
    		repaint();
    	}
    }//close method undo
    void redo(){
    	if(recycle.size()>0){
    		lines.add(recycle.removeLast());
    		repaint();
    	}
    }//close method redo
    
    void serializable(){
    	try{
    	    FileOutputStream fout=new FileOutputStream(new File("dir1/painter.txt"));
    	    ObjectOutputStream os=new ObjectOutputStream(fout);
    	    os.writeObject(lines);
    	    os.flush();
    	    os.close();
    	    fout.close();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }//close method serializable()
    
    void Restore(){
    	//lines=new LinkedList<>();
    	try{
    		FileInputStream fin=new FileInputStream(new File("dir1/painter.txt"));
            ObjectInputStream ois=new ObjectInputStream(fin);
            lines=(LinkedList)ois.readObject();
            ois.close();
            fin.close();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }//close method Restore
    
    void Save(){
    	JFileChooser fileSave=new JFileChooser();
    	fileSave.showSaveDialog(painter);
    	saveFile(fileSave.getSelectedFile());
    }//close method Save
    void saveFile(File file){
    	try{
    		FileOutputStream fout=new FileOutputStream(file);
            ObjectOutputStream os=new ObjectOutputStream(fout);
            os.writeObject(lines);
            os.flush();
            fout.close();
            os.close();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }//close method saveFile
    
    void Load(){
    	JFileChooser fileLoad=new JFileChooser();
    	fileLoad.showOpenDialog(painter);
    	loadFile(fileLoad.getSelectedFile());
    }//close method Load
    void loadFile(File file){
    	try{
    	  FileInputStream fin=new FileInputStream(file);
    	  ObjectInputStream oin=new ObjectInputStream(fin);
    	  lines=(LinkedList) oin.readObject();
    	  fin.close();
    	  oin.close();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    }
    private class MyAdapter extends MouseAdapter{
    	public void mouseDragged(MouseEvent e){
    		super.mouseDragged(e);
    		addPoint(e);
    		repaint();
    	}
    	public void mousePressed(MouseEvent e){
    		super.mousePressed(e);
    		LinkedList<HashMap<String,Integer>> line=new LinkedList<>();
    		lines.add(line);
    		addPoint(e);
    		recycle.clear();
    	}
    	private void addPoint(MouseEvent e){
    		HashMap<String,Integer> point=new HashMap<>();
    		point.put("x",e.getX());
    		point.put("y", e.getY());
    		lines.getLast().add(point);
    	}
    }//close inner class MyAdapt
    
}//close class MyPainter
