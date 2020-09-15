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
	public int[] presence; /* [At School, Days to be Missed, Is Alive] */
	public int[] statuses; /* Days with Bomb, Clout */
	public Intel[] intel;
	
	/* Constructor */
	public Player(Card idcard, int gameSize) {
		this.hand = new Hand();
		this.idcard = idcard;
		this.identity = idcard.name;
		this.team = idcard.team;
		
		
		this.presence = new int[3];
		this.presence[0] = 1;
		this.presence[1] = 0;
		this.presence[2] = 1;
		this.statuses = new int[2];
		this.statuses[0] = 0;
		this.statuses[1] = 0;
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