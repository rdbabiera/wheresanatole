package player;

import card.*;

public class Human extends Player{
	boolean isPlayer;
	public Human(Card idcard) {
		super(idcard);
		this.isPlayer = true;
	}
}
