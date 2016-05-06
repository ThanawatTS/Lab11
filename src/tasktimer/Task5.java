package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 implements Runnable {
	 static final int MAXCOUNT = 50_000;
	public void run(){}
	  public static void task5( ) {
	        // initialize
	        BufferedReader br = null;
	        try {
	            br = new BufferedReader( new InputStreamReader(Dictionary.getWordsAsStram()) );
	        } catch (Exception ex) {
	            out.println("Could not open dictionary: "+ex.getMessage());
	            return;
	        }
	        
	        out.println("Starting task: append "+MAXCOUNT+" words to a String using +");
	        long starttime = System.nanoTime();
	        String result = "";
	        String word = null;
	        int count = 0;
	        try {
	            while( (word=br.readLine()) != null && count < MAXCOUNT) {
	                result = result + word;
	                count++;
	            }
	        } catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
	        System.out.printf("Done appending %d words to string.\n", count);
	        long stoptime = System.nanoTime();
	        out.printf("Elapsed time is %f sec\n",(stoptime - starttime)*1.0E-9 );
	    }
}
