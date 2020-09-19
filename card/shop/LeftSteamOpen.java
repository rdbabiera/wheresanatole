package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;
import player.Player;
import game.*;

public class LeftSteamOpen extends ShopCard {
	public LeftSteamOpen(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
	}
	
	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		int i;
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = this.playCheck(player);
	}

}
