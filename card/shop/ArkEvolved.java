package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.*;
import player.Characters;
import player.Player;

public class ArkEvolved extends ShopCard {
	public ArkEvolved(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		player.arkOverride = true;
		System.out.println("A player has opened Ark: Survival Evolved! "
				+ "They may use any of their team's specials now!");
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
	}
	
}
