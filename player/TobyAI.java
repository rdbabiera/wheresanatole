package player;

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
		return 1;
	}

	@Override
	public void promptDraw(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void promptReveal(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void promptTrade(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void promptBuy(Game game) {
		// TODO Auto-generated method stub
		
	}

}
