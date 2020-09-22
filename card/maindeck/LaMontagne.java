package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Intel;
import player.Player;

public class LaMontagne extends Card{
	public LaMontagne(String name, String desc, CardTeam team, Characters character, 
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
		Intel[] reveal = new Intel[game.gameSize];
		int i, j;
		for (i=0; i<game.gameSize; i++) {
			reveal[i] = new Intel();
			if (game.turnOrder[i].team == CardTeam.TOBY) {
				reveal[i].character = game.turnOrder[i].idcard.character;
				reveal[i].team = game.turnOrder[i].team;
			}
		}
		for (i=0; i<game.gameSize; i++) {
			if (game.turnOrder[i].team == CardTeam.ANATOLE) {
				for (j=0; j<game.gameSize; j++) {
					if (reveal[j].team == CardTeam.TOBY) {
						game.turnOrder[i].intel[j].character = reveal[j].character;
						game.turnOrder[i].intel[j].team = reveal[j].team;
					}
				}
			}
		}
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.canPlay = this.playCheck(recep);
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = this.playCheck(player);
		this.canTrade = true;
	}
}