
/**
 * 
 */
package marathon.finalProj.ApplicationDB.DAO;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import marathon.finalProj.ApplicationDB.Domain.Runner;



/**
 * This class is to get the data of runners from the XML file
 *
 */
public class MarathonXML implements MarathonDAO{
	
	 private Path runnerPath = null;
	 private ArrayList<Runner> runners = null;
/**
 * The constructor to get the file path
 * @param fileName file name of the xml file from the user input
 */
	    public MarathonXML(String fileName)
	    {
	    	  runnerPath = Paths.get(checkFileName(fileName));
	    }
	    /**
	     * This method get the runners information stored in the XMLFile Marathon.xml
	     * and returns the array list of Runner
	     * @return array list of runner
	     */
	@Override
	public ArrayList<Runner> getRunners() {
		       

     runners = new ArrayList<>();        
     Runner r = null;        
     if (Files.exists(runnerPath))  // prevent the FileNotFoundException
     {
         // create the XMLInputFactory object
         XMLInputFactory inputFactory = XMLInputFactory.newFactory();
         try
         {
             // create a XMLStreamReader object
             FileReader fileReader =
                 new FileReader(runnerPath.toFile());
             XMLStreamReader reader =
                 inputFactory.createXMLStreamReader(fileReader);

             // read the runners from the file
             while (reader.hasNext())
             {
                 int eventType = reader.getEventType();
                 switch (eventType)
                 {
                     case XMLStreamConstants.START_ELEMENT:
                         String elementName = reader.getLocalName();
                         if (elementName.equals("Runner"))
                         {
                             r = new Runner();
                             String name = reader.getAttributeValue(0);
                             r.setRunnersName(name);
                         }
                         if (elementName.equals("RunnersMoveIncrement"))
                         {
                             String speed = reader.getElementText();
                            r.setRunnerSpeed(Integer.parseInt(speed));
                         }
                         if (elementName.equals("RestPercentage"))
                         {
                             String rest = reader.getElementText();
                            r.setRestPercentage(Integer.parseInt(rest));
                           
                         }
                         break;
                     case XMLStreamConstants.END_ELEMENT:
                         elementName = reader.getLocalName();
                         if (elementName.equals("Runner"))
                         {
                             runners.add(r);
                         }
                         break;
                     default:
                         break;
                 }
                 reader.next();
             }
         }
         catch (IOException | XMLStreamException e)
         {
        	 System.out.println("Error in the XML File!! Please check the input XML ");
        	 runners.clear();
        	 System.out.println("Now exiting to the Menu");
          
         }
         catch (Exception e)
         {
        	 System.out.println("Error in the XML File.");
        	 runners.clear();
        	 System.out.println("Now exiting to the Menu");
         }
     }else {
    	 System.out.println("The file does not exist");
     }
     return runners;
		
	}
/**
 * To check whether the file name given as a input by the user is valid or not
 * @param fileName - user input file name
 * @return fileName after checking if it exist
 */
	private String checkFileName(String fileName) {
		File checkFile= new File(fileName);
		
	            if (checkFile.exists())
	            	return fileName;
	            else
	            {
	            	System.out.println("Error! File does not exist.");
	            	System.out.println("Now running from a sample XML file- Marathon.xml ");
	            	return "Marathon.xml";
	            }
	}
	
	
}
