/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	private HangmanLexicon hangmanWords = new HangmanLexicon();

	private RandomGenerator rgen = RandomGenerator.getInstance();

	/** Tracks the number of guesses the player has */
	private int guessCounter = 8;
	
	private String hiddenWord;
	
	private int wordLength = hiddenWord.length();

	public void run() {
		setUpGame();
	//	playGame();
	}

	public void setUpGame() {
		int index = rgen.nextInt(0,9);
		hiddenWord = hangmanWords.getWord(index);
		println(scrambleWord());
		printWelcomeMessage();
	}
	
	public String scrambleWord() {
		String result = "";
		for (int i = 0; i < hiddenWord.length(); i++) {
			result += "-";
		}
		return result;
	}
	
	public void printWelcomeMessage() {
		println("Welcome to Hangman!");
		println("The hiddenword is " + wordLength + " letters long.");
	}
}
