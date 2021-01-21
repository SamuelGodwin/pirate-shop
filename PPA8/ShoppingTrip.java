// Imports 'Scanner' class.
import java.util.Scanner;

/**
 *
 *	Creates 'ShoppingTrip' class. This is the driver class for my solution. It contains the definition for my 'main' method.
 *	This  class is the only class that is to be compiled and run directly, as the compiler will automatically compile my other referenced classes.
 *	This class and its method are public, so are accessible anywhere.	
 *
 */
public class ShoppingTrip {

 	/**
	*	Defines 'main' method. The main purpose of this method is to control objects my 'Product', 'Shop' and 'Customer' classes. 
	*	I also create an object 'in', which is a copy of the 'Scanner' class from Java's Class Library, for user input.
	*	This method is 'void' since it does not return anything.	
	*/
	public static void main(String[] args){	

		Scanner in = new Scanner(System.in);	

		Product product1 = new Product("Diamond", 40);
		Product product2 = new Product("Crown Jewels", 100);
		Product product3 = new Product("Silver Locket", 60);
		System.out.println(product1.toString());
		System.out.println(product2.toString());
		System.out.println(product3.toString());

		
		Shop shop = new Shop("Hidden Hideaway", 125);
		//	Add the products to from the previous question to the shop's products.
		shop.addProduct(product1);
		shop.addProduct(product2);
		shop.addProduct(product3);
		
		System.out.println(shop.toString());
		
		Customer customer = new Customer("Blackbeard", 100);
		System.out.println(customer.toString());
		
		System.out.println("Welcome customer, to the " + shop.getName() + "!");
		
		String userInput="";
		
		do{
			System.out.println("\nEnter an input. Enter 'add product' to add a product to your shopping basket. Enter 'exit' to exit.");
			System.out.println(shop.toString() + "\n"  + customer.toString());
			userInput = in.nextLine();
			
	
			if(userInput.equals("add product")){
				System.out.println("\nEnter a product to add to your basket.");
				String productToAdd = in.nextLine();
				if (productToAdd.equals("exit")){
					break;
				}
				else {
					//	Tests for just in case shop does not contain product corresponding to user input.
					if (shop.searchProduct(productToAdd) != null){
						customer.addToShoppingBasket(shop.searchProduct(productToAdd));
						shop.removeProduct(shop.searchProduct(productToAdd));
					}
					else {
						System.out.println("Product not found in shop!");
					}
				}
			}
			else if(userInput.equals("remove product")){
				System.out.println("\nEnter a product to remove from your basket.");
				String productToRemove = in.nextLine();
				if (productToRemove.equals("exit")){
					break;
				}		
				else {
					//	Tests for just in case shopping basket does not contain product corresponding to user input.
					if (customer.searchShoppingBasket(productToRemove) != null){
						shop.addProduct(customer.searchShoppingBasket(productToRemove));
						customer.removeFromShoppingBasket(customer.searchShoppingBasket(productToRemove));
					}
					else {
						System.out.println("Product not found in shopping basket!");
					}
				}
			}
			else if(userInput.equals("purchase")){
				customer.purchaseProducts(shop, customer);

			}
		}
		while(!userInput.equals("exit"));

		in.close();
	
	}
}