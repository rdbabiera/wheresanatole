package card.maindeck;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Human;
import player.Player;

public class Ace extends Card{
	public Ace(String name, String desc, CardTeam team, Characters character, 
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
		Random rand = new Random();
		int num = rand.nextInt((game.gameSize/2));
		if (num == 0) {
			num = 1;
		}
		int[] list = new int[num];
		CardTeam[] tList = new CardTeam[num];
		Characters[] cList = new Characters[num];
		int i, j;
		int guess;
		
		if (player.isHuman) {
			Human human = (Human) player;
			System.out.println("You must select " + num + " player(s).");
			System.out.println("Round Start!");
			for (i=0; i<num; i++) {
				guess = human.scan.nextInt();
				while ((guess < 0 || guess >= game.gameSize) && 
						!contains(list, guess)) {
					System.out.println("Not a valid guess... Try again");
					guess = human.scan.nextInt();
				}
				list[i] = guess;
				tList[i] = game.turnOrder[guess].team;
				cList[i] = game.turnOrder[guess].idcard.character;
			}
		} else {
			
		}
		
		boolean ace = true;
		CardTeam first = tList[0];
		for (i=0; i<num; i++) {
			if (tList[i] != first) {
				ace = false;
				break;
			}
		}
		if (ace) {
			for (i=0; i<game.gameSize; i++) {
				if (game.turnOrder[i].team == player.team) {
					for (j=0;j<num;j++) {
						game.turnOrder[i].intel[list[j]].character = cList[j];
						game.turnOrder[i].intel[list[j]].team = tList[j];
					}
				}
			}
			System.out.println("Ace! An excellent 1v9 from " + player.identity);
		} else {
			System.out.println("Round Lost...");
		}
	}

	public void tradeUpdate(Player sender, Player recep) {
		this.canPlay = this.playCheck(recep);
		
	}

	public void drawUpdate(Player player, Game game) {
		this.canPlay = this.playCheck(player);
		this.canTrade = true;
	}
	
	public boolean contains(int[] list, int guess) {
		int i;
		for (i=0; i<list.length; i++) {
			if (list[i] == guess) {
				return true;
			}
		}
		return false;
	}
}
