package com.skilldistillery.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackjackTable {

	public void play() {
		Deck d = new Deck();
		BlackjackHand playerHand = new BlackjackHand();
		BlackjackHand dealerHand = new BlackjackHand();

		System.out.println("Shuffling deck.....");
		System.out.println();
		d.shuffle();
		int value = 0;
		int valueD = 0;

		for (int i = 0; i < playerHand.getInitialDeal(); i++) {
			Card cp = d.dealCard();
			Card cd = d.dealCard();
			value = value + cp.getValue();
			valueD = valueD + cd.getValue();
			playerHand.addCard(cp);
			dealerHand.addCard(cd);
			if (i == 0) {
				System.out.println("Dealer hand: ");
				dealerHand.showHand();
				System.out.println("Dealer value: " + dealerHand.getHandValue());
				System.out.println();
			}
		}
		showPlayerHand(playerHand);
		
		boolean keepGoing = checkPoints(playerHand, dealerHand);
		while (keepGoing) {

			boolean go = hitOrStand();
			while (go) {
				Card cp = d.dealCard();
				playerHand.addCard(cp);
				showPlayerHand(playerHand);
				keepGoing = checkPoints(playerHand, dealerHand);
				if(keepGoing) {
					if(hitOrStand()) {
						continue;
						
					}
				} else {
					break;
				}
			}

			if (go == false) {
				showDealerHand(dealerHand);
				
				while (dealerHand.getHandValue() <= 16) {
					Card cd = d.dealCard();
					dealerHand.addCard(cd);
					showDealerHand(dealerHand);
					keepGoing = checkPoints(playerHand, dealerHand);
				}
				if ((dealerHand.getHandValue() > playerHand.getHandValue()) && (dealerHand.getHandValue() <=21)) {
					System.out.println("Dealer wins");
				} else if (dealerHand.getHandValue() == playerHand.getHandValue()) {
					System.out.println("Its a push!");
				} else {
					System.out.println("You won!");

				}
			}
		}

	}

	private boolean checkPoints(BlackjackHand playerHand, BlackjackHand dealerHand) {
		boolean result = true;
		if (playerHand.isBlackjack()) {
			showDealerHand(dealerHand);
			System.out.println("Blackjack!");
			System.out.println("You Won!");
			result = false;
		}
		if (dealerHand.isBlackjack()) {
			System.out.println("Dealer has blackjack");
			System.out.println("You Lost!");

			result = false;
		}
		if (playerHand.isBust()) {
			System.out.println("You bust");
			System.out.println("Dealer wins");
			result = false;
		}
		if (dealerHand.isBust()) {
			System.out.println("Dealer has bust");
			System.out.println("You won!");
			result = false;
		}
		return result;

	}

	private void showDealerHand(BlackjackHand dealerHand) {
		System.out.println("Dealer hand: ");
		dealerHand.showHand();
		System.out.println("Dealer value: " + dealerHand.getHandValue());
		System.out.println();		
	}

	private void showPlayerHand(BlackjackHand playerHand) {
		System.out.println("Your hand: ");
		playerHand.showHand();
		System.out.println("Hand value: " + playerHand.getHandValue());
	}

	private boolean hitOrStand() {

		Scanner kb = new Scanner(System.in);

		System.out.println("Hit or Stand?");
		String option = kb.nextLine();

		if (option.equalsIgnoreCase("hit")) {
			return true;
		}
		return false;

	}

}
