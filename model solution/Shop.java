import java.util.ArrayList;
import java.util.TreeMap;

public class Shop {

	private String name;
	private ArrayList<Product> products; 
	private ArrayList<GoldCoin> coinBox;
	private TreeMap<String, Integer> customerTotalSpend;
	
	public Shop(String name) {
		
		this.name = name;
		products = new ArrayList<Product>();
		coinBox = new ArrayList<GoldCoin>();
		customerTotalSpend = new TreeMap<String, Integer>();
		
	}
	
	public void updateTotalSpend(Customer customer, int coins) {
		
		if ( customerTotalSpend.get(customer.getName()) == null ) {
			
			customerTotalSpend.put(customer.getName(), coins);
			
		} else {
			
			customerTotalSpend.put(customer.getName(), customerTotalSpend.get(customer.getName()) + coins);
			
		}
		
	}
	
	public void addProduct(Product product) {
		
		products.add(product);
		
	}
	
	public boolean removeProduct(Product product) {
		
		return products.remove(product);
		
	}
	
	public Product searchProduct(String name) {
		
		for ( Product product : products ) {
			
			if ( product.getName().equals(name) ) {
				
				return product;
				
			}
			
		}
		
		return null;
		
	}
	
	public void addGoldCoin(GoldCoin goldCoin) {
		
		coinBox.add(goldCoin);
		
	}
	
	public int getNumberOfGoldCoins() {
		
		return coinBox.size();
		
	}
	
	
	public String toString() {
		
		return name + " " + products;
		
	}
	
}
