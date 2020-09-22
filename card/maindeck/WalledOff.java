package card.maindeck;

import java.util.Random;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Human;
import player.Player;

public class WalledOff extends Card{
	public WalledOff(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		int selection;
		if (player.isHuman) {
			System.out.println("Who would you like to block off?");
			Human human = (Human) player;
			selection = human.scan.nextInt();
			while ((selection < 0) || (selection >= game.gameSize) || 
					(selection == player.position)) {
				System.out.println("Not a valid input... Try again");
				selection = human.scan.nextInt();
			}
		} else {
			/* Need to do AI */
			selection = game.gameSize - 1;
		}
		
		if (game.turnOrder[selection].hand.size() < 1) {
			return;
		}
		Random rand = new Random();
		int pos = rand.nextInt(game.turnOrder[selection].hand.size());
		game.turnOrder[selection].hand.remove(pos);
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
	}
}