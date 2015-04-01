/**
 * 
 */
package marathon.finalProj.ApplicationUtil;


import java.util.Scanner;

/**
 * AppValidator class to get the validated input from the user
 *
 */
public class AppValidator {
	
	/**
	 * Get the user input string
	 * @param sc Scanner
	 * @param prompt- user entry prompt
	 * @return string value
	 */
	 public static String getString(Scanner sc, String prompt)
	    {
	        System.out.print(prompt);
	        String s = sc.next();        // read the first string on the line
	        sc.nextLine();               // discard any other data entered on the line  
	        return s;
	    }
	 
	 /**
	  * Get the required string from the user 
	  * @param sc scanner
	  * @param prompt user entry prompt
	  * @return string value
	  */

	 public static String getRequiredString(Scanner sc, String prompt)
	    {
	        String s = "";
	        boolean isValid = false;
	        while (isValid == false)
	        {
	            System.out.print(prompt);
	            s = sc.nextLine();
	            if (s.equalsIgnoreCase("Y") || s.equalsIgnoreCase("N"))
	            {
	            	 isValid = true;
	            }
	            else
	            {
	            	 System.out.println("Error! A valid entry is required. Try again.");
	                 continue; 
	            }
	        }
	        return s;
	    }
	 /**
	  * Get the required integer from the user
	  * @param sc scanner
	  * @param prompt user entry prompt
	  * @return  integer value
	  */
	 public static int getInt(Scanner sc, String prompt)
	    {
	        boolean isValid = false;
	        int i = 0;
	        while (isValid == false)
	        {
	            System.out.print(prompt);
	            if (sc.hasNextInt())
	            {
	                i = sc.nextInt();
	                isValid = true;
	            }
	            else
	            {
	                System.out.println("Error! Invalid integer value. Try again.");
	            }
	            sc.nextLine();  // discard any other data entered on the line
	        }
	        return i;
	    }
/**
 * Get the user input integer value within range
 * @param sc - scanner
 * @param prompt - the user entry prompt
 * @param min - min integer value
 * @param max- max integer value
 * @return integer value
 */
	    public static int getIntWitinRange(Scanner sc, String prompt,int min, int max)
	    {
	        int i = 0;
	        boolean isValid = false;
	        while (isValid == false)
	        {
	            i = getInt(sc, prompt);
	            if (i <= min)
	                System.out.println(
	                    "Error! Number must be greater than " + min);
	            else if (i >= max)
	                System.out.println(
	                    "Error! Number must be less than " + max);
	            else
	                isValid = true;
	        }
	        return i;
	    }
	    /**
	     * Method to get the file name from the user
	     * @param sc Scanner 
	     * @param prompt- user entry prompt statement
	     * @param extn- it is the extension of the file expected .txt for text file and .xml for XML file 
	     * @return filename user input
	     */
	    public static String getFileName(Scanner sc, String prompt,String extn)
	    {
	    	String s="";
	    	boolean isValid = false;
	        while (isValid == false)
	        {
	        	s=getString(sc,prompt);
	        	int dot=s.indexOf('.');
	        	String extension=s.substring(dot+1);
	        
	        	if(!extension.equalsIgnoreCase(extn))
	        	   System.out.println("Error ! Input is invalid.");
	            else
	            	isValid = true;
	            
	        }
	    	return s;
	    }

}
