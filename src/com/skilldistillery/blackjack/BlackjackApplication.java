package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApplication {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
        BlackjackApplication ba = new BlackjackApplication();
		BlackjackTable bt = new BlackjackTable();
		boolean again = true;
		ba.welcome();
		do {
		bt.play();
		System.out.println("Do you want to play again? (Y/N)");
		String yesOrnot = kb.nextLine();
		if(yesOrnot.equalsIgnoreCase("y")) {
		again = true;	
		} else {
		again = false;
		System.out.println();
		System.out.println("Thanks for playing goodbye!");
		}
		}while(again);
		kb.close();
	}

	private void welcome() {

		System.out.println("           Welcome to Royal Casino");
		System.out.println("**********************************************");
		System.out.println();
		System.out.println("Please take a seat the game is about to start!");
	}

	
}
