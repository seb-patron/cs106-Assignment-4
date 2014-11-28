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

	private String hiddenWord = pickWord();

	private String word = scrambleWord();

	public void run() {
		setUpGame();
		playGame();
	}

	public void setUpGame() {
		pickWord();
		println(hiddenWord);
		println(word);
		printWelcomeMessage();
	}

	private String pickWord() {
		int index = rgen.nextInt(0,9);
		String result = hangmanWords.getWord(index);
		return result;
	}

	public String scrambleWord() {
		String result = "";
		for (int i = 0; i < hiddenWord.length(); i++) {
			result += "-";
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
		char ch = getCharacter();
			for (int i = 0; i< hiddenWord.length(); i++) {
				if (ch == hiddenWord.charAt(i)) {
					println("MotherFucker!");
				//	word = ch;
					println(word);
				}
			}

			guessCounter--;
		}
	}

	public void printGameStatus() {
		println("You have " + guessCounter + " guesses left.");
		println("The word looks like this " + word);
	}

	public char getCharacter() {
		String getChar = readLine("Enter a letter: ");
		checkInput(getChar);
		char ch = getChar.charAt(0);
		if (Character.isLowerCase(ch)) {
			ch = Character.toUpperCase(ch);
		}
		return ch;
	}
	
	private String checkInput(String getChar) {
		while (getChar.length() >1 || Character.isDigit(getChar.charAt(0))) {
			checkNumLetters(getChar);
			checkIfLetter(getChar);
		}
		return getChar;
	}
	
	public String checkNumLetters(String getChar) {
		while (getChar.length() > 1) {
			println("You may only enter one letter at a time.");
			getChar = readLine("Enter a letter: ");
			if (getChar.length() > 1) break;
		}
		return getChar;
	}
	
	private String checkIfLetter( String getChar) {
		while (Character.isDigit(getChar.charAt(0))) {
			println("You have to enter a valid letter.");
			getChar = readLine("Enter a letter: ");
		}
		return getChar;
	}
}
