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
		
		Game game = new Game(5, 5);
		for (i=0;i<game.gameSize;i++) {
			System.out.println(game.turnOrder[i].identity);
		}
		game.turnOrder[game.playerSpot].clout = 100;
		Card card = new KennethCard("Ken", "Ken", CardTeam.GENERAL, Characters.ALL, PlayType.REVEAL, CardAI.NONE);
		game.mainDeck.deck.add(0, card);
		/* card.drawUpdate(game.turnOrder[game.playerSpot], game); */
		game.startDay();
		game.startDay();
		game.startDay();
		game.startDay();
	}
}
 