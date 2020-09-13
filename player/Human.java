package player;

import card.*;
import java.util.Scanner;

public class Human extends Player{
	boolean isPlayer;
	public Human(Card idcard) {
		super(idcard);
		this.isPlayer = true;
	}

	public void playTurn() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please ");
		
		scan.close();
	}

	public int promptToby(int gameSize) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to guess who Alan is? (y or n)");
		String input = scan.nextLine();
		while ((!input.equals("y")) || (!input.equals("n"))) {
			System.out.println("Not a valid input... Try again.");
			input = scan.nextLine();
		}
		
		if (input.equals("y")) {
			System.out.println("Okay. Where's Alan then? " +
		"(Enter the index where you believe Alan is)");
			int guess = scan.nextInt();
			while ((guess >= gameSize) || (guess < 0)) {
				System.out.println("I don't believe that's a spot at "
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
