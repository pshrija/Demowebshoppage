package genricUtilities;

import java.util.Random;

/**
 * 
 * @author shrija
 *
 */

public class JavaUtilty {
	/**
	 * This method is developed to get the random number with in the given range
	 * This method will take the parameter as the range in the form  of integer
	 * @param range
	 * @return
	 */
	public int getRandomNumber(int range)
	{
		Random r=new Random();
		return(r.nextInt(range));
		
	}
	
	
	

}
