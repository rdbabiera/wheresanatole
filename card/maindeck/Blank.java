package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class Blank extends Card{
	public Blank(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		System.out.println(player.identity + " used Splash! But nothing happened!");
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
	}
}
