package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class DefusalKit extends Card{
	public DefusalKit(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		System.out.println("A disciplinary commitee member has a defuser!");
		int i,j;
		int defuseCount = 0;
		for (i=0;i<game.gameSize;i++) {
			for (j=game.turnOrder[i].hand.size()-1; j>=0; j--) {
				if (game.turnOrder[i].hand.get(j).name.equals("Snack Bomb")) {
					System.out.println("A bomb has been defused at Site " + i);
					defuseCount++;
					game.turnOrder[i].hand.remove(j);
				}
			}
		}
		System.out.println(defuseCount + " bombs have been defused!");
		for (i=0; i<defuseCount; i++) {
			player.promptDraw(game);
		}
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.canPlay = this.playCheck(recep);
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = this.playCheck(player);
		this.canTrade = true;
	}
}