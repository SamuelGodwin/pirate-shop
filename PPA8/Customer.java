//	Needed for 'ownedProducts' collection.
import java.util.TreeMap;
//	Needed for 'shoppingBasket' collection.
import java.util.ArrayList;

/**
 *
 *	Creates 'Customer' class. This class contains a definition of its constructor method, 'Customer' as well as methods 
 *	'addToShoppingBasket', 'removeFromShoppingBasket', 'searchShoppingBasket', 'addCoin', 'addOwnedProduct', 'purchaseProducts', 'getName' and 'toString'.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class Customer {

	private String name;
	private ArrayList<Product> shoppingBasket;
	private Product productToRemove;
	private Product productSearch;
	//	'ownedProducts' which contains the Products that the customer owns currently.
	private TreeMap<String, Product> ownedProducts;
	private ArrayList<GoldCoin> purse;
	private int valueOfBasket;
	private int coinsSpent;
	
	/**
	*	Defines 'Customer' method. This is the constructor method for objects of the 'Customer' class. 
	*	The parameters seen below are needed upon the creation of any 'Customer' object.
	*	When we create an object of this class, we are able to specify a value for the name and the collections are initialised
	*	Use of 'this' keyword avoids naming conflicts between the passed parameters and fields of the class.
	*/
	public Customer(String name, int coins) {
	
		this.name = name;
		shoppingBasket = new ArrayList<Product>();
		ownedProducts = new TreeMap<String, Product>();
		
		purse = new ArrayList<GoldCoin>();
		for (int i = 0; i < coins; i++) {
		purse.add(new GoldCoin());
		}
	}
	
	/**
	*	'addToShoppingBasket' method. Takes a supplied product and adds it to the ArrayList 'shoppingBasket'.
	*/
	public void addToShoppingBasket(Product product) {
		shoppingBasket.add(product);
		valueOfBasket+=product.getPrice();
	}

	/**
	*	'removeFromShoppingBasket' method. Takes a supplied product and removes it from customer's 'shoppingBasket'.
	*/
	public Product removeFromShoppingBasket(Product product) {
		
		productToRemove = product;
		shoppingBasket.remove(product);
		
		//	Returns a positive result if the product was succesfully removed.
		if (searchShoppingBasket(product.getName()) == null){
			valueOfBasket-=product.getPrice();
			//	Returns positive (non null) product which was removed
			return productToRemove;
		}
		else {
			System.out.println("Product was not removed!");
			//	Returns null if the product was not removed properly.
			return null;
		}
	}
		
	/**
	*	'searchShoppingBasket' method. Searches a customer's shoppingBasket for a product via the product's name, which is passed as a parameter.
	*	Use of a for-each loop is acceptable since I do not modify the value of the ArrayList within the loop.
	*/
	public Product searchShoppingBasket(String suppliedName){
		//	Makes sure productSearch is null at the start, in case it has a non-null value from previous use.
		productSearch = null;
		for (Product product : shoppingBasket){
			if (suppliedName.equals(product.getName())){
				productSearch = product;
			}
		}
		//	productSearch will now be either the product that was found, or null if it was not found.
		return productSearch;
	}
	

	/**
	*	'addOwnedProduct' method. Adds a product supplied as a parameter to the customer's 'ownedProducts'.
	*/
	public void addOwnedProduct(Product product) {
		ownedProducts.put(product.getName(), product);

	}
	
	/**
	*	'addCoin' method. Takes a supplied GoldCoin and adds it to this collection. 
	*/
	public void addCoin(GoldCoin coin) {
		purse.add(coin);
	}
	
	/**
	*	'purchaseProducts' method. Manages a transaction wherein GoldCoins are exchanged from a customer's purse to a shop's 'coinBox', in exchange for the products in the
	*	customer's shopping basket.
	*/
	public boolean purchaseProducts(Shop shop, Customer customer){
		int n = valueOfBasket;
		if (valueOfBasket > purse.size()){
			//	Purchase fails.
			System.out.println("Purchase failed. Not enough coins in purse!");
			return false;
		}
		else {
			coinsSpent += valueOfBasket;
			while (n != 0){
				shop.addGoldCoin(purse.get(purse.size()-1));
				purse.remove(purse.size()-1);
				n--;
			}
			for (int i = 0; i < shoppingBasket.size(); i++){
				addOwnedProduct(shoppingBasket.get(i));
				removeFromShoppingBasket(shoppingBasket.get(i));
			}		
			shop.updateTotalSpend(customer, coinsSpent);
			valueOfBasket = 0;
			//	A positive result is then returned.
			return true;
		}			
	}
	
	/**
	*	'getName' method. This is the accessor method for the 'name' field in this class. 
	*/
	public String getName(){
		return name;
	}
	
	/**
	*	'toString' method. Creates a default String representation for some of the important data in this class. 
	*/
	public String toString() {
		//	Return class information as well as the String info of every product in products.
		return "Name: " + name + ", purse: " + purse.size() + ", shoppingBasket: " + shoppingBasket.toString() + ", valueOfBasket: " + valueOfBasket + ", ownedProducts: " + ownedProducts.toString() + ", coinsSpent: " + coinsSpent;
		
	}
			
}