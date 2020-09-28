package player;

import java.util.Random;

import card.Card;
import game.*;

public class TobyAI extends Player{

	public TobyAI(Card idcard, int gameSize, int position) {
		super(idcard, gameSize);
		this.position = position;
		this.searchDelay = 0;
	}

	public void playTurn(Game game) {
		
	}


	public int promptToby(int gameSize) {
		Random rand = new Random();
		int guess = rand.nextInt(gameSize);
		if (guess == 0) {
			guess = -1;
		}
		return guess;
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
