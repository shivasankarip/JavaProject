/**
 * 
 */
package marathon.finalProj.ApplicationController;

import java.util.ArrayList;

import marathon.finalProj.ApplicationDB.DAO.MarathonDAO;
import marathon.finalProj.ApplicationDB.Domain.Runner;
import marathon.finalProj.ApplicationDB.Service.DAOFactory;
import marathon.finalProj.ApplicationInterface.UIDisplay;

/**
 * This is the main class of this application. The main method has the calls to the user interaction class,
 *  the DAO factory class where the object for the desired back end is created 
 *  and the thread manager class which creates the thread.
 * Basically, This is the class which acts like a bridge to the front end and the back end.
 */
public class RunnerMainApp {

	 private static UIDisplay display= new UIDisplay();
	 private static MarathonDAO mDAO= null;
	 private static int choice;
	 private static String fileName=null;
	 private static String option;
	 private static boolean isContinue=true;
	
	
	/**
	 * The main method does the keen part in this application, as
	 * 1) makes call to the UIDisplay class which has the user interaction methods 
	 * and return back the input from the user.
	 * 2) Passes the choice of the file from the user input to the method in DAOFactory class, to create a object of 
	 * MarathonDAO for the respective database the user has opted.
	 * 3) Using the object that has been created by the above step, the required data is collected as a ArrayList 
	 * containing the object of Runner class.
	 * 4) Which is then passed on to the Thread Manager class to create the thread for each object.
	 * 
	 * @param args- String argument array
	 * @throws Exception throws the exception
	 */
	public static void main(String[] args) throws Exception {
		
		while(isContinue==true)
		{
			choice=display.getChoice();
			if(choice !=5)
			{
				// get the file name for the XML and text file choice
				if(choice==2 || choice==3)
					fileName=display.getFileName(choice);
				mDAO=DAOFactory.getMarathonDAO(choice,fileName);
				
				// A single call to the method getMarathonDAO will initialize the  
				//mDAO object for the respective DB
				
				ArrayList<Runner>runners=mDAO.getRunners();
				
				if(!runners.isEmpty()) 
				{
					display.printRacers(runners);
					// in case the user need to add additional runner to the race
					// the following code will get the information 
					//and add it in the runners ArrayList
					if(runners.size()==1 || choice ==1)
					{
						option=display.getOption();
						if(option.equalsIgnoreCase("Y"))
							runners.add(display.getInputRunners());
						if(runners.size()==1)
							System.out.println("Warning! there is only one runner in the race.");
					}
					display.startRace();
					// the call to create the thread for the race.
					ThreadManager.createThread(runners);
				} 
			
				isContinue=display.getContinue();
					
			}else break;			
		}
		display.printSummary();
		// prints the summary of the race.i.e.The winners of the race run by the current main thread.
	}
}
