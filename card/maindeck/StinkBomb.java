package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class StinkBomb extends Card{
	public StinkBomb(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}
	
	boolean armed = false;

	public void turnUpdate(Player player, Game game) {
		if (this.armed) {
			return;
		}
		if (this.character != player.idcard.character) {
			int pos = -1;
			int i;
			for (i=0; i<player.hand.size(); i++) {
				if (player.hand.get(i).equals(this)) {
					pos = i;
					break;
				}
			}
			Card card = player.hand.remove(pos);
			player.discardCard(card, game.drawnSpecials);
		}
	}

	public void revealUpdate(Player player, Game game) {
		
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.armed = true;
		this.canTrade = false;
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = false;
		this.canTrade = this.tradeCheck(player);
	}
}
