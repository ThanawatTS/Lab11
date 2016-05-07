package tasktimer;

import java.io.*;

public class Dictionary {
	
	public static InputStream getWordsAsStram(){
	     
		return TaskTimer.class.getClassLoader().getResourceAsStream("wordlist.txt");
		
	}

}
