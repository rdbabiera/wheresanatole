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
		player.intel[game.anatoleSpot].character = Characters.ANATOLE;
		player.intel[game.anatoleSpot].team = CardTeam.ANATOLE;
		System.out.println("A player has discovered the location of Anatole!");
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.canPlay = this.playCheck(recep);
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = this.playCheck(player);
		this.canTrade = true;
	}

}
