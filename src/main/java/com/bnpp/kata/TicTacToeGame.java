package com.bnpp.kata;

import org.apache.log4j.Logger;

public class TicTacToeGame {

	private static final String NO_WINNER_MESSAGE = "The game ended without a winner";
	private static final int NINE = 9;
	private static final String TRY_AGAIN_MESSAGE = "Read the message above and try again with valid inputs";
	private static final String WINNER_MESSAGE = "Winner of the game is Player ";
	private static final int FOUR = 4;
	private GameBoard gameBoard;
	private final Logger LOGGER = Logger.getLogger(TicTacToeGame.class);
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
		char winner;
		if (gameBoard.numberOfCellsFilled > FOUR) {
			winner = gameBoard.checkForResultOfTheGame();
			if (winner != NO_WIN) {
				LOGGER.info(WINNER_MESSAGE+ winner);
				return true;
			} else if (gameBoard.numberOfCellsFilled == NINE) {
				LOGGER.info(NO_WINNER_MESSAGE);
				return true;
			}
		}
		return false;
	}
}
