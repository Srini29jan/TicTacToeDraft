package com.bnpp.kata;

import org.apache.log4j.Logger;

public class TicTacToeGame {

	private GameBoard gameBoard;
	private final Logger LOGGER = Logger.getLogger(TicTacToeGame.class);
	private char winner = '\0';

	public TicTacToeGame() {
		gameBoard = new GameBoard();
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void drawOnBoard(int row, int column) {
		try {
			gameBoard.setInGameBoard(row, column);
		} catch (InvalidMoveException e) {
			LOGGER.warn(e+ "Read the message above and try again with valid inputs");
		}
	}

	public boolean isGameOver() {
		if (gameBoard.numberOfCellsFilled > 4) {
			winner = gameBoard.checkForResultOfTheGame();
			if (winner != '\0') {
				LOGGER.info("Winner of the game is Player "+ winner);
				return true;
			}
		}
		return false;
	}
}
