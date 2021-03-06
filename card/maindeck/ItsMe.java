package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class ItsMe extends Card{
	public ItsMe(String name, String desc, CardTeam team, Characters character, 
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
		game.day.playBanDays += 2;
		game.day.playBan = true;
		System.out.println("IT'S MEEEEEEEEEEEEEEE");
	}

	public void tradeUpdate(Player sender, Player recep) {
		canPlay = this.playCheck(recep);
	}

	public void drawUpdate(Player player, Game game) {
		canPlay = this.playCheck(player);
		this.canTrade = true;
	}
}
