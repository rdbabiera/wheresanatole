package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class Snackbomb extends Card{
	public int timer;
	
	public Snackbomb(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
		this.timer = 0;
	}
	

	public void turnUpdate(Player player, Game game) {
		this.timer += 1;
		if (this.timer > 1) {
			player.isAlive = false;
			System.out.println("A player has held on to a snackbomb for too "
					+ "long and has passed out from a food coma.");
		}
	}

	public void revealUpdate(Player player, Game game) {
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.timer = 0;
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = false;
		this.canTrade = true;
	}
}
