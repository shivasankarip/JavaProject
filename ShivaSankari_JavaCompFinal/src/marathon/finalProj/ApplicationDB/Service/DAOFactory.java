/**
 * 
 */
package marathon.finalProj.ApplicationDB.Service;

import marathon.finalProj.ApplicationDB.DAO.MarathonDAO;
import marathon.finalProj.ApplicationDB.DAO.MarathonDefault;
import marathon.finalProj.ApplicationDB.DAO.MarathonDerby;
import marathon.finalProj.ApplicationDB.DAO.MarathonTextFile;
import marathon.finalProj.ApplicationDB.DAO.MarathonXML;



/**
 * DAOFactory it acts like a gateway between the controller and the back end DB.
 * This class is responsible for initializing the MarathonDAO object with the respective DB class 
 * corresponding to the user input choice.
 */
public class DAOFactory {
	private static MarathonDAO mDAO = null;
	/**
	 * 
	 * This method maps the MarathonDAO interface to the appropriate DB.
	 * @param choice- the input user choice
	 * @param fileName - file name in case of the Text File and XML option
	 * @return- returns the mDAO object
	 */
	 public static MarathonDAO getMarathonDAO(int choice,String fileName)
	    {
		 // The input user choice is the input parameter for the method
		 // and it is given in a switch case.
		 switch(choice)
		 {
		 case 1:
		// the user choice is 1 then the MarathonDAO object is initialized with the child class MarathonDerby.
			 mDAO= new MarathonDerby();
			 break;
		
		 case 2:
			// the user choice is 2 then the MarathonDAO object is initialized with the child class MarathonXML.
			 mDAO= new MarathonXML(fileName);
			 break;
		 
		 case 3:
		// the user choice is 3 then the MarathonDAO object is initialized with the child class MarathonTextFile.
			 mDAO=new MarathonTextFile(fileName);
			 break;
		 
		 case 4:
			// the user choice is 4 then the MarathonDAO object is initialized with the child class MarathonDefault.
			 mDAO= new MarathonDefault();
			 break;
			 
		 default:
			 // This is  default in a switch case.
			 mDAO=new MarathonDefault();
			 break;
		 }
		 
		 // return the object
			return mDAO;
	        
	    }

}
