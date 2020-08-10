package com.bnpp.kata;

public class GameBoard {

	private static final int THREE = 3;
	protected char[][] ticTacToeGameBoard;

	public GameBoard() {
		ticTacToeGameBoard = new char[THREE][THREE];
	}

	public void setInGameBoard(int row, int column, char player) throws InvalidMoveException {
		if (row <= 2) {
			ticTacToeGameBoard[row][column] = player;
		} else {
			throw new InvalidMoveException("The position selected is invalid. Please select a number from 0, 1 or 2");
		}
	}

	public char getFromGameBoard(int row, int column) {
		return ticTacToeGameBoard[row][column];
	}
}
