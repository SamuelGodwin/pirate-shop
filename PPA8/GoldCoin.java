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
	*	Defines 'GoldCoin' method. This is the constructor method for objects of the 'GoldCoin' class. 
	*	as parameters from the driver class are assigned to fields in this class.
	*/
	public GoldCoin() {
	
		coinNumber = numberOfCoins++;
	
	}

	/**
	*	'readCoin' method. This is the accessor method for the 'coinNumber' field in this class. 
	*/
	public int readCoin(){
		return coinNumber;
	}

}
