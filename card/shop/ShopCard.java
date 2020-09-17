package card.shop;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;

public abstract class ShopCard extends Card {
	public int cost;
	
	public ShopCard(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cAI);
		this.cost = cost;
	}

	public abstract void update();
	public abstract void reveal();
	public abstract void trade();
	public abstract void drawUpdate();
}
