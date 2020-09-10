package wheresalan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import game.*;

public class Testing {
	public static void main(String[] args) {
		
		/*
		System.out.println(game.aCards.get(0).name);
		game.idCards.displayContents();
		*/
		int i, j;
		
		for (j=0; j<10;j++) {
			Game game = new Game(6, 6);
			for (i=0;i<game.gameSize;i++) {
				System.out.println(game.turnOrder[i].identity);
			}
		}
	}
}
