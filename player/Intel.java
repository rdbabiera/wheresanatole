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
}
