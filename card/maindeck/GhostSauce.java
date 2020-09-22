package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class GhostSauce extends Card{
	public GhostSauce(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		if (this.character != player.idcard.character) {
			player.hand.hand.remove(this);
			player.discardCard(this, game.drawnSpecials);
		}
	}

	public void revealUpdate(Player player, Game game) {
		
	}

	public void tradeUpdate(Player sender, Player recep) {
		recep.canPlay = false;
		this.canTrade = false;
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = false;
		this.canTrade = this.tradeCheck(player);
		
	}
}
