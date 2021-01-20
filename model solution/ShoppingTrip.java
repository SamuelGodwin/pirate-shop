import java.util.Scanner;

public class ShoppingTrip {

	public static void main(String[] args) {
		
		Product diamond = new Product("Diamond", 40);
		Product crownJewels = new Product("Crown Jewels", 100);
		Product silverLocket = new Product("Silver Locket", 60);
		
		Shop shop = new Shop("Hidden Hideaway");
		
		for ( int i = 0; i < 125; i++) {
			
			shop.addGoldCoin(new GoldCoin());
			
		}
		
		shop.addProduct(diamond);
		shop.addProduct(crownJewels);
		shop.addProduct(silverLocket);
		
		Customer martin = new Customer("Chapbeard");
		
		for ( int i = 0; i < 100; i++ ) {
			
			martin.addCoin(new GoldCoin());
			
		}
		
		System.out.println(martin.getName() + " " + martin.coinsInPurse());
		
		System.out.println("Welcome!");
		
		Scanner in = new Scanner(System.in);
		
		String input;
		
		do {
			
			System.out.println("What's in the shop: " + shop);
			System.out.println("Customer's basket: " + martin.getShoppingBasket());
			System.out.println("Customer's wallet: " + martin.coinsInPurse());
			
			input = in.nextLine();
			
			if ( input.equals("add product") ) {
				
				input = in.nextLine();
				
				if ( shop.searchProduct(input) != null ) {
					
					martin.addToShoppingBasket(shop.searchProduct(input));
					shop.removeProduct(martin.searchShoppingBasket(input));
					
					
				} else {
					
					System.out.println("Product not found");
					
				}
				
			} else if ( input.equals("remove product") ) {
				
				input = in.nextLine();
				
				if ( martin.searchShoppingBasket(input) != null ) {
					
					shop.addProduct(martin.searchShoppingBasket(input));
					martin.removeFromShoppingBasket(shop.searchProduct(input));
					
				} else {
					
					System.out.println("Item not in basket");
					
				}
				
			} else if ( input.equals("purchase" ) ) {
				
				if ( !martin.purchaseProducts(shop) ) {
					
					System.out.println("purchase failed");
					
				} else {
					
					System.out.println("purchase successful");
					
				}
				
			}
			
		
		} while ( !input.equals("exit") );
		
		in.close();
		
	}
	
}
