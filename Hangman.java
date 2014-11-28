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
import java.io.IOException;

public class Hangman extends ConsoleProgram {

	private HangmanLexicon hangmanWords = new HangmanLexicon();

	private RandomGenerator rgen = RandomGenerator.getInstance();

	/** Tracks the number of guesses the player has */
	private int guessCounter = 8;
	
	private String hiddenWord;
	
	private String word;

	public void run() {
		setUpGame();
		playGame();
	}

	public void setUpGame() {
//		int index = rgen.nextInt(0,0);
		hiddenWord = hangmanWords.getWord(0);
		println(scrambleWord());
		printWelcomeMessage();
	}
	
	public String scrambleWord() {
		String result = "";
		for (int i = 0; i < hiddenWord.length(); i++) {
			word += "-";
		}
		return result;
	}
	
	public void printWelcomeMessage() {
		int wordLength = hiddenWord.length();
		println("Welcome to Hangman!");
		println("The hiddenword is " + wordLength + " letters long.");
	}
	
	public void playGame() {
			while (guessCounter > 0) {
				println("You have " + guessCounter + " guesses left.");
				String getChar = readLine("Enter a letter: ");
				char ch = getChar.charAt(0);
				for (int i = 0; i< hiddenWord.length(); i++) {
					String ravioli = ("ravioli");
					if (ch == ravioli.charAt(i)) {
						println("MotherFucker!");
						
						
					}
				}
				
				guessCounter--;
			}
	}
}
