package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class BreachAndClear extends Card{
	public BreachAndClear(String name, String desc, CardTeam team, Characters character, 
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
		System.out.println(player.identity + " has cleared out the room! "
				+ "Only revealed disciplinary commitee members may draw"
				+ "cards!");
		game.day.bCdays += 2;
		game.day.breachClear = true;
		game.publicIntel[player.position].character = player.idcard.character;
		game.publicIntel[player.position].team = player.team;
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.canPlay = this.playCheck(recep);
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = this.playCheck(player);
		this.canTrade = true;
	}
}
