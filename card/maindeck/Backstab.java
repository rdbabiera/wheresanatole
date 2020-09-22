package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.*;

public class Backstab extends Card{
	public Backstab(String name, String desc, CardTeam team, Characters character, 
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
		int selection;
		if (player.isHuman) {
			System.out.println("Who would you like to reveal?");
			Human human = (Human) player;
			selection = human.scan.nextInt();
			while ((selection < 0) || (selection >= game.gameSize)) {
				System.out.println("Not a valid input... Try again");
				selection = human.scan.nextInt();
			}
		} else {
			/* Need to do AI */
			selection = game.gameSize - 1;
		}
		
		game.publicIntel[player.position].character = player.idcard.character;
		game.publicIntel[player.position].team = player.team;
		game.publicIntel[selection].character = game.turnOrder[selection].idcard.character;
		game.publicIntel[selection].team = game.turnOrder[selection].team;
		System.out.println(player.identity +" has revealed a player! " + 
			game.turnOrder[selection].identity + " has been located!");
		game.updatePublicInfo();
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.canPlay = this.playCheck(recep);
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = this.playCheck(player);
		this.canTrade = true;
	}
}
