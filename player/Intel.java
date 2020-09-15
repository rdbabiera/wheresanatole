package player;

import card.*;

public class Intel {
	public CardTeam team;
	public Characters character;
	public int clout;
	
	public Intel() {
		this.team = CardTeam.UNKNOWN;
		this.character = Characters.UNKNOWN;
		this.clout = 0;
	}
	
	public void printIntel() {
		System.out.println("Team: " + this.team);
		System.out.println("Character: " + this.character);
		System.out.println("Clout: " + this.clout);
		System.out.println();
	}
}
