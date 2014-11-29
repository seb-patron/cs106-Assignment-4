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

	public String word = scrambleWord();

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
		String displayWord = word;
		while (guessCounter > 0) {
			printGameStatus();
			char ch = getCharacter();
			word  = checkLetter(ch);
			println();
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
		if (Character.isLowerCase(ch)) { //converts lower case letters to upper case
			ch = Character.toUpperCase(ch);
		}
		return ch;
	}


	/*
	 * Checks to make sure that input is valid. Valid Input is input that is only
	 * one character long and is a letter, not a digit. 
	 * 
	 * 1st part of while statement evaluates to see if string is longer than one 
	 * letter, second part check if it is a digit. Breaks when both conditions
	 * are satisified
	 */
	public String checkInput(String getChar) {
		while (getChar.length() > 1 || Character.isDigit(getChar.charAt(0))) {
			println("You may only enter one, valid letter at a time.");
			getChar = readLine("Enter a letter: ");
			if (getChar.length() < 1 && Character.isLetter(getChar.charAt(0))) break;
		}
		return getChar;
	}

	public String checkLetter(char ch) {
		String result = null;
		for (int i = 0; i< hiddenWord.length(); i++) {
			if (ch == hiddenWord.charAt(i)) {
				println("MotherFucker!");
				result = word.substring(0, i);
				result += word.substring(i);
			}
		}

		return result;
	}
}
