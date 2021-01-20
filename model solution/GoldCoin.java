
public class GoldCoin {

	private int coinNumber;
	
	private static int numberOfCoins;
	
	public GoldCoin() {
		
		coinNumber = numberOfCoins++;
	
	}
	
	public int readCoin() {
		
		return coinNumber;
		
	}
	
}
