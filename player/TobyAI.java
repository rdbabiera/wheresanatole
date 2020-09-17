package player;

import card.Card;
import game.*;

public class TobyAI extends Player{

	public TobyAI(Card idcard, int gameSize, int position) {
		super(idcard, gameSize);
		this.position = position;
		// TODO Auto-generated constructor stub
	}

	public void playTurn(Game game) {
		
	}


	public int promptToby(int gameSize) {
		return 0;
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
