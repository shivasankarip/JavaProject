/**
 * 
 */
package marathon.finalProj.ApplicationDB.DAO;

import java.util.ArrayList;

import marathon.finalProj.ApplicationDB.Domain.Runner;

/**
 * An interface with a method to get the runner information.
 *
 */

public interface RunnerReadable {
/**
 * method to get the runners from the DB
 * @return arraylist of runners
 */
	public ArrayList <Runner> getRunners();
}
