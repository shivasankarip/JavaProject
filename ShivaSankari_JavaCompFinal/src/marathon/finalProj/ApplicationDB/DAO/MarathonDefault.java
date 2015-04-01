/**
 * 
 */
package marathon.finalProj.ApplicationDB.DAO;

import java.util.ArrayList;

import marathon.finalProj.ApplicationDB.Domain.Runner;

/**
 * This class has the method of default runners and adding the hard coded value of Runner Object
 * in the arraylist.
 * It implements the MarathonDAO interface hence overriding the method of the interface RunnerReadable.
 */
public class MarathonDefault implements MarathonDAO{

	/**
	 * This method returns the arrayList of the Runner 
	 * @return array list of the Runner objects
	 */
	@Override
	public ArrayList<Runner> getRunners() {
		  ArrayList<Runner> runners = new ArrayList<>();
		// adding the default runner as a hard coded value   
		runners.add(new Runner("Tortoise",10,0));
		runners.add(new Runner("Hare",100,90));
		return runners;
	}

}
