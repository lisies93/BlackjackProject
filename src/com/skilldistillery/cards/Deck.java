package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> cards;  
	
	
	
	public Deck() {
	cards = new ArrayList<Card>(52);
	
	for (Suit s : Suit.values()) {
		for(Rank r : Rank.values()) {
			cards.add(new Card(s, r));
		}
	}
	
	
	
	}

	public int checkDeckSize() {
		return cards.size();
	}
	
	public Card dealCard() {
		shuffle();
		return cards.remove(0);
		
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
}
