package com.skilldistillery.blackjack;

public class BlackjackApplication {

	public static void main(String[] args) {
        BlackjackApplication ba = new BlackjackApplication();
		BlackjackTable bt = new BlackjackTable();
		ba.welcome();
		bt.play();
	}

	private void welcome() {

		System.out.println("           Welcome to Royal Casino");
		System.out.println("**********************************************");
		System.out.println();
		System.out.println("Please take a seat the game is about to start!");
	}

	
}
