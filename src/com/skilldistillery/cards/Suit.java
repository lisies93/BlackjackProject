package com.skilldistillery.cards;

public enum Suit {
	HEARTS("Hearts"), 
	SPADES("Spades"), 
	CLUBS("Clubs"), 
	DIAMONDS("Diamonds");
	
	Suit(String s){
	name = s;
	}
	 private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 @Override
	  public String toString() {
	    return name;
	  }
	
}
