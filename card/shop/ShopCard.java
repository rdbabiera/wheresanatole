package card.shop;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;

public class ShopCard extends Card {
	int cost;
	
	public ShopCard(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cAI);
		this.cost = cost;
	}
}
