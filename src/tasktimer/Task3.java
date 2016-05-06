package tasktimer;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.IntConsumer;;

public class Task3 implements Runnable{

	public void run(){
		
        BufferedReader br = null;
        try {
            br = new BufferedReader( new InputStreamReader(Dictionary.getWordsAsStram()) );
        } catch (Exception ex) {
            out.println("Could not open dictionary: "+ex.getMessage());
            return;
        }
        
        
        long starttime = System.nanoTime();
        
        long totalsize = 0;
        long count = 0;
        // This code uses Java's IntStream.average() method.
        // But there is no way to also get the count of items.
        // averageLength = br.lines().mapToInt( (word) -> word.length() )
        //                         .average().getAsDouble();
        // So instead we write out own IntConsumer to count and average the stream,
        // and use our IntConsumer to "consume" the stream.
        IntCounter counter = new IntCounter();
        br.lines().mapToInt( word -> word.length() ).forEach( counter );
        // close the input
        try {
            br.close();
        } catch(IOException ex) { /* ignore it */ }
        out.printf("Average length of %,d words is %.2f\n",
                counter.getCount(), counter.average() );
            
        long stoptime = System.nanoTime();
       
        
	}
	public String toString(){
		return "Starting task: read words using BufferedReader and Stream";
	}
	
	 public static class IntCounter implements IntConsumer {
	        // count the values
	        public int count = 0;
	        // total of the values
	        private long total = 0;
	        /** accept consumes an int. In this method, count the value and add it to total. */
	        public void accept(int value) { count++; total += value; }
	        /** Get the average of all the values consumed. */
	        public double average() { 
	            return (count>0) ? ((double)total)/count : 0.0;
	        }
	        public int getCount() { return count; }
	    }
	    
}
