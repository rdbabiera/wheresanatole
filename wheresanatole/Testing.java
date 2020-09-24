package wheresanatole;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import card.*;
import card.maindeck.*;
import game.*;
import player.*;

public class Testing {
	public static void main(String[] args) {
		
		int i;
		
		Game game = new Game(3, 3);
		for (i=0;i<game.gameSize;i++) {
			System.out.println(game.turnOrder[i].identity);
		}
		game.turnOrder[game.playerSpot].clout = 100;
		Card card = new KennethCard("Ken", "Ken", CardTeam.GENERAL, Characters.ALL, PlayType.REVEAL, CardAI.NONE);
		game.turnOrder[game.playerSpot].hand.addCard(card);
		card.drawUpdate(game.turnOrder[game.playerSpot], game);
		game.startDay();
		game.startDay();
	}
}
 