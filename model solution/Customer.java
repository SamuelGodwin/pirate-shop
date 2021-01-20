import java.util.ArrayList;

public class Customer {
	
	private ArrayList<Product> shoppingBasket;
	private ArrayList<Product> ownedProducts;
	private ArrayList<GoldCoin> purse;
	private String name;
	
	public Customer(String name) {
		
		shoppingBasket = new ArrayList<Product>();
		ownedProducts = new ArrayList<Product>();
		purse = new ArrayList<GoldCoin>();
		this.name = name;
		
	}
	
	public ArrayList<Product> getShoppingBasket() {
		
		return shoppingBasket;
		
	}
	
	public boolean purchaseProducts(Shop shop) {
		
		int totalCost = 0;
		
		for ( Product product : shoppingBasket ) {
			
			totalCost += product.getPrice();
			
		}
		
		if ( totalCost > purse.size() ) {
			
			return false;
			
		} else {
			
			for ( int coin = 0; coin < totalCost; coin++ ) {
				
				shop.addGoldCoin(purse.remove(purse.size() - 1));
				
			}
			
			for ( Product product : shoppingBasket ) {
				
				addOwnedProduct(product);
				
			}
			
			shoppingBasket.clear();
			
			shop.updateTotalSpend(this, totalCost);
			
			return true;
			
		}
		
	}
	
	public void addToShoppingBasket(Product product) {
		
		shoppingBasket.add(product);
		
	}
	
	public boolean removeFromShoppingBasket(Product product) {
		
		return shoppingBasket.remove(product);
		
	}
	
	public Product searchShoppingBasket(String name) {
		
		for ( Product product : shoppingBasket ) {
			
			if ( product.getName().equals(name) ) {
				
				return product;
				
			}
		}
		
		return null;
		
	}
	
	public void addOwnedProduct(Product product) {
		
		ownedProducts.add(product);
		
	}
	
	public int coinsInPurse() {
		
		return purse.size();
		
	}
	
	public void addCoin(GoldCoin coin) {
		
		purse.add(coin);
		
	}
	
	public String toString() {
		
		return name;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
}
