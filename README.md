# Console-Application-Poorvika-Mobiles
Second Project

Project Title:  Console Application for Poorvika Mobile Shop

Functions:
	1. User can list and see the available mobiles of that shop.
	2. User have a imaginary cart to add the wanted items to their cart. -> ( add by Mobile Brand name, model, quantity from the avaialble list)
	3. User can update their item quantity in the cart.  -> (update by Mobile Brand name, model) = quantity
	4. User can delete the item from their cart. -> (delete by Mobile Brand name, model)
	5. User can search the specified mobile brands in the available list. -> (search by Mobile Brand name in the total available list)
	6. User can sort the available list in two ways by price or mobile name. -> (sort by fields(price, brand name))
	7. User can also exit from the menu. 
													
Implementation:
	  Classes 				            -					Details

	1.PoorvikaMobileDetails		    -  		It has a variable data of the all classes (Mobile Brand Name, Mobile Model, Specifications, Quantity, Price.
	2.PoorvikaMobileActions		    - 		It has a blueprint of methods want to be implemented.
	       (Interface)
	3.PoorvikaMobileOperations    -     		It has the implemented methods of PoorvikaMobileActions(interface).
	4. App					              - 		It is the main class for accessing all the classes and also creating thread.

Disadvantages:
	1. It was not a real application to shop, It only has options -> see the details and add the products to their  imaginary cart.
	2. User can just see the list and do the operations but when the user exits, the file will be not saved.
	3. Here file only used to save the list of mobile details in shop not data of users cart details.
