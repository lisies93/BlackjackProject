package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
	}

	private int initialDeal = 2;

	public int getInitialDeal() {
		return initialDeal;
	}

	@Override
	public int getHandValue() {
		int handValue = 0;

		for (Card card : cards) {
			handValue = handValue + card.getValue();
		}

		return handValue;
	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;
	}

}
