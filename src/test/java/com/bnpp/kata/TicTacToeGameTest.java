package com.bnpp.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeGameTest {

	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final char CHAR_NULL = '\0';

	protected TicTacToeGame ticTacToeGame;

	@Before
	public void initializeTicTacToeGameObject() {
		ticTacToeGame = new TicTacToeGame();
	}

	@Test
	public void checkTicTacToeGameObjectNotNull() {
		assertNotNull(ticTacToeGame);
	}

	@Test
	public void checkIfTicTacToeGameBoardPositionZeroZeroIsInitializedToNullCharacter() {
		assertEquals(CHAR_NULL, ticTacToeGame.getGameBoard().ticTacToeGameBoard[ZERO][ZERO]);
	}

	@Test
	public void checkIfTicTacToeGameBoardPositionZeroOneIsInitializedToNullCharacter() {
		assertEquals(CHAR_NULL, ticTacToeGame.getGameBoard().ticTacToeGameBoard[ZERO][ONE]);
	}
}
