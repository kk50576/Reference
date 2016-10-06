package tw.org.iii;

public class Mars12 {

	public static void main(String[] args) {
		int[]a={1,2,3,4,5};
		int[][]b={{1,2},{3,4,5},{6,7,8,9}};
		int[][][]c={{{1,2},{3,4,5}},{{6,7,8,9},{11,12,13},{14},{15,16,17}},{{1,2},{3,4,5}},{{11,12},{5,6,7},{3,5,8}}};
	    System.out.println(a.length);
	    for (int[][] i:c) {
	    	for(int[]j:i){
	    		for(int k:j){
	    	System.out.println(k);
	    		}
	    	}
	    }
	}

}
