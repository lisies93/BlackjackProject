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
				showDealerHand(dealerHand);

			}
		}
		showPlayerHand(playerHand);

		boolean keepGoing = checkPoints(playerHand, dealerHand);

		while (keepGoing) {
			boolean go = hitOrStand();
			if (go) {
				Card cp = d.dealCard();
				playerHand.addCard(cp);
				showPlayerHand(playerHand);
				keepGoing = checkPoints(playerHand, dealerHand);
				if (keepGoing) {

					continue;
				} else {
					break;
				}
			} else {

				showDealerHand(dealerHand);

				while (dealerHand.getHandValue() <= 16) {
					Card cd = d.dealCard();
					dealerHand.addCard(cd);
					System.out.println("Hits..");
					System.out.println();
					showDealerHand(dealerHand);
					keepGoing = checkPoints(playerHand, dealerHand);
				}
				if ((dealerHand.getHandValue() > playerHand.getHandValue()) && (dealerHand.getHandValue() <= 21)) {
					System.out.println("Dealer wins");
					break;
				} else if (dealerHand.getHandValue() == playerHand.getHandValue()) {
					System.out.println("Its a push!");
					break;
				} else {
					System.out.println("You won!");
					break;

				}
			}
		}
	}

	// method to check point each time a player hits
	private boolean checkPoints(BlackjackHand playerHand, BlackjackHand dealerHand) {
		boolean result = true;
		if (playerHand.isBlackjack()) {
			showDealerHand(dealerHand);
			System.out.println("Blackjack!");
			System.out.println("You Won!");
			result = false;
		}
		if (dealerHand.isBlackjack()) {
			System.out.println();
			System.out.println("Dealer has blackjack");
			showDealerHand(dealerHand);
			System.out.println("You Lost!");

			result = false;
		}
		if (playerHand.isBust()) {
			System.out.println("You bust");
			System.out.println("Dealer wins");
			result = false;
		}
		if (dealerHand.isBust()) {
			System.out.println("Dealer bust");
			result = false;
		}
		return result;

	}

	private void showDealerHand(BlackjackHand dealerHand) {
		System.out.println("Dealer's hand: ");
		dealerHand.showHand();
		System.out.println("Dealer's value: " + dealerHand.getHandValue());
		System.out.println();
	}

	private void showPlayerHand(BlackjackHand playerHand) {
		System.out.println("Your hand: ");
		playerHand.showHand();
		System.out.println("Hand value: " + playerHand.getHandValue());
	}

	private boolean hitOrStand() {

		Scanner kb = new Scanner(System.in);

		boolean go = true;
		boolean hitOrstand = true;
		while(go) {
		System.out.println("Hit or Stand?");
		String option = kb.nextLine();
        	
        	if (option.equalsIgnoreCase("hit")) {
        		go = false;
        		hitOrstand = true;
        		;
        	} else if (option.equalsIgnoreCase("stand")){
        		go = false;
        		hitOrstand = false;
        	} else {
        		System.out.println("Invalid option please try again");
        		go = true;
        	}
        }
		return hitOrstand;
	}

}
