package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class EarlyDismissal extends Card{
	public EarlyDismissal(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		int i;
		for (i=player.position+1; i<game.gameSize; i++) {
			game.turnOrder[i].skipTurn = true;
		}
		System.out.println("Mr. Katt's needs to be at his son's halloween parade. Class is dismissed!");
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
		
	}
}