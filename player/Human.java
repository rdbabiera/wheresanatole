package player;

import card.*;
import game.*;

import java.util.Scanner;

public class Human extends Player{
	boolean isPlayer;
	public Human(Card idcard, int gameSize) {
		super(idcard, gameSize);
		this.isPlayer = true;
	}
	
	public void displayIntel() {
		int i;
		for (i=0; i<this.intel.length; i++) {
			System.out.println("Table Seat #" + i + ": ");
			this.intel[i].printIntel();
		}
	}

	public void playTurn(Game game) {
		Scanner scan = new Scanner(System.in);
		promptDraw(game);
		int action;
		System.out.println("Please choose an action for your turn. "
				+ "Alternatively, you can display any information you have.");
		System.out.println("1. Reveal Card.");
		System.out.println("2. Trade Card.");
		System.out.println("3. Display Hand");
		System.out.println("4. Display Intel");
		System.out.println("5. Display Shop");
		System.out.println("6. Buy Card");
		action = scan.nextInt();
		
		while (action > 2) {
			while ((action < 1) || (action > 6)) {
				System.out.println("Invalid action... Try again.");
				action = scan.nextInt();
			}
		}
		if (action == 1) {
			
		}
		
		scan.close();
	}

	public int promptToby(int gameSize) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to guess who Anatole is? (y or n)");
		String input = scan.nextLine();
		while ((!input.equals("y")) || (!input.equals("n"))) {
			System.out.println("Not a valid input... Try again.");
			input = scan.nextLine();
		}
		
		if (input.equals("y")) {
			System.out.println("Okay. Where's Anatole then? " +
		"(Enter the index where you believe Anatole is)");
			int guess = scan.nextInt();
			while ((guess >= gameSize) || (guess < 1)) {
				System.out.println("I don't believe that's a valid guess at "
						+ "the table... Try again.");
				guess = scan.nextInt();
			}
			scan.close();
			return guess;
		}
		scan.close();
		return -1;
	}

	public void promptDraw(Game game) {
		Scanner scan = new Scanner(System.in);
		String input = "m";
		if (game.drawnSpecials.returnSize() > 0) {
			System.out.println("Would you like to draw from the Main deck "
					+ "or the Special Deck? (m or s)");
			input = scan.nextLine();
			while ((!input.equals("m")) || (!input.equals("s"))) {
				System.out.println("Not a valid input... Try again.");
				input = scan.nextLine();
			}
		}
		if (input.equals("s")) {
			this.drawCard(game.drawnSpecials);
		} else if (input.equals("m")) {
			this.drawCard(game.mainDeck);
		}
		scan.close();
	}

	public void promptReveal(Game game) {
		
	}
	
	public void promptTrade(Game game) {
		
	}

	public void promptBuy(Game game) {
		
	}
	
	

	
	
}
