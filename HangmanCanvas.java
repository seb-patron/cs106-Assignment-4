/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class HangmanCanvas extends GCanvas {


	public GCanvas canvas;



	/** Resets the display so that only the scaffold appears */
	public void reset() {
		GLine rope = new GLine (20, 20, 80, 80);
		add(rope);
//		drawScaffold();
	//	drawHead();
	}

	private void drawScaffold() {
//		double scaffoldTopX = getWidth()/2 - UPPER_ARM_LENGTH;
//		double scaffoldTopY = getHeight()/2 - BODY_LENGTH - HEAD_RADIUS*2 - ROPE_LENGTH;
//		double scaffoldBottomY = scaffoldTopY + SCAFFOLD_HEIGHT;
//		GLine scaffold= new GLine (scaffoldTopX, scaffoldTopY, scaffoldTopX, scaffoldBottomY);
//		add(scaffold);
//		double beamRightX = scaffoldTopX + BEAM_LENGTH;
//		GLine beam = new GLine(scaffoldTopX, scaffoldTopY, beamRightX, scaffoldTopY);
//		add(beam);
//		double ropeBottomY = scaffoldTopY + ROPE_LENGTH;
		GLine rope = new GLine (20, 20, 80, 80);
		add(rope);
	}



	private void drawHead() {
		GOval head = new GOval(getWidth()/2, getHeight()/2,500, 500 );
		head.setFilled(true);
		add(head);
	}

	/**
	 * Updates the word on the screen to correspond to the current
	 * state of the game.  The argument string shows what letters have
	 * been guessed so far; unguessed letters are indicated by hyphens.
	 */
	public void displayWord(String word) {
		/* You fill this in */
	}


	/**
	 * Updates the display to correspond to an incorrect guess by the
	 * user.  Calling this method causes the next body part to appear
	 * on the scaffold and adds the letter to the list of incorrect
	 * guesses that appears at the bottom of the window.
	 */
	public static void noteIncorrectGuess(int guessCounter) {
		//		if(guessCounter == 7) {
		//			canvas.add(head);
		//		}
		//		switch (guessCounter) {
		////		case 7: drawHead();
		//		case 6: drawBody();
		//		case 5: drawRightArm();
		//		case 4: drawLeftArm();
		//		case 3: drawRightLeg();
		//		case 2: drawLeftLeg();
		//		case 1: drawRightFoot();
		//		case 0: drawLeftFoot();
		//
		//		}

	}





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

}
