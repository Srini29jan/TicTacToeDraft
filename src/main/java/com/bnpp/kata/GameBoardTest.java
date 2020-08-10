package com.bnpp.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {

	private static final int TWO = 2;
	private static final char PLAYER_O = 'O';
	private static final char PLAYER_X = 'X';
	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int THREE = 3;
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
	public void checkIfXIsMarkedAtPositionZeroZeroIfPlayerXPlaysAtPositionZeroZero() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, ZERO, PLAYER_X);
		assertEquals(PLAYER_X, gameBoard.getFromGameBoard(ZERO, ZERO));
	}

	@Test
	public void checkIfOIsMarkedAtPositionZeroOneIfPlayerOPlaysAtPositionZeroOne() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, ONE, PLAYER_O);
		assertEquals(PLAYER_O, gameBoard.getFromGameBoard(ZERO, ONE));
	}

	@Test(expected = InvalidMoveException.class)
	public void checkIfExceptionIsThrownIfInputRowIsBeyondTwo() throws InvalidMoveException {
		gameBoard.setInGameBoard(THREE, ZERO, PLAYER_X);
	}

	@Test(expected = InvalidMoveException.class)
	public void checkIfExceptionIsThrownIfInputRowIsLessThanZero() throws InvalidMoveException {
		gameBoard.setInGameBoard(-ONE, ZERO, PLAYER_X);
	}

	@Test(expected = InvalidMoveException.class)
	public void checkIfExceptionIsThrownIfInputColumnIsBeyondTwo() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, THREE, PLAYER_X);
	}

	@Test(expected = InvalidMoveException.class)
	public void checkIfExceptionIsThrownIfInputColumnIsLessThanZero() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, -ONE, PLAYER_X);
	}

	@Test(expected = InvalidMoveException.class)
	public void checkIfExceptionIsThrownIfAPositionIsPlayedTwice() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, ZERO, PLAYER_X);
		gameBoard.setInGameBoard(ZERO, ZERO, PLAYER_X);
	}

	@Test
	public void checkIfNumberOfCellsFilledIsOneForOneValidMoveByAPlayer() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, ZERO, PLAYER_X);
		assertEquals(1, gameBoard.numberOfCellsFilled);
	}

	@Test
	public void checkIfNumberOfCellsFilledIsTwoForTwoValidMovesByAlternatePlayers() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, ZERO, PLAYER_X);
		gameBoard.setInGameBoard(ZERO, ONE, PLAYER_O);
		assertEquals(2, gameBoard.numberOfCellsFilled);
	}

	@Test
	public void checkIfCurrentPlayerIsXForFirstMove() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, ZERO);
		assertEquals(PLAYER_X, gameBoard.currentPlayer);
	}

	@Test
	public void checkIfWinnerIsXIfXFillsFirstRow() throws InvalidMoveException {
		gameBoard.setInGameBoard(ZERO, ZERO);
		gameBoard.setInGameBoard(ONE, ZERO);
		gameBoard.setInGameBoard(ZERO, ONE);
		gameBoard.setInGameBoard(TWO, ZERO);
		gameBoard.setInGameBoard(ZERO, TWO);
		assertEquals(PLAYER_X, gameBoard.checkForResultOfTheGame());
	}

	@Test
	public void checkIfWinnerIsXIfXFillsSecondRow() throws InvalidMoveException {
		gameBoard.setInGameBoard(ONE, ZERO);
		gameBoard.setInGameBoard(ZERO, ZERO);
		gameBoard.setInGameBoard(ONE, ONE);
		gameBoard.setInGameBoard(TWO, ZERO);
		gameBoard.setInGameBoard(ONE, TWO);
		assertEquals(PLAYER_X, gameBoard.checkForResultOfTheGame());
	}
}
