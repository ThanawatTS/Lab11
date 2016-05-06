package tasktimer;

import static java.lang.System.out;
import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*;  // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer
{
    
    /**
     * Process all the words in a file using Scanner to read and parse input.
     * Display summary statistics and elapsed time.
     */
    //--
    
    /**
     * Process all the words in a file (one word per line) using BufferedReader
     * and the readLine() method.  readLine() returns null when there is no more input.
     * Display summary statistics and elapsed time.
     */
   //--
    /**
     * Process all the words in a file (one word per line) using BufferedReader
     * and the lines() method which creates a Stream of Strings (one item per line).  
     * Then use the stream to compute summary statistics.
     * In a lambda you cannot access a local variable unless it is final,
     * so (as a cludge) we use an attribute for the count.
     * When this method is rewritten as a Runnable, it can be a non-static attribute
     * of the runnable.
     * Display summary statistics and elapsed time.
     */
   //--
    /**
     * Process all the words in a file (one word per line) using BufferedReader
     * and the lines() method which creates a Stream of Strings (one item per line).  
     * Then use the stream to compute summary statistics.
     * This is same as task3, except we use a Collector instead of Consumer.
     */
    //--  
    // Limit number of words read.  Otherwise, the next task could be very sloooow.
    static final int MAXCOUNT = 50_000;
    
    /** 
     * Append all the words from the dictionary to a String.
     * This shows why you should be careful about using "string1"+"string2".
     */
   //--
    /** 
     * Append all the words from the dictionary to a StringBuilder.
     * Compare how long this takes to appending to String.
     */
    //--
    
    public static void execAndPrint(Runnable task){
    	out.println(task);
    	//.start();
    	task.run();
    	//.stop();
    	//out.printf("Elapsed time is %f sec\n", //);
    }
        
        
    /** Run all the tasks. */
    public static void main(String [] args) {
       execAndPrint(new Task1());
       execAndPrint(new Task2());
       execAndPrint(new Task3());
       execAndPrint(new Task4());
       execAndPrint(new Task5());
       execAndPrint(new Task6());
    }
    
}
