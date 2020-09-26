package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Human;
import player.Player;

public class BanHammer extends Card{
	public BanHammer(String name, String desc, CardTeam team, Characters character, 
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
		int selection;
		if (player.isHuman) {
			System.out.println("Who would you like to ban?");
			Human human = (Human) player;
			selection = human.scan.nextInt();
			while ((selection < 1) || (selection >= game.gameSize) || 
					(selection == player.position)) {
				System.out.println("Not a valid input... Try again");
				selection = human.scan.nextInt();
			}
		} else {
			/* Need to do AI */
			selection = game.gameSize - 1;
		}
		
		game.turnOrder[selection].isAlive = false;
		if (game.turnOrder[selection].identity.equals("Anatole")) {
			game.tWin = true;
			System.out.println("Anatole has been banned from the game! Team Toby will win "
					+ "at the end of the day!");
		} else {
			System.out.println("A player has been banned from the game!");
		}
		game.publicIntel[player.position].character = player.idcard.character;
		game.publicIntel[player.position].team = player.team;
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
