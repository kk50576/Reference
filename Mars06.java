package tw.org.iii;
import javax.swing.JOptionPane;
public class Mars06 {

	public static void main(String[] args) {
		String strYear=JOptionPane.showInputDialog("Year");
		String strMonth=JOptionPane.showInputDialog("Month");
		int intYear=Integer.parseInt(strYear);
		System.out.println(intYear+"/"+strMonth);
	}
}	