package com.bnpp.kata;

import java.util.Scanner;

public class PlayTicTacToeGame {

	public static void main(String[] args) {
		Scanner keyboardInput = new Scanner(System.in);
		int row = -1;
		int column = -1;
		char winner = '\0';
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		while(!ticTacToeGame.isGameOver()) {
			if(keyboardInput.hasNextInt()) {
				row = keyboardInput.nextInt();
			}
			if(keyboardInput.hasNextInt()) {
				column = keyboardInput.nextInt();
			}
			ticTacToeGame.drawOnBoard(row, column);
			winner = ticTacToeGame.getGameBoard().checkForResultOfTheGame();
		}
		System.out.println("winner: "+ winner);
		keyboardInput.close();
	}

}
