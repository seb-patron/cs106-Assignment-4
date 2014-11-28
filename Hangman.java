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

	public void run() {
		String hiddenWord = hangmanWords.getWord(6);
		println(hiddenWord);
	}
}