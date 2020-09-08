package player;

import java.util.ArrayList;

import card.*;

public class Hand {
	public static int maxSize = 7;
	ArrayList<Card> hand;
	
	public Hand() {
		this.hand = new ArrayList<Card>();
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
	
	
}
