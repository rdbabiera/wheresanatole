package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;

public class Uber extends ShopCard {
	public Uber(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
		
	}
}
