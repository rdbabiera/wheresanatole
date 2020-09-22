package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;
import player.Player;
import game.*;

public class Uber extends ShopCard {
	public Uber(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
		
	}
	
	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		int i;
		for (i=1; i<game.gameSize; i++) {
			game.turnOrder[i].daysMissing = 0;
			game.turnOrder[i].isPresent = true;
		}
		System.out.println("All players have been returned to school, "
				+ "and anyone planning to skip has had a 'voluntary' "
				+ "change of heart.");
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
	}
}
