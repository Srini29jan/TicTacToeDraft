package com.bnpp.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {

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
		gameBoard.setInGameBoard(0, 0, 'X');
		assertEquals('X', gameBoard.getFromGameBoard(0, 0));
	}
}
