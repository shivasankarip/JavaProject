/**
 * 
 */
package marathon.finalProj.ApplicationDB.DAO;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import marathon.finalProj.ApplicationDB.Domain.Runner;



/**
 * This class is to get the data of runners from the TextFile
 *
 */
public class MarathonTextFile implements MarathonDAO {


	private ArrayList<Runner> runners = null;
    private Path runnerPath = null;
	private File runnerFile= null;

	private final String FIELD_SEP = "\t";
	/**
	 * The constructor to get the file path and to file
	 * @param fileName - Name of the file got from the user input
	 */
	public MarathonTextFile(String fileName){
	
		
		 runnerPath = Paths.get(checkFileName(fileName));
	        runnerFile = runnerPath.toFile();
	}
	
	/**
	 * This method get the runners information stored in the TextFile Marathon.txt
	 * and returns the array list of Runner
	 * @return array list of runners
	 */
	@Override
	public ArrayList<Runner> getRunners() {
		
		runners=new ArrayList<Runner>();
		  if (Files.exists(runnerPath))  // prevent the FileNotFoundException
	        {
			  BufferedReader in = null;
	            try 
	            {
	            	 in = new BufferedReader(
	                         new FileReader(runnerFile));
	                // read all details stored in the file
	                // into the array list as a Runner object
	                String line = in.readLine();
	                while(line != null)
	                {
	                    String[] columns = line.split(FIELD_SEP);
	                    String name = columns[0];
	                    String speed = columns[1];
	                    String rest = columns[2];

	                    Runner r = new Runner(
	                        name,Integer.parseInt(speed),Integer.parseInt(rest));

	                    runners.add(r);

	                    line = in.readLine();                    
	                }
	            }
	            catch(IOException e)
	            {
	                System.out.println(e);
	                return null;
	            }
	            catch(Exception e)
	            {
	            	System.out.println("The File is not properly structured");
	            	runners.clear();
	            	System.out.println("Now returning to the menu");
	            }
	            finally{
	            	close(in);
	            }
	        }
	        return runners;    
		
	}
	/**
	 * Check whether the file name input by the user exist or not
	 * @param fileName user input file name
	 * @return the filename after checking.
	 */
	private String checkFileName(String fileName) {
		File checkFile= new File(fileName);
		
	            if (checkFile.exists())
	            	return fileName;
	            else
	            {
	            	System.out.println("Error! File does not exist.");
	            	System.out.println("Now running from a sample text file- Marathon.txt ");
	            	return "Marathon.txt";
	            }
	}
	
/**
 * To close the file stream
 * @param stream closes the stream passed as a param
 */
	 private void close(Closeable stream)
	    {
	        try
	        {
	            if (stream != null)
	                stream.close();
	        }
	        catch(IOException ioe)
	        {
	            ioe.printStackTrace();
	        }
	    }
}
