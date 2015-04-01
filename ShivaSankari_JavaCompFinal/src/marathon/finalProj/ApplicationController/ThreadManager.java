/**
 * 
 */
package marathon.finalProj.ApplicationController;

import java.util.ArrayList;

import marathon.finalProj.ApplicationDB.Domain.Runner;
import marathon.finalProj.ApplicationUtil.AppConstants;

/**
 * This class plays a vital role in managing the thread. it is responsible for
 * getting the array list of Runners object and creating a new thread for each
 * Runner Object. It also has the finished method which is called by the winner
 * thread to interrupt the other threads.
 */
public class ThreadManager implements AppConstants {

	private static ArrayList<ThreadRunner> runningThreads = new ArrayList<>();
	private static boolean raceOver = false;

	/**
	 * The new thread for the each Runner object is created using the
	 * constructor of the ThreadRunner class.
	 * 
	 * @param runners
	 *            array list consisting of Runner object
	 * @throws InterruptedException
	 *             - throws a interrupted exception
	 */
	public static void createThread(ArrayList<Runner> runners)
			throws InterruptedException {
		// create a new thread for all the runners
		for (Runner runner : runners) {
			runningThreads.add(new ThreadRunner(runner));
		}
		// starting the threads
		raceOver = false;

		for (ThreadRunner threadRunner : runningThreads) {
			threadRunner.start();

		}
		// join the runner threads with the main thread
		for (ThreadRunner threadRunner : runningThreads) {
			threadRunner.join();
			
		}

		runningThreads.clear();
	}

	/**
	 * The synchronized method which is called by the winner thread and it
	 * interrupts all the other thread.
	 * 
	 * @param winner
	 *            The winner thread
	 * @param winnerName
	 *            the winner name
	 */
	public static synchronized void finished(Thread winner, String winnerName) {
		// adds the winner name to the winner list to display in the race
		// summary
		if (raceOver == false) {
			winnerList.add(winnerName);
			System.out.println(winnerName + ": I finished!");

			// the winner thread interrupts all the other runner thread
			for (int i = 0; i < runningThreads.size(); i++) {
				if (!winner.equals(runningThreads.get(i)))
					runningThreads.get(i).interrupt();
			}
			System.out.println("\nThe race is over! The " + winnerName
					+ " is the winner.");
			raceOver = true;
		}
	}

}
