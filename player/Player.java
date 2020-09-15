package player;
import card.*;
import game.*;

public abstract class Player {
	int i;
	/* Set Player Attributes */
	public int position;
	public Hand hand;
	public Card idcard;
	public String identity;
	public CardTeam team;
	public Intel[] intel;
	
	public boolean isPresent;
	public int daysMissing;
	public boolean isAlive;
	public int clout;
	
	/* Constructor */
	public Player(Card idcard, int gameSize) {
		this.hand = new Hand();
		this.idcard = idcard;
		this.identity = idcard.name;
		this.team = idcard.team;
		
		
		this.isPresent = true;
		this.daysMissing = 0;
		this.isAlive = true;
		this.clout = 0;
		this.intel = new Intel[gameSize];
		for (i=0;i<gameSize;i++){
			this.intel[i] = new Intel();
		}
	}
	
	/* Action Subroutines */
	public void drawCard(Deck deck) {
		if (deck.returnSize() < 1) {
			return;
		}
		this.hand.addCard(deck.removeCard(0));
	}
	
	public void discardCard(Card card, Deck discardPile) {
		discardPile.addCard(card);
	}

	/* Subroutines */
	abstract public void playTurn(Game game);
	abstract public int promptToby(int gameSize);
	abstract public void promptDraw(Game game);
	abstract public void promptReveal(Game game);
	abstract public void promptTrade(Game game);
	abstract public void promptBuy(Game game);
	
	public void updateHand() {
		int i;
		for (i=0; i<this.hand.size();i++) {
			
		}
	}
}