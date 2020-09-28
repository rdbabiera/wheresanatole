package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class PinkSlip extends Card{
	public PinkSlip(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}
	
	public boolean triggered = false;
	int daysLeft = 3;

	public void turnUpdate(Player player, Game game) {
		if (this.triggered) {
			daysLeft--;
		}
		if (this.daysLeft == 0) {
			int pos = -1;
			int i;
			for (i=0; i<player.hand.size(); i++) {
				if (player.hand.get(i).equals(this)) {
					pos = i;
					break;
				}
			}
			Card card = player.hand.remove(pos);
			player.discardCard(card, game.discardPile);
		}
	}

	public void revealUpdate(Player player, Game game) {
		
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.canTrade = this.tradeCheck(recep);
	}

	public void drawUpdate(Player player, Game game) {
		this.canTrade = this.tradeCheck(player);
		this.canPlay = false;
	}
}