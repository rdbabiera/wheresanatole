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
		
		Game game = new Game(6, 6);
		for (i=0;i<game.gameSize;i++) {
			System.out.println(game.turnOrder[i].identity);
		}
		System.out.println();
		game.turnOrder[game.playerSpot].clout = 100;
		Card card = new Blank("Blank", "blank", CardTeam.GENERAL, Characters.ALL, PlayType.REVEAL, CardAI.NONE);
		game.mainDeck.deck.add(0, card);
		game.turnOrder[game.playerSpot].promptDraw(game);
		game.turnOrder[game.playerSpot].promptDraw(game);
		
		for (i=0; i<3; i++) {
			System.out.println("Day " + i);
			game.startDay();
			game.updatePresence();
			game.updateDay();
		}
		
	}
}
 