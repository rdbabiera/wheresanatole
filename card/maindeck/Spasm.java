package card.maindeck;

import java.util.ArrayList;
import java.util.Collections;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class Spasm extends Card{
	public Spasm(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		int i;
		Card newid;
		ArrayList<Card> ids = new ArrayList<Card>();
		for (i=1;i<game.gameSize;i++) {
			ids.add(game.turnOrder[i].idcard);
		}
		Collections.shuffle(ids);
		for (i=1;i<game.gameSize;i++) {
			newid = ids.remove(0);
			game.turnOrder[i].idcard = newid;
			game.turnOrder[i].identity = newid.name;
			game.turnOrder[i].team = newid.team;
			game.publicIntel[i].character = Characters.UNKNOWN;
			game.publicIntel[i].team = CardTeam.UNKNOWN;
		}
		game.updatePublicInfo();
		System.out.println("Anatole has spasmed out to the sight of some "
				+ "unsightly photoshoped work! Everyone will now wake up "
				+ "Chris Breezy!");
		System.out.println("Your new identity is now " + 
				game.turnOrder[game.playerSpot].identity + ", and your " + 
				"allegiance lies with " + game.turnOrder[game.playerSpot].team);
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
	}
}
