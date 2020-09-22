package player;

import java.util.ArrayList;

import card.*;

public class Hand {
	public static int maxSize = 7;
	public ArrayList<Card> hand;
	
	public Hand() {
		this.hand = new ArrayList<Card>();
	}
	
	public boolean canPlay() {
		int i;
		for (i=0; i<this.size(); i++) {
			if (this.get(i).canPlay) {
				return true;
			}
		}
		return false;
	}
	
	public boolean canTrade() {
		int i;
		for (i=0; i<this.size(); i++) {
			if (this.get(i).canTrade) {
				return true;
			}
		}
		return false;
	}
	
	
	public void displayHand() {
		int i;
		System.out.println("Displaying Hand...");
		for (i=0;i<this.hand.size();i++) {
			Card temp = this.hand.get(i);
			System.out.printf("Card #%d:\nName: %s\n", i, temp.name);
			System.out.printf("\tDescription: %s\n\tTeam: %s\n",temp.desc, 
					temp.team.name());
			System.out.printf("\tCharacter: %s\n\tPlayType: %s\n",
					temp.character.name(), temp.type.name());
		}
		System.out.println("End of Hand");
	}
	
	public int checkFor(String str) {
		int i;
		for (i=0; i<this.hand.size(); i++) {
			if (this.hand.get(i).name.equals(str)) {
				return 1;
			}
		}
		return 0;
	}
	
	public Card get(int index) {
		if ((index >= 0) && (index < this.size())) {
			return this.hand.get(index);
		}
		return null;
	}
	
	public Card remove(int index) {
		if ((index >= 0) && (index < this.size())) {
			return this.hand.remove(index);
		}
		return null;
	}
	
	public void discardSpecific(String str) {
		int i;
		for (i=0; i<this.hand.size(); i++) {
			if (this.hand.get(i).name.equals(str)) {
				this.hand.remove(i);
				return;
			}
		}
	}
	
	public void addCard(Card card) {
		this.hand.add(card);
	}
	
	public int size() {
		return this.hand.size();
	}
	
}
