package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class RadarJammer extends Card{
	public RadarJammer(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
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
		game.day.tradeBan = true;
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.canPlay = this.playCheck(recep);
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = this.playCheck(player);
		this.canTrade = true;
	}
}