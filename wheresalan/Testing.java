package wheresalan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import game.*;

public class Testing {
	public static void main(String[] args) {
		Game game = new Game(1, 1);
		System.out.println(game.aCards.get(0).name);
		game.idCards.displayContents();
	}
}
