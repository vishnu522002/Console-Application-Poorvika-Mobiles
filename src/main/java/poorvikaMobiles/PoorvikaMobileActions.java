package poorvikaMobiles;

public interface PoorvikaMobileActions 
{
	public void addToCart();
	public void listCart();
	public void updateCart(String MobileBrand, String MobileModel);
	public void searchFromList(String MobileBrand);
	public void deleteFromCart(String MobileBrand, String MobileModel);
	public void sortList(String field);
	
}
