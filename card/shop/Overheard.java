package card.shop;

import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.*;
import player.Characters;
import player.Player;

public class Overheard extends ShopCard {
	public Overheard(String name, String desc, CardTeam team, Characters character, 
			PlayType type, int cost, CardAI cAI){
		super(name, desc, team, character, type, cost, cAI);
		
	}
	
	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		int i, j;
		for (i=0; i<game.gameSize; i++) {
			for (j=0; j<game.gameSize; j++) {
				if ((j != i) && (game.turnOrder[i].intel[j].character != 
						Characters.UNKNOWN)) {
					game.publicIntel[j].character = 
							game.turnOrder[i].intel[j].character;
					game.publicIntel[j].team = game.turnOrder[i].intel[j].team;
				}
			}
		}
		game.updatePublicInfo();
		System.out.println("A private conversation has been overheard! Nobody's "
				+ "information is safe!");
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
	}
}
