package com.bnpp.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {

	private static final char PLAYER_X = 'X';
	private static final int ZERO = 0;
	protected GameBoard gameBoard;

	@Before
	public void initializeGameBoardObject() {
		gameBoard = new GameBoard();
	}

	@Test
	public void checkGameBoardObjectNotNull() {
		assertNotNull(gameBoard);
	}

	@Test
	public void checkIfXIsMarkedAtPositionZeroZeroIfPlayerXPlaysAtPositionZeroZero() {
		gameBoard.setInGameBoard(ZERO, ZERO, PLAYER_X);
		assertEquals(PLAYER_X, gameBoard.getFromGameBoard(ZERO, ZERO));
	}

	@Test
	public void checkIfOIsMarkedAtPositionZeroOneIfPlayerOPlaysAtPositionZeroOne() {
		gameBoard.setInGameBoard(ZERO, 1, 'O');
		assertEquals('O', gameBoard.getFromGameBoard(ZERO, 1));
	}
}
