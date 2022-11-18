package poorvikaMobiles;

import java.io.*;
import java.util.*;

public class PoorvikaMobileOperations implements PoorvikaMobileActions, Runnable
{

	LinkedList<PoorvikaMobileDetails> poorvikaData = null;
	ArrayList<PoorvikaMobileDetails> cartData = new ArrayList<PoorvikaMobileDetails>();
	
	File file = new File("F:\\Samples\\PoorvikaDatas.txt");
	
	FileInputStream fis = null;
	ObjectInputStream ois = null;
	
	FileOutputStream fos = null;
	ObjectOutputStream oos = null;
	
	public PoorvikaMobileOperations()
	{
		
//		poorvikaData.add(new PoorvikaMobileDetails("Vivo","Y35","8GB RAM, 128GB Internal Memory", 18499.0, "Available",0));
//		poorvikaData.add(new PoorvikaMobileDetails("Oppo","A3s","4GB RAM, 32GB Internal Memory", 10599.0, "Available",0));
//		poorvikaData.add(new PoorvikaMobileDetails("Apple","IphoneX","8GB RAM, 256GB Internal Memory", 64789.0, "Available",0));
//		poorvikaData.add(new PoorvikaMobileDetails("Vivo","Y16","4GB RAM, 64GB Internal Memory", 12499.0, "Avaialble",0));
//		poorvikaData.add(new PoorvikaMobileDetails("RealMe", "C11", "4GB RAM, 64GB InternalMemory", 8999.0, "Available",0));
//		poorvikaData.add(new PoorvikaMobileDetails("OnePlus", "N20", "4GB RAM, 64GB InternalMemory", 15950.0, "Available",0));
//		affect();
	}
	
	public void listMobileDetails()
	{
		fetch();
		for(PoorvikaMobileDetails data:poorvikaData)
		{
			System.out.println(  "--------------------------------------------------------"
							  +"\n Mobile Brand: "+data.getMobileBrand()
							  +"\n Model: "+data.getMobileModel()
							  +"\n Specifications: "+data.getMobileSpecifications()
							  +"\n Price: "+data.getMobilePrice()
							  +"\n Stocks: "+data.getMobileStocks()
							  +"\n--------------------------------------------------------");
		}
	}

	void showChoice()
	{
	 try
	 {
		System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Welcome to Poorvika Mobiles >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
		System.out.println("Here is a list of Available Mobiles:");
		listMobileDetails();	
		Scanner scan = new Scanner(System.in);
		do 
		{
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::"
							+"\n:: Please select a choice:                             ::"
							+"\n::  1.List your cart                                   ::"
							+"\n::  2.Add a Mobile to your cart                        ::"
					        +"\n::  3.Update your cart                                 ::"
							+"\n::  4.Delete a item from your cart            	       ::"
							+"\n::  5.Search a Mobile from Available List      	       ::"
							+"\n::  6.Sort the Available List                          ::"
							+"\n::  7.Exit                                             ::"
							+"\n:::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
			
			System.out.print("Enter the choice number here... \n");
			switch(scan.nextInt())
			{
			case 1:
				listCart();
				break;
			case 2:
				addToCart();
				break;	
			case 3:
				 if(cartData.isEmpty())
					{
						System.out.println("Your cart is empty..");
						break;
					}
				 else
				 {
					 System.out.println("Enter the Mobile Brand name and Model to update:");
					 updateCart(scan.next(), scan.next());
						break;
				 }
			case 4:
				if(cartData.isEmpty())
				{
					System.out.println("Your cart is empty..");
					break;
				}
				else
				{
					System.out.println("Enter the Mobile Brand name and Model to delete:");
					deleteFromCart(scan.next(), scan.next());
					break;
				}
			case 5:
				System.out.println("Enter the Mobile Brand to search from the available list:");
				searchFromList(scan.next());
				break;
			case 6:	
				System.out.println("Enter the field to sort: BrandName & Price ");
				sortList(scan.next());
				break;
			case 7:
				return;
			default:
				throw new PoorvikaException();
			}
			 try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
		}
		while(true);
	 }
	 catch(PoorvikaException | InputMismatchException exe)
	 {
		 System.out.println(exe);
		 showChoice();
	 }
	}

	@Override
	public void addToCart() 
	{
		Scanner scan = new Scanner(System.in);
	 try
	 {
		System.out.println("Enter the Mobile Brand name:");
		String mobileName = scan.next();
		
		System.out.println("Enter the Mobile model:");
		String mobileModel = scan.next();
		
		System.out.println("Enter the Quantity:");
		int mobileQuantity = scan.nextInt();
		
		for(PoorvikaMobileDetails data:poorvikaData)
		{
			if(data.getMobileBrand().equalsIgnoreCase(mobileName) && data.getMobileModel().equalsIgnoreCase(mobileModel))
			{
				data.setQuantity(mobileQuantity);
				cartData.add(data);
				System.out.println(data.getMobileBrand()+" "+data.getMobileModel()+" is added to your cart.");
				return;
			}
		}
		throw new PoorvikaException();
	 }
	 catch(InputMismatchException | PoorvikaException exe)
	 { 						
		 Scanner scanX = new Scanner(System.in);
		 System.out.println("---------------------------\n"
				 		  + " Press 1=> go to main menu \n"
				 		  + " Press 2=> continue        \n"
				 		  + "---------------------------");
		 int input = scanX.nextInt();
		 if(input==1)
		 {
			return;
		 }	
		 
			System.out.println(exe+" 'Please enter valid input'");
			addToCart();
	 }
	}

	@Override
	public void listCart() 
	{
		if(cartData.isEmpty())
		{
			System.out.println("Your cart is empty..");
		}
		else
		{
			for(PoorvikaMobileDetails data:cartData)
			{
				System.out.println("--------------------------------------------------------"
								  +"\n Mobile Brand: "+data.getMobileBrand()
								  +"\n Model: "+data.getMobileModel()
								  +"\n Specifications: "+data.getMobileSpecifications()
								  +"\n Price: "+data.getMobilePrice()
								  +"\n Quantity: "+data.getQuantity()
								  +"\n--------------------------------------------------------");	
			}
		}
		
	}

	@Override
	public void updateCart(String MobileBrand, String MobileModel)
	{
		Scanner scan = new Scanner(System.in);
		 try
		 {  
			for(PoorvikaMobileDetails data:cartData)
			{
				if(data.getMobileBrand().equalsIgnoreCase(MobileBrand) && data.getMobileModel().equalsIgnoreCase(MobileModel))
				{
					System.out.println("Now enter your new Quantity to update:");
					int mobileQuantity = scan.nextInt();
					data.setQuantity(mobileQuantity);
					cartData.remove(data);
					cartData.add(new PoorvikaMobileDetails(data.getMobileBrand(), data.getMobileModel(), data.getMobileSpecifications(), data.getMobilePrice(), data.getMobileStocks(),mobileQuantity));
					System.out.println("Your entered "+mobileQuantity+" quantity of "+data.getMobileBrand()+" "+data.getMobileModel() +" has successfully updated in your cart.");
					return;
				}
				
			}
				throw new PoorvikaException();
		 }
		 catch(PoorvikaException | InputMismatchException exe)
		 {
			 Scanner scanX = new Scanner(System.in);
			 System.out.println("---------------------------\n"
	 				  		  + " Press 1=> go to main menu \n"
	 				  		  + " Press 2=> continue        \n"
	 				  		  + "---------------------------");
			 int input = scanX.nextInt();
			 if(input==1)
			 {
				return;
			 }
			 
			 System.out.println(exe+" Please enter available Mobile brand and model again to continue:");
			 updateCart(scan.next(), scan.next());
		 }
		 
	}

	@Override
	public void searchFromList(String MobileBrand)
	{
		 try
		 {
			String listing ="";
			for(PoorvikaMobileDetails data:poorvikaData)
			{
				if(data.getMobileBrand().equalsIgnoreCase(MobileBrand))
				{
					listing ="";		  
					listing +="------------------------------------------------\n"
							+ "Mobile Brand: "+data.getMobileBrand()
							+"\nModel: "+data.getMobileModel()
							+"\nSpecifications: "+data.getMobileSpecifications()
							+"\nPrice: "+data.getMobilePrice()
							+"\nStocks: "+data.getMobileStocks()
						    +"\n------------------------------------------------";
					System.out.println(listing);
				}
				
			}
			if(listing=="")
			{
				throw new PoorvikaException();
			}
		 }
		 catch(PoorvikaException exe)
		 {
			 Scanner scanX = new Scanner(System.in);
			 System.out.println("---------------------------\n"
					 		  + " Press 1=> go to main menu \n"
					 		  + " Press 2=> continue        \n"
					 		  + "---------------------------");
			 int input = scanX.nextInt();
			 if(input==1)
			 {
				return;
			 }

			 System.out.println(exe+" Please enter available brand name:");
			 System.out.println();
			 Scanner scan = new Scanner(System.in);
			 searchFromList(scan.next());
		 }
	}

	@Override
	public void deleteFromCart(String MobileBrand, String MobileModel)
	{
	 try
	 {
		 if(cartData.isEmpty())
			{
				System.out.println("Your cart is empty..");
			}
		 
		for(PoorvikaMobileDetails data:cartData)
		{
			if(data.getMobileBrand().equalsIgnoreCase(MobileBrand) && data.getMobileModel().equalsIgnoreCase(MobileModel))
			{
				cartData.remove(data);
				System.out.println(data.getMobileBrand()+" "+data.getMobileModel()+" was deleted successfully.");
				return;
			}
		}
		throw new PoorvikaException();
	 }
	 catch(PoorvikaException exe)
	 {
		 Scanner scanX = new Scanner(System.in);
		 System.out.println("---------------------------\n"
				 		  + " Press 1=> go to main menu \n"
				 		  + " Press 2=> continue        \n"
				 		  + "---------------------------");
		 int input = scanX.nextInt();
		 if(input==1)
		 {
			return;
		 }
		 
		 System.out.println(exe+" Please only enter data of available brand and model:");
		 Scanner scan = new Scanner(System.in);
		 deleteFromCart(scan.next(), scan.next());
	 }
	}

	@Override
	public void sortList(String field) 
	{
	 try
	 {
		PoorvikaMobileDetails pmdX = null;
		PoorvikaMobileDetails pmdY = null;
		
		LinkedList<PoorvikaMobileDetails> data = new LinkedList<PoorvikaMobileDetails>();
		data.addAll(poorvikaData);
		
		if(field.equalsIgnoreCase("brandname"))
		{
			for(int index=0;index<data.size();index++)
			{
				for(int pos=index+1;pos<data.size();pos++)
				{
					if(data.get(index).getMobileBrand().compareTo(data.get(pos).getMobileBrand())>0)
					{					
						pmdX = data.get(index);
						pmdY = data.get(pos);
						PoorvikaMobileDetails pmd = pmdX;
						pmdX = pmdY;
						pmdY = pmd;
						data.set(index, pmdX);
						data.set(pos, pmdY);	
					}
					
				}	
			}	
			sortData(data);
			return;
		}
		else if(field.equalsIgnoreCase("price"))
		{
			for(int index=0;index<data.size();index++)
			{
				for(int pos=index+1;pos<data.size();pos++)
				{
					if(data.get(index).getMobilePrice()>data.get(pos).getMobilePrice())
					{					
						pmdX = data.get(index);
						pmdY = data.get(pos);
						PoorvikaMobileDetails pmd = pmdX;
						pmdX = pmdY;
						pmdY = pmd;
						data.set(index, pmdX);
						data.set(pos, pmdY);	
					}
				}	
			}
			sortData(data);
			return;
		}
		throw new PoorvikaException();
	 }
	 catch(PoorvikaException exe)
	 {
		 Scanner scanX = new Scanner(System.in);
		 System.out.println("---------------------------\n"
		 				  + " Press 1=> go to main menu \n"
		 				  + " Press 2=> continue        \n"
		 				  + "---------------------------");
		 int input = scanX.nextInt();
		 if(input==1)
		 {
			return;
		 }
		 
		 System.out.println(exe+" Please enter available field:");
		 Scanner scan = new Scanner(System.in);
		 sortList(scan.next());
	 }
	}
	
	public void sortData(LinkedList<PoorvikaMobileDetails> datas)
	{
		for(PoorvikaMobileDetails data:datas)
		{
			System.out.println("--------------------------------------------------------"
							  +"\n Mobile Brand: "+data.getMobileBrand()
							  +"\n Model: "+data.getMobileModel()
							  +"\n Specifications: "+data.getMobileSpecifications()
							  +"\n Price: "+data.getMobilePrice()
							  +"\n Stocks: "+data.getMobileStocks()
							  +"\n--------------------------------------------------------");	
		}
	}
	
	public void fetch()
	{
		try 
		{
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			poorvikaData = (LinkedList<PoorvikaMobileDetails>)ois.readObject();
		} 
		catch (IOException | ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public void affect()
	{
		try 
		{
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(poorvikaData);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	@Override
	synchronized public void run() 
	{
		System.out.println("Welcome "+Thread.currentThread().getName());
		showChoice();
	}
}
