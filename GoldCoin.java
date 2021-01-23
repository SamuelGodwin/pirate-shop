/**
 *
 *	Creates 'GoldCoin' class. This class contains a definition of its constructor method, 'GoldCoin' as well as 'readCoin'.
 *	This class and its methods are public, so are accessible anywhere.
 *
 */
public class GoldCoin {

	private final int coinNumber;
	private static int numberOfCoins;
	
	/**
	*	
	*/
	public GoldCoin() {
	
		coinNumber = numberOfCoins++;
	
	}

	/**
	*
	*/
	public int readCoin(){
		return coinNumber;
	}

}
