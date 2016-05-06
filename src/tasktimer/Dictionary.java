package tasktimer;

import java.io.*;

public class Dictionary {
	 private static String DICTIONARY = "wordlist.txt";
	 
	 
	public static InputStream getWordsAsStram(){
	     
		return TaskTimer.class.getClassLoader().getResourceAsStream(DICTIONARY);
		
	}

}
