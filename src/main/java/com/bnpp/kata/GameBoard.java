package com.bnpp.kata;

public class GameBoard {

	private static final char CHAR_NULL = '\0';
	private static final String OCCUPIED_POSITION_MESSAGE = "The position selected is already occupied. Please select an unoccupied position in the board";
	private static final String INVALID_POSITION_MESSAGE = "The position selected is invalid. Please select a number from 0, 1 or 2";
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final int THREE = 3;
	protected char[][] ticTacToeGameBoard;
	protected int numberOfCellsFilled;

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
}
