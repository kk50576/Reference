package tw.org.iii;

import java.util.HashMap;

public class Mars55 {

	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap<>();
		map.put("username","Mars");
		map.put("stage","3");
		map.put("gender","male");
        System.out.println(map.get("username"));
	}

}
