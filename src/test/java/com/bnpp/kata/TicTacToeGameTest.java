package com.bnpp.kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeGameTest {

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
		assertEquals('\0', ticTacToeGame.ticTacToeGameBoard[0][0]);
	}
}
