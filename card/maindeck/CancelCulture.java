package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Human;
import player.Player;

public class CancelCulture extends Card{
	public CancelCulture(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		int selection;
		if (player.isHuman) {
			System.out.println("Who would you like to remove?");
			Human human = (Human) player;
			selection = human.scan.nextInt();
			while ((selection < 1) || (selection >= game.gameSize)) {
				System.out.println("Not a valid input... Try again");
				selection = human.scan.nextInt();
			}
		} else {
			/* Need to do AI */
			selection = 1;
		}
		
		System.out.println("The player in spot " + 
		game.turnOrder[selection].position + " has been canceled for a day! "
				+ "Next time read your tweet before you send it!");
		game.turnOrder[selection].isPresent = false;
		game.turnOrder[selection].daysMissing += 1;
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
	}
}