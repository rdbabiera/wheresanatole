package player;

import card.Card;
import game.*;

public class AI extends Player {

	public AI(Card idcard, int gameSize, int position) {
		super(idcard, gameSize);
		this.position = position;
	}

	public void playTurn(Game game) {
		
	}

	public int promptToby(int gameSize) {
		return 0;
	}

	public void promptDraw(Game game) {
	}

	public void promptReveal(Game game) {
		
	}

	public void promptTrade(Game game) {
		
	}

	public void promptBuy(Game game) {
		
	}

	public boolean promptEscape() {
		return false;
	}

}
