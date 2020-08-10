package com.bnpp.kata;

public class GameBoard {

	private static final int THREE = 3;
	protected char[][] ticTacToeGameBoard;

	public GameBoard() {
		ticTacToeGameBoard = new char[THREE][THREE];
	}

	public void setInGameBoard(int row, int column, char player) {
		ticTacToeGameBoard[row][column] = player;
	}

	public char getFromGameBoard(int row, int column) {
		return ticTacToeGameBoard[row][column];
	}
}
