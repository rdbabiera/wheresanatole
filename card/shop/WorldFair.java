package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;
import player.Player;
import game.*;

public class WorldFair extends ShopCard {
	public WorldFair(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
	}
	
	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		game.turnOrder[0].searchDelay += 2;
		System.out.println("Toby has been impressed by the World Fair, "
				+ "and his mind has been taken off Anatole.");
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canTrade = true;
		this.canPlay = true;
	}
}
