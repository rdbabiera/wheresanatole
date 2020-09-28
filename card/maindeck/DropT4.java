package card.maindeck;

import java.util.ArrayList;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Human;
import player.Player;

public class DropT4 extends Card{
	public DropT4(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		ArrayList<Card> donation = new ArrayList<Card>();
		int i;
		boolean noTargets = true;
		for (i=0; i<game.gameSize;i++) {
			if ((i != player.position) && (game.turnOrder[i].isAlive) && 
					(game.turnOrder[i].isPresent)){
				noTargets = false;
				break;
			}
		}
		
		if (noTargets) {
			System.out.println("Player " + player.position + " has failed to "
					+ "make a donation");
			return;
		}
		
		System.out.println("Player " + player.position + " is making a "
				+ "donation");
		
		int donateTo = 0;
		
		if (player.isHuman) {
			Human human = (Human) player;
			boolean done = false;
			boolean validTarget = false;
			int select;
			System.out.println("Please select the index of the player you "
					+ "would like to trade to");
			donateTo = human.scan.nextInt();
			if (game.turnOrder[donateTo].isPresent) {
				validTarget = true;
			}
			while (!validTarget) {
				System.out.println("Not a valid target... Try again");
				donateTo = human.scan.nextInt();
				if (game.turnOrder[donateTo].isPresent) {
					validTarget = true;
				}
			}
			
			while (!done && (human.hand.size() > 0)) {
				System.out.println("Please select the index of the card you "
						+ "would like to add to the package, or select a number "
						+ "greater than or equal to your handsize to finish.");
				human.hand.displayHand();
				select = human.scan.nextInt();
				while (select < 0) {
					System.out.println("But no negative numbers please...");
					select = human.scan.nextInt();
				}
				if (select >= human.hand.size()) {
					done = true;
				} else {
					donation.add(human.hand.remove(select));
				}
			}
		} else {
			
			
			
		}
		while (donation.size() > 0) {
			Card card = donation.remove(0);
			card.tradeUpdate(player, game.turnOrder[donateTo]);
			game.turnOrder[donateTo].hand.addCard(card);
		}
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = true;
		this.canTrade = true;
	}
}