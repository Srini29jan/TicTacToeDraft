package com.bnpp.kata;

import org.apache.log4j.Logger;

public class TicTacToeGame {

	private static final String TRY_AGAIN_MESSAGE = "Read the message above and try again with valid inputs";
	private static final String WINNER_MESSAGE = "Winner of the game is Player ";
	private static final int FOUR = 4;
	private static final char CHAR_NULL = '\0';
	private GameBoard gameBoard;
	private final Logger LOGGER = Logger.getLogger(TicTacToeGame.class);
	private char winner = '\0';
	private static final char NO_WIN = 'N';

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
			LOGGER.warn(e+ TRY_AGAIN_MESSAGE);
		}
	}

	public boolean isGameOver() {
		if (gameBoard.numberOfCellsFilled > FOUR) {
			winner = gameBoard.checkForResultOfTheGame();
			if (winner != NO_WIN) {
				LOGGER.info(WINNER_MESSAGE+ winner);
				return true;
			} else if (gameBoard.numberOfCellsFilled == 9) {
				LOGGER.info("The game ended without a winner");
				return true;
			}
		}
		return false;
	}
}
