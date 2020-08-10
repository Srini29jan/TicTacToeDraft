package com.bnpp.kata;

public class GameBoard {

	private static final int ONE = 1;
	private static final char PLAYER_O = 'O';
	private static final char PLAYER_X = 'X';
	private static final char CHAR_NULL = '\0';
	private static final String OCCUPIED_POSITION_MESSAGE = "The position selected is already occupied. Please select an unoccupied position in the board";
	private static final String INVALID_POSITION_MESSAGE = "The position selected is invalid. Please select a number from 0, 1 or 2";
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final int THREE = 3;
	protected char[][] ticTacToeGameBoard;
	protected int numberOfCellsFilled;
	protected char currentPlayer;

	public GameBoard() {
		ticTacToeGameBoard = new char[THREE][THREE];
	}

	public void setInGameBoard(int row, int column, char player) throws InvalidMoveException {
		if (isWithinRange(row, column)) {
			if(isPositionNotAlreadyPlayed(row, column)) {
				ticTacToeGameBoard[row][column] = player;
				numberOfCellsFilled++;
			} else {
				throw new InvalidMoveException(OCCUPIED_POSITION_MESSAGE);
			}
		} else {
			throw new InvalidMoveException(INVALID_POSITION_MESSAGE);
		}
	}

	private boolean isPositionNotAlreadyPlayed(int row, int column) {
		return getFromGameBoard(row, column) == CHAR_NULL;
	}

	private boolean isWithinRange(int row, int column) {
		return row >= ZERO && row <= TWO && column >= ZERO && column <= TWO;
	}

	public char getFromGameBoard(int row, int column) {
		return ticTacToeGameBoard[row][column];
	}

	protected void setCurrentPlayer() {
		if (numberOfCellsFilled % TWO == ZERO) {
			this.currentPlayer = PLAYER_X;
		} else {
			this.currentPlayer = PLAYER_O;
		}
	}

	public void setInGameBoard(int row, int column) throws InvalidMoveException {
		setCurrentPlayer();
		setInGameBoard(row, column, currentPlayer);
	}

	public char checkForResultOfTheGame() {
		char winner = getWinnerByStrikeInRow();
		if (winner == CHAR_NULL) {
			winner = getWinnerByStrikeInColumn();
		}
		return winner;
	}

	private char getWinnerByStrikeInColumn() {
		if (getFromGameBoard(ZERO, ZERO) != CHAR_NULL && getFromGameBoard(ZERO, ZERO) == getFromGameBoard(ONE, ZERO) && getFromGameBoard(ONE, ZERO) == getFromGameBoard(TWO, ZERO)) {
			return getFromGameBoard(ZERO, ZERO);
		} else if (getFromGameBoard(ZERO, ONE) != CHAR_NULL && getFromGameBoard(ZERO, ONE) == getFromGameBoard(ONE, ONE) && getFromGameBoard(ONE, ONE) == getFromGameBoard(TWO, ONE)) {
			return getFromGameBoard(ZERO, ONE);
		} else if (getFromGameBoard(ZERO, TWO) != CHAR_NULL && getFromGameBoard(ZERO, TWO) == getFromGameBoard(ONE, TWO) && getFromGameBoard(ONE, TWO) == getFromGameBoard(TWO, TWO)) {
			return getFromGameBoard(ZERO, TWO);
		}
		return CHAR_NULL;
	}

	private char getWinnerByStrikeInRow() {
		if (getFromGameBoard(ZERO, ZERO) != CHAR_NULL && getFromGameBoard(ZERO, ZERO) == getFromGameBoard(ZERO, ONE) && getFromGameBoard(ZERO, ONE) == getFromGameBoard(ZERO, TWO)) {
			return getFromGameBoard(ZERO, ZERO);
		} else if (getFromGameBoard(ONE, ZERO) != CHAR_NULL && getFromGameBoard(ONE, ZERO) == getFromGameBoard(ONE, ONE) && getFromGameBoard(ONE, ONE) == getFromGameBoard(ONE, TWO)) {
			return getFromGameBoard(ONE, ZERO);
		} else if (getFromGameBoard(TWO, ZERO) != CHAR_NULL && getFromGameBoard(TWO, ZERO) == getFromGameBoard(TWO, ONE) && getFromGameBoard(TWO, ONE) == getFromGameBoard(TWO, TWO)) {
			return getFromGameBoard(TWO, ZERO);
		}
		return CHAR_NULL;
	}
}
