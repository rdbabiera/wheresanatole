package wheresanatole;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import game.*;

public class Testing {
	public static void main(String[] args) {
		
		int i;
		
		Game game = new Game(1, 1);
		for (i=0;i<game.gameSize;i++) {
			System.out.println(game.turnOrder[i].identity);
		}
		game.startDay();
	}
}
