import java.util.TreeMap;
import java.util.ArrayList;

/**
 *
 *	Creates 'Shop' class. This class contains a definition of its constructor method, 'Shop' as well as methods 
 *	'addProduct', 'removeProduct', 'searchProduct', 'addGoldCoin', 'updateTotalSpend', 'toString' and 'getName'.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class Shop {

	private String name;
	/*	Duplicates are allowed in this collection (ArrayList is a List, which can contain duplicate elements)
	 	The key difference between a Set and other kinds of collections is that it cannot contain duplicate elements.
		Therefore products could be a map or an arraylist
		I use a TreeMap for this collection, as having ordered storage of products in a shop seems more realistic.	*/
	private TreeMap<String, Product> products;
	//	Used in removeProduct method.
	private Product productToRemove;	
	//private String nameOfProduct;
	/*	'The shop prefers to index each coin in their coin box'
		Therefore coinBox should be an array or ArrayList.
		Diamond notation allows a class (not just ArrayList) to work with elements of a provided type.
		Sets do not use indexes so it's not a Set.	*/
	private ArrayList<GoldCoin> coinBox;
	//	The Shop has one last collection: customerTotalSpend which associates the name of a customer with the total amount of gold coins that they have spent in the shop, over multiple transactions. 
	private TreeMap<String, Integer> customerTotalSpend;
	
	/**
	*	Defines 'Shop' method. This is the constructor method for objects of the 'Shop' class. 
	*	The parameters seen below are needed upon the creation of any 'Shop' object.
	*	When we create an object of this class, we are able to specify a value for the name and the collections are initialised
	*	Use of 'this' keyword avoids naming conflicts between the passed parameters and fields of the class.
	*/
	public Shop(String name, int coins) {
		this.name = name;
		
		products = new TreeMap<String, Product>();
		
		coinBox = new ArrayList<GoldCoin>();
		for (int i = 0; i < coins; i++) {
		coinBox.add(new GoldCoin());
		}
		customerTotalSpend = new TreeMap<String, Integer>();
	}

	/**
	*
	*/
	public void addProduct(Product product) {
		products.put(product.getName(), product);
	}
	
	/**
	*
	*/
	public Product removeProduct(Product product) {
		
		productToRemove = product;
		
		products.remove(product.getName());
			
		//	Returns a positive result if the product was succesfully removed.
		if (products.get(product.getName()) == null){
			//	Returns positive (non null) product removed.
			return productToRemove;
		}
		else {
			System.out.println("Product was not properly removed from shop.");
			//	Returns null if the product was not properly removed.
			return null;
		
		}
	}
	
	/**
	*	'searchProduct' method. Searches 'products' via a supplied string value - to which a Product in 'products' may be mapped.
	*/
	public Product searchProduct(String s){
		return products.get(s);
	}
	
	/**
	*
	*/
	public void addGoldCoin(GoldCoin coin){
		coinBox.add(coin);
	}
	
	/**
	*
	*/
	public void updateTotalSpend(Customer customer, int amountOfCoins) {
		if (customerTotalSpend.get(customer.getName()) == null){
			customerTotalSpend.put(customer.getName(), amountOfCoins);
		}
		else {
			
			int temp = customerTotalSpend.get(customer.getName()) + amountOfCoins;
			customerTotalSpend.put(customer.getName(), temp);
		}
	}
	
	/**
	*	'toString' method. Creates a default String representation for some of the important data in this class. 
	*/
	public String toString() {
		return "Name: " + name + ", coinBox: " + coinBox.size() + ", Products: " + products.toString();
		
	}
	
	/**
	*
	*/
	public String getName() {
		return name;
	}
	
}