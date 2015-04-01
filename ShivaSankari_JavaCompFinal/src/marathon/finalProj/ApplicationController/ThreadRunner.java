th/**
 * 
 */
package marathon.finalProj.ApplicationController;

import marathon.finalProj.ApplicationDB.Domain.Runner;
import marathon.finalProj.ApplicationUtil.AppConstants;
import marathon.finalProj.ApplicationUtil.AppUtility;



/**
 * ThreadRunner class extends the Thread Class and has a run method 
 * This class main operation is to run all the threads that has been created and started 
 * by the ThreadManger.
 * Once there is a winner, the winner thread will call the finished method in ThreadManager class
 * which in turn interrupts all the other thread and ends the race. 
 *
 */
public class ThreadRunner extends Thread implements AppConstants{
	private int distance;
	private Runner runner=null;

	
/**
 * The Constructor of the class with the Runner object as a parameter
 * @param runner- The Runner object 
 */
	public ThreadRunner(Runner runner)
	{
		this.runner=runner;
	}
	
	/**
	 * run method which runs all the thread
	 */

	@Override
	public void run() {
		
		while( !isInterrupted() && distance< RACE_DISTANCE)
		{
			/**
			 * A random number is generated, on which whether the thread will run or sleeps depends.
			 */
			boolean raceOver = false;
			int randomNumber=AppUtility.getRandomNumber();
			if(runner.getRestPercentage()<= randomNumber )
				{	
				
				synchronized (getClass()) {
					if(raceOver==false && !this.isInterrupted()){
					distance+=runner.getRunnerSpeed();
					System.out.println(runner.getRunnersName()+" : "+distance+" m");
					if(distance>=RACE_DISTANCE)
						raceOver=true;
					
					}else
						break;
				}
				/**
				 * if a thread completes the RACE_DISTANCE then it will call the finished method,to interrupt 
				 * all the other thread. The boolean raceOver is to ensure that the other thread dose'nt calculate the 
				 * distance, if there is a winner.
				 */
					if(distance>=RACE_DISTANCE && raceOver==true){
						ThreadManager.finished(Thread.currentThread(),runner.getRunnersName());
						break;
					}
				}
	//if the random number is less than the rest percentage then the respective thread sleeps
				try{
					Thread.sleep(SLEEP_TIME);  
					}catch(InterruptedException e)
					{
					System.out.println(runner.getRunnersName()+": You beat me fare and square...");
					return;
					}
		}
	}
}
