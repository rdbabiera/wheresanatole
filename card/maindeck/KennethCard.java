package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class KennethCard extends Card{
	public KennethCard(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		game.publicIntel[player.position].character = player.idcard.character;
		game.publicIntel[player.position].team = player.team;
		game.updatePublicInfo();
		int pos = -1;
		int i;
		for (i=0; i<player.hand.size(); i++) {
			if (player.hand.get(i).equals(this)) {
				pos = i;
				break;
			}
		}
		Card card = player.hand.remove(pos);
		player.discardCard(card, game.discardPile);
		System.out.println("'Kenneth, I'm sorry.' -" + player.identity);
		System.out.println(player.identity + " is in the " + player.position + " spot.");
	}
}
