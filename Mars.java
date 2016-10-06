package tw.org.iii;

public class Mars{

	public static void main(String[] args) {
		Bike myBike=new Bike();
		Bike urBike=new Bike();
		System.out.println(myBike.getSpeed());
		System.out.println(urBike.getSpeed());
        System.out.println("----------------");
        myBike.upSpeed();
        myBike.upSpeed();
        myBike.upSpeed();
        System.out.println("myBike:"+myBike.getSpeed());
        System.out.println("urBike:"+urBike.getSpeed());
        System.out.println("----------------");
        int count=0;
        while(myBike.getSpeed()<10){
        	myBike.upSpeed();
        	count++;
        }      
        System.out.println("myBike:"+myBike.getSpeed());
        System.out.println(count);
	}

}
