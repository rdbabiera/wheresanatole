package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import card.anatolecards.*;
import game.Game;
import player.Characters;
import player.Player;

public class Yapstone extends Card{
	public static int yapCount = 0;
	
	public Yapstone(String name, String desc, CardTeam team, Characters character, 
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
		yapCount = countStones(player);
		if (yapCount == 3) {
			String name = "History Paper";
			String desc = "You win if you are holding this card as Alan and "
					+ "are called on by Toby.";
			Card card = new HistoryPaper(name, desc, CardTeam.ANATOLE, 
					Characters.ANATOLE, PlayType.HELD, CardAI.ANATOLE);
			player.hand.addCard(card);
			yapCount = 0;
		}
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		if (player.identity.equals("Anatole")) {
			this.canPlay = true;
		}
		this.canTrade = true;
	}
	
	public int countStones(Player player) {
		int i;
		int count = 0;
		for (i=0; i<player.hand.size(); i++) {
			if (player.hand.get(i).name.equals("Yapstone")) {
				count += 1;
			}
		}
		return count;
	}
}