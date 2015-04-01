/**
 * 
 */
package marathon.finalProj.ApplicationUtil;

import java.util.Random;

/**
 * A utility for the application to calculate the random number
 *
 */
public class AppUtility {
/**
 * get the random number between 1 to 100
 * @param min- minimum value
 * @param max- maximum value
 * @return random number
 */
	public static int getRandomNumberBetween(int min, int max) 
    {
        Random foo = new Random();
        int randomNumber = foo.nextInt(max - min) + min;
        if(randomNumber == min) {
            return min + 1;
        }
        else {
            return randomNumber;
        }
    }
	/**
	 * get the random number using Math.random
	 * @return random number
	 */
	public static int getRandomNumber()
	{
		int randomNumber=(int)(Math.random()*100);
		return randomNumber;
	}
}
