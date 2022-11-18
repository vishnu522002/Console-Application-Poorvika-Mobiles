package poorvikaMobiles;

public class App 
{
	
	public static void main(String[] args) 
	{
		PoorvikaMobileOperations shop = new PoorvikaMobileOperations();
		
		Thread user1 = new Thread(shop, "Vishnu");
		Thread user2 = new Thread(shop, "Raj");
		user1.start();
		user2.start();
	}

}
