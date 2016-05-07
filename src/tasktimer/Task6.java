package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task6 implements Runnable {
	static final int MAXCOUNT = 50_000;
	BufferedReader br; 
	public Task6(){
		 // initialize
		  br = null;
	        try {
	            br = new BufferedReader( new InputStreamReader(Dictionary.getWordsAsStram()) );
	        } catch (Exception ex) {
	            out.println("Could not open dictionary: "+ex.getMessage() );
	            return;
	        }
	}
	public  void run(){
	        StringBuilder result = new StringBuilder();
	        String word = null;
	        int count = 0;
	        try {
	            while( (word=br.readLine()) != null  && count < MAXCOUNT) {
	                result.append(word);
	                count++;
	            }
	        } catch(IOException ioe) { System.out.println( ioe.getMessage() ); }
	        System.out.printf("Done appending %d words to StringBuilder.\n", count);
	        long stoptime = System.nanoTime();
	     
	    }	
	 public String toString() {
	       return "Starting task: append "+MAXCOUNT+" words to a StringBuilder";
	 }

}
