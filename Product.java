import java.util.TreeMap;

/**
 *
 *	Creates 'Product' class. This class contains a definition of its constructor method, 'Product' as well as methods 
 *	'getName', 'getPrice', and 'toString'.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class Product {

	private String name;
	private int price;	
	private TreeMap<String, GoldCoin> itemPrices;
	
	/**
	*
	*/
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
		itemPrices = new TreeMap<String, GoldCoin>();
	}
	
	/**
	*
	*/
	public String getName(){
		return name;
	}
	
	/**
	*
	*/
	public int getPrice(){
		return price;
	}

	/**
	*	'toString' method. Creates a default String representation for some of the important data in this class. 
	*/
	public String toString() {
		return "Product[name=" + name + ", price=" + price + "]";
	}
}