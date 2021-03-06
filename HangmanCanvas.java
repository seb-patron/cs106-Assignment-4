/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Font;

import acm.graphics.*;
;
public class HangmanCanvas extends GCanvas {


	/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

	private int scaffoldXStart = 20;
	private int scaffoldYStart = 20;

	private int endBeamxLocation = scaffoldXStart + BEAM_LENGTH;

	private int endRopeYLocation = scaffoldYStart + ROPE_LENGTH;
	
	private String incorrectGuesses ="";



	/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		drawScaffold();
	}

	private void drawScaffold() {
		GLine scaffold = new GLine(scaffoldXStart , scaffoldYStart , 
				scaffoldXStart , scaffoldYStart + SCAFFOLD_HEIGHT );
		add(scaffold);

		GLine beam = new GLine (scaffoldXStart, scaffoldYStart , 
				endBeamxLocation , scaffoldYStart);
		add(beam);
		GLine rope = new GLine (endBeamxLocation, scaffoldYStart , 
				endBeamxLocation , endRopeYLocation);
		add(rope);
	}


	/**
	 * Updates the word on the screen to correspond to the current
	 * state of the game.  The argument string shows what letters have
	 * been guessed so far; unguessed letters are indicated by hyphens.
	 */
	
	private GLabel wordLabel;
	public void displayWord(String word) {
		int x = scaffoldXStart;
		int y = 60 + SCAFFOLD_HEIGHT;
		if (getElementAt(x, y) != null) {
			remove(wordLabel);
		}
		wordLabel = new GLabel (word, x, y);
		wordLabel.setFont(new Font("Serif", Font.BOLD, 25));
		add (wordLabel);
	}


	/**
	 * Updates the display to correspond to an incorrect guess by the
	 * user.  Calling this method causes the next body part to appear
	 * on the scaffold and adds the letter to the list of incorrect
	 * guesses that appears at the bottom of the window.
	 */
	public  void noteIncorrectGuess(int guessCounter) {
		if (guessCounter == 7) drawHead();
		if (guessCounter == 6) drawBody();
		if (guessCounter == 5) drawRightArm();
		if (guessCounter == 4) drawLeftArm();
		if (guessCounter == 3) drawRightLeg();
		if (guessCounter == 2) drawLeftLeg();
		if (guessCounter == 1) drawRightFoot();
		if (guessCounter == 0) {
			drawLeftFoot();		
			drawDeadHead();
		}
	}
	
	private GLabel guesses;
	
	public void updateIncorrectLetters(char ch) {
		incorrectGuesses += ch;
		int x = scaffoldXStart;
		int y = 80 + SCAFFOLD_HEIGHT;
		if (getElementAt(x, y) != null) {
			remove(guesses);
		}
		guesses = new GLabel (incorrectGuesses, x, y);
		guesses.setFont(new Font("Serif", Font.BOLD, 15));
		add (guesses);
	}

	private GImage head;
	private void drawHead() {
		int x = endBeamxLocation - HEAD_RADIUS;
		int y = endRopeYLocation;
		head = new GImage("face.gif");
		add(head, x, y);
	}

	private void drawBody() {
		int x = endBeamxLocation;
		int y = endRopeYLocation + HEAD_RADIUS*2;
		GLine body = new GLine(x , y, x, y + BODY_LENGTH);
		add(body);
	}

	private void drawRightArm() {
		int x = endBeamxLocation;
		int y = endRopeYLocation + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD;
		GLine upperArm = new GLine(x , y, x + UPPER_ARM_LENGTH, y);
		add(upperArm);
		x += UPPER_ARM_LENGTH;
		y = endRopeYLocation + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD;
		GLine lowerArm = new GLine(x , y, x, y + LOWER_ARM_LENGTH);
		add(lowerArm);

	}

	private void drawLeftArm() {
		int x = endBeamxLocation;
		int y = endRopeYLocation + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD;
		GLine upperArm = new GLine(x , y, x - UPPER_ARM_LENGTH, y);
		add(upperArm);
		x -= UPPER_ARM_LENGTH;
		y = endRopeYLocation + HEAD_RADIUS*2 + ARM_OFFSET_FROM_HEAD;
		GLine lowerArm = new GLine(x , y, x, y + LOWER_ARM_LENGTH);
		add(lowerArm);	
	}

	private void drawRightLeg() {
		int x = endBeamxLocation;
		int y = endRopeYLocation + HEAD_RADIUS*2 + BODY_LENGTH;
		GLine hip = new GLine(x , y, x + HIP_WIDTH, y);
		add(hip);

		x += HIP_WIDTH;
		GLine leg = new GLine(x , y, x, y + LEG_LENGTH);
		add(leg);
	}

	private void drawLeftLeg() {
		int x = endBeamxLocation;
		int y = endRopeYLocation + HEAD_RADIUS*2 + BODY_LENGTH;
		GLine hip = new GLine(x , y, x - HIP_WIDTH, y);
		add(hip);

		x -= HIP_WIDTH;
		GLine leg = new GLine(x , y, x, y + LEG_LENGTH);
		add(leg);
	}

	private void drawRightFoot() {
		int x = endBeamxLocation + HIP_WIDTH/3;
		int y = endRopeYLocation + HEAD_RADIUS*2 + BODY_LENGTH + LEG_LENGTH/2;

		GImage shoe = new GImage("rightShoe.gif");
		add(shoe, x, y);
	}

	private void drawLeftFoot() {
		int y = endRopeYLocation + HEAD_RADIUS*2 + BODY_LENGTH + LEG_LENGTH/2;

		GImage shoe = new GImage("leftShoe.gif");
		int x = endBeamxLocation -  (int) shoe.getWidth();
		add(shoe, x, y);
	}

	private void drawDeadHead() {
		int x = endBeamxLocation - HEAD_RADIUS;
		int y = endRopeYLocation;
		remove(head);
		head = new GImage("hungFace.gif");
		add(head, x, y);
	}

	public void drawHappyFace() {
		int x = endBeamxLocation - HEAD_RADIUS;
		int y = endRopeYLocation;
		if(head != null) {
			remove(head);
			head = new GImage("happyFace.gif");
			add(head, x, y);
		}

	}
}
