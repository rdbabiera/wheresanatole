package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;

public class ExitStrat extends ShopCard {
	public ExitStrat(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
		
	}
}
