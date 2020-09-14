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

	public void playTurn(Game game) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please ");
		
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

	
	
}
