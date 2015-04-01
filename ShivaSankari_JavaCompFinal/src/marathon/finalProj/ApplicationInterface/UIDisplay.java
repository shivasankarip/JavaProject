/**
 * 
 */
package marathon.finalProj.ApplicationInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import marathon.finalProj.ApplicationDB.Domain.Runner;
import marathon.finalProj.ApplicationUtil.AppConstants;
import marathon.finalProj.ApplicationUtil.AppValidator;


/**
 * The class which handles the user console interaction
 *
 */
public class UIDisplay implements AppConstants {

	Scanner sc=new Scanner(System.in);
	/**
	 * the method to display the main menu.
	 */
	public void printMenu()
	{
		System.out.println("Welcome to the Marathon Race Runner program\n");
		System.out.println("Select your data source:\n");
		System.out.println("1. Derby database");
		System.out.println("2. XML file");
		System.out.println("3. Text file");
		System.out.println("4. Default two runners");
		System.out.println("5. Exit");
		
	}
	
	/**
	 * This method to get the user choice from 1 to 5 as listed in the main menu.
	 * @return choice of the user from 1 to 5
	 */
		public int getChoice() {
			printMenu();
			int choice=AppValidator.getIntWitinRange(sc,"\nEnter your Choice : ", 0,6);
			return choice;
		}
		/**
		 * Get the file name in case of choice 2 or 3
		 * @param choice- the choice opted by the user
		 * @return file name - for text file .txt and for xml .xml format file name is requested from the user
		 */
		public String getFileName(int choice){
			if(choice==2)
				return AppValidator.getFileName(sc, "Enter the XML file name : ","xml");
			else if (choice==3)
				return AppValidator.getFileName(sc, "Enter the Text file name : ","txt");
			else 
				return null;
			
		}
	/**
	 * The method to display the name of the race participants
	 * @param runners to print the runners name
	 */
	public void printRacers(ArrayList <Runner> runners){
		Runner r=null; 
		System.out.println("The participants of the Marathon are ");
		for (int i = 0; i < runners.size(); i++)
         {
             r = runners.get(i);
            System.out.print("----"+r.getRunnersName()+"----");   
         }
		
	}
	/**
	 * The method to get the option whether the user wants to add a new runner to the race
	 * @return the option whether y/n
	 */
	public String getOption(){
		String choice;
		choice=AppValidator.getRequiredString(sc, "\nDo you want to enter a runner ? y/n :");
		return choice;
	}
/**
 * Method to get the user to hit the enter to continue with the application
 * @return true after hitting enter
 */
	
	public boolean getContinue(){
		try {
			System.out.println("\nPress ENTER to continue....\n");
			System.in.read();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return true;
		
	}
/**
 * Method to print the summary of all the race run by the current main thread of the program.
 */
	public void printSummary() {
		System.out.println("Exit the race.....");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Marathon Race summary");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~");
		if(winnerList.size()>=1){
			if(winnerList.size()==1)
				System.out.println("The Winner is ");
			else System.out.println("The winners are");
			System.out.println("=======================");
		for(int i=0;i<winnerList.size();i++){
			System.out.println("Race "+(i+1)+" : "+winnerList.get(i));
		}
			System.out.println("GoodBye....");
		}
	}
	/**
	 * If the user opted to add a additional runner to the race then this 
	 * method is used to get the runner information from the user
	 * @return the runner object 
	 */
	public Runner getInputRunners(){
		
		Runner runner=new Runner();
		runner.setRunnersName(AppValidator.getString(sc, "Enter the runner name : "));
		runner.setRunnerSpeed(AppValidator.getIntWitinRange(sc, "Enter the runner speed : ", 0, 100));
		runner.setRestPercentage(AppValidator.getIntWitinRange(sc, "Enter the rest percentage : ", 0, 90));
		
		System.out.println("The runner is successfully added in the race !!");
	
		return runner;
	}
	/**
	 * The method that user hits enter to start the race.
	 */
	public void startRace(){
		getContinue();
		System.out.println("Get Set...\nReady...\nGo...\n");
	}

}
