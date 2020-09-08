package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;

public class Overheard extends ShopCard {
	public Overheard(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
		
	}
}
