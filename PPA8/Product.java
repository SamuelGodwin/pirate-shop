//	Needed if I use a TreeMap in this class
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
	*	Defines 'Product' method. This is the constructor method for objects of the 'Product' class. 
	*	The parameters seen below are needed upon the creation of any 'Product' object.
	*	Use of 'this' keyword avoids naming conflicts between the passed parameters and fields of the class.
	*/
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
		itemPrices = new TreeMap<String, GoldCoin>();
	}
	
	/**
	*	'getName' method. This is the accessor method for the 'name' field in this class. 
	*/
	public String getName(){
		return name;
	}
	
	/**
	*	'getPrice' method. This is the accessor method for the 'price' field in this class. 
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