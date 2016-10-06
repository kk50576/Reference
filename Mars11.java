package tw.org.iii;

public class Mars11 {

	public static void main(String[] args) {
     
		int[] p=new int[6];
		for(int i=0;i<6;i++){
			int point=(int)(Math.random()*9);  //0-8亂數
			if(point>5){
			point-=3;
			}
			p[point]++;
		}
		for(int i=0;i<p.length;i++){
			System.out.println((i+1)+":"+p[i]);
		}
	}
}
