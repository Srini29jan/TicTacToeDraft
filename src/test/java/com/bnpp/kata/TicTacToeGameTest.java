package com.bnpp.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicTacToeGameTest {

	@Test
	public void checkTicTacToeGameObjectNotNull() {
		assertNotNull(new TicTacToeGame());
	}

	@Test
	public void checkIfTicTacToeGameBoardPositionZeroZeroIsInitializedToNullCharacter() {
		assertEquals('\0', new TicTacToeGame().ticTacToeGameBoard[0][0]);
	}
}
