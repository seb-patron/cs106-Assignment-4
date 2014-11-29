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
	
	private HangmanCanvas canvas;
	

	private RandomGenerator rgen = RandomGenerator.getInstance();

	/** Tracks the number of guesses the player has */
	private int guessCounter = 8;

	/*is a random word*/
	private String hiddenWord = pickWord();
	
	/*scrambled version of hidden word that is deciphered in game*/
	public String word = scrambleWord();
	
	public char ch;

	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
	public void run() {
		setUpGame();
		playGame();
	}

	/**
	 * Sets up game by picking a random word and displaying welcome message
	 */
	public void setUpGame() {
		pickWord();
		println(hiddenWord);
		println(word);
		printWelcomeMessage();
	}

	/**
	 * Random generator that picks a word from HangmanLexicon Class
	 * 
	 */
	private String pickWord() {
		int index = rgen.nextInt(0, hangmanWords.getWordCount());
		String result = hangmanWords.getWord(index);
		return result;
	}

	/**
	 * Scrambles word so that it appears as "------"
	 */
	public String scrambleWord() {
		String result = "";
//		for (int i = 0; i < hiddenWord.length(); i++) {
//			result += "-";
//		}
		return result;
	}

	public void printWelcomeMessage() {
		int wordLength = hiddenWord.length();
		println("Welcome to Hangman!");
		println("The hiddenword is " + wordLength + " letters long.");
	}

	public void playGame() {
		while (guessCounter > 0) {
			printGameStatus();
			ch = getCharacter();
			checkLetter(ch);
			println();
			if (guessCounter == 0 ) {
				println("Oh no! D:");
				println("They hanged him!");
				println();
				println("The word was " + hiddenWord + ".");
				break;
			}
			if (word.indexOf("-") == -1 && guessCounter > 0) {
				println("Whoo-ho!");
				println("You saved the good man from hanging!");
				break;
			}
		}
	}

	/**
	 * Prints number of guesses left and status of word
	 */
	public void printGameStatus() {
		println("You have " + guessCounter + " guesses left.");
		println("The word looks like this " + word);
	}

	/**
	 * Gets input from user. Input comes in as a string. It is then
	 * Converted into a char. The Char is checked to make sure it is
	 * not a digit and that it consists of only one character. Finally,
	 * It is converted to uppercase if input is lowercase.
	 */
	public char getCharacter() {
		String getChar = readLine("Enter a letter: ");
		checkInput(getChar);
		char ch = getChar.charAt(0);
		if (Character.isLowerCase(ch)) { //converts lower case letters to upper case
			ch = Character.toUpperCase(ch);
		}
		return ch;
	}


	/**
	 * Checks to make sure that input is valid. Valid Input is input that is only
	 * one character long and is a letter, not a digit. 
	 * 
	 * 1st part of while statement evaluates to see if string is longer than one 
	 * letter, second part check if it is a digit. Breaks when both conditions
	 * are satisfied
	 */
	public String checkInput(String getChar) {
		while (getChar.length() > 1 || Character.isDigit(getChar.charAt(0))) {
			println("You may only enter one, valid letter at a time.");
			getChar = readLine("Enter a letter: ");
			if (getChar.length() < 1 && Character.isLetter(getChar.charAt(0))) break;
		} //breaks only if char is 1 in length and not a digit
		return getChar;
	}

	/**
	 * Checks to see if letter ch is in string hiddenword.
	 * If so, replaces "-" with ch at location.
	 */
	public void checkLetter(char ch) {
		for (int i = 0; i< hiddenWord.length(); i++) {
			if (ch == hiddenWord.charAt(i)) {
				println("MotherFucker!");
				word = word.substring(0, i) + ch + word.substring(i + 1);
			}
		}
		//if letter is not in word tells user of incorrect guess
		//and deincrements guess counter
		if (word.indexOf(ch) == -1){
			println("Sorry, but there are no " + ch + "'s in the word.");

			guessCounter--;
			
		}
	}
}
