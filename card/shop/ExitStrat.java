package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;
import player.Player;
import game.*;

public class ExitStrat extends ShopCard {
	public ExitStrat(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
		
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		if (player.team == CardTeam.ANATOLE) {
			player.team = CardTeam.TOBY;
		} else if (player.team == CardTeam.TOBY) {
			player.team = CardTeam.ANATOLE;
		}
		System.out.println("A Player has Switched Teams!");
		
		int i;
		for (i=0; i<game.gameSize; i++) {
			if (game.turnOrder[i].intel[player.position].team != CardTeam.UNKNOWN) {
				game.turnOrder[i].intel[player.position].team = player.team;
			}
		}
	}

	public void tradeUpdate(Player sender, Player recep) {
		if (recep.identity.equals("Toby")) {
			this.canPlay = false;
		} else {
			if (this.canPlay = false) {
				this.canPlay = true;
			}
		}
	}
	
	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
		this.removeTurnEnd = false;
	}

	
}
