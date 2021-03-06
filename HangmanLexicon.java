/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {

	private RandomGenerator rgen = RandomGenerator.getInstance();

	private int wordCount;


	private ArrayList <String> wordList = new ArrayList <String> ();

	public HangmanLexicon() {
		try {
			BufferedReader rd = null;
			rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null) break; //breaks when lines all read
				wordList.add(line);
			}
		} catch (IOException ex) {
			//	println("Bad file");
		}
	}

	/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		wordCount = wordList.size();
		return wordCount;
	}

	public String getWord(int index) {
		int x = rgen.nextInt(0, wordCount);
		return wordList.get(x);

	}
}

/*
 * Attempt to create class that would open file and add to array
 */
	//	private BufferedReader openFile() {
	//		BufferedReader rd = null;
	//		
	//		while (rd == null) {
	//			try {
	//				rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
	//				while (true) {
	//					String line = rd.readLine();
	//					if (line == null) break; //breaks when lines all read
	//					wordList[wordCount++] = line;
	//				}
	//			} catch (IOException ex) {
	//			//	println("Bad file");
	//			}
	//		}
	//		return rd;
	//	}
	//}
















	///** Returns the word at the specified index. */
	//public String getWord(int index) {
	//	switch (index) {
	//		case 0: return "BUOY";
	//		case 1: return "COMPUTER";
	//		case 2: return "CONNOISSEUR";
	//		case 3: return "DEHYDRATE";
	//		case 4: return "FUZZY";
	//		case 5: return "HUBBUB";
	//		case 6: return "KEYHOLE";
	//		case 7: return "QUAGMIRE";
	//		case 8: return "SLITHER";
	//		case 9: return "ZIRCON";
	//		default: throw new ErrorException("getWord: Illegal index");
	//	}
	//};
