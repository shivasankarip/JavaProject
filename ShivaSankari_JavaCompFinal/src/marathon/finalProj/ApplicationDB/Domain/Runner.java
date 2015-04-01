/**
 * 
 */
package marathon.finalProj.ApplicationDB.Domain;

/**
 * This Class has a vital role in the application.
 * The constructor has three parameters, namely
 * Name of the runner
 * Runner Speed
 * Runner rest percentage
 */
public class Runner {
	private String runnersName;
	private int runnerSpeed;
	private int restPercentage;
	
	public Runner(){
		
	}
	/**
	 * Constructs the runner
	 * @param runnersName -Name of the runner
	 * @param runnerSpeed -speed of the runner
	 * @param restPercentage -rest percentage of the runner
	 */
	public Runner(String runnersName,int runnerSpeed, int restPercentage ){
		this.setRunnersName(runnersName);
		this.setRunnerSpeed(runnerSpeed);
		this.setRestPercentage(restPercentage);
	}
/**
 * this method returns the runners name for this runner
 * @return runners name
 */
	public String getRunnersName() {
		return runnersName;
	}
/**
 * This method sets the value of runners name for this runner
 * @param runnersName name of the runner
 */
	public void setRunnersName(String runnersName) {
		this.runnersName = runnersName;
	}
/**
 * This method returns the runner speed of this return
 * @return runner speed
 */
	public int getRunnerSpeed() {
		return runnerSpeed;
	}
/**
 * Method to set the runner speed for this runner
 * @param runnerSpeed- speed of the runner
 */
	public void setRunnerSpeed(int runnerSpeed) {
		this.runnerSpeed = runnerSpeed;
	}
/**
 * Method to return the rest percentage of this runner
 * @return rest percentage
 */
	public int getRestPercentage() {
		return restPercentage;
	}
/**
 * Method to set the value of rest percentage of this runner
 * @param restPercentage runners's rest percentage
 */
	public void setRestPercentage(int restPercentage) {
		this.restPercentage = restPercentage;
	}
	
}
