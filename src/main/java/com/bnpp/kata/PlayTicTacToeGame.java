package com.bnpp.kata;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class PlayTicTacToeGame {

	private static final char CHAR_NULL = '\0';
	private static final int NEGATIVE_ONE = -1;
	private static final Logger LOGGER = Logger.getLogger(PlayTicTacToeGame.class);
	
	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		int row = NEGATIVE_ONE;
		int column = NEGATIVE_ONE;
		char winner = CHAR_NULL;
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		while(!ticTacToeGame.isGameOver()) {
			if(keyboardInput.hasNextInt()) {
				row = keyboardInput.nextInt();
			}
			if(keyboardInput.hasNextInt()) {
				column = keyboardInput.nextInt();
			}
			ticTacToeGame.drawOnBoard(row, column);
			winner = ticTacToeGame.getGameBoard().checkForResultOfTheGame();
		}
		LOGGER.debug("winner: "+ winner);
		keyboardInput.close();
	}

}
