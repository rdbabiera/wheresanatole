package player;

import card.*;
import card.shop.*;
import game.*;

import java.util.Scanner;

public class Human extends Player{
	public Scanner scan;
	
	public Human(Card idcard, int gameSize) {
		super(idcard, gameSize);
		this.isHuman = true;
		this.scan = new Scanner(System.in);
	}
	
	public void displayIntel() {
		int i;
		for (i=0; i<this.intel.length; i++) {
			System.out.println("Table Seat #" + i + ": ");
			this.intel[i].printIntel();
		}
	}
	
	public void displayOptions() {
		System.out.println("Please choose an action for your turn. "
				+ "Alternatively, you can display any information you have.");
		System.out.println("1. Reveal Card.");
		System.out.println("2. Trade Card.");
		System.out.println("3. Do Nothing");
		System.out.println("4. Display Hand");
		System.out.println("5. Display Intel");
		System.out.println("6. Display Shop");
		System.out.println("7. Buy Card");
		System.out.println();
	}
	
	public void playTurn(Game game) {
		if (!this.isPresent) {
			return;
		}

		int action;
		displayOptions();
		
		action = this.scan.nextInt();
		
		boolean endTurn = false;
		
		while (!endTurn) {
			while ((action < 1) || (action > 7)) {
				System.out.println("Invalid action... Try again.");
				action = this.scan.nextInt();
			}
			switch (action) {
			case 1:
				if (this.hand.canPlay()){
					this.promptReveal(game);
					endTurn = true;
					break;
				}
				else {
					System.out.println("This action cannot be performed...");
					break;
				}
			case 2:
				if (this.hand.canTrade()){
					this.promptTrade(game);
					endTurn = true;
					break;
				}
				else {
					System.out.println("This action cannot be performed...");
					break;
				}
			case 3:
				endTurn = true;
				break;
			case 4:
				this.hand.displayHand();
				break;
			case 5:
				this.displayIntel();
				break;
			case 6:
				game.shop.displayContents();
				break;
			case 7:
				this.promptBuy(game);
				break;
			}
			if (!endTurn) {
				System.out.println("What's Next?");
				displayOptions();
				action = this.scan.nextInt();
			}
		}
	}

	public int promptToby(int gameSize) {
		if (!this.isPresent) {
			return -1;
		}
		char input = ' ';
		System.out.println("Would you like to guess who Anatole is? (y or n)");
		boolean validInput = false;
		while (!validInput) {
			input = this.scan.next().charAt(0);
			if (input == 'y' || input == 'n') {
				validInput = true;
				break;
			}
			System.out.println("Not a valid input... Try again.");
		}
		
		if (input == 'y') {
			System.out.println("Okay. Where's Anatole then? " +
		"(Enter the index where you believe Anatole is)");
			int guess = this.scan.nextInt();
			while ((guess >= gameSize) || (guess < 1)) {
				System.out.println("I don't believe that's a valid guess at "
						+ "the table... Try again.");
				guess = this.scan.nextInt();
			}
			return guess;
		}
		return -1;
	}

	public void promptDraw(Game game) {
		if (!this.isPresent) {
			return;
		}
		char input = 'm';
		if (game.drawnSpecials.returnSize() > 0) {
			System.out.println("Would you like to draw from the Main deck "
					+ "or the Special Deck? (m or s)");
			input = this.scan.next().charAt(0);
			while (input != 'm' && input != 's') {
				System.out.println("Not a valid input... Try again.");
				input = this.scan.next().charAt(0);
			}
		}
		if (input == 's') {
			this.drawCard(game.drawnSpecials, game);
		} else if (input == 'm') {
			this.drawCard(game.mainDeck, game);
		}
	}

	public void promptReveal(Game game) {
		int selection;
		System.out.println("Which card would you like to reveal?");
		selection = this.scan.nextInt();
		boolean validMove = false;
		while (!validMove) {
			while ((selection < 0) || (selection >= this.hand.size())) {
				System.out.println("This index doesn't exist... Try again.");
				selection = this.scan.nextInt();
			}
			if (this.hand.get(selection).canPlay) {
				Card card = this.hand.remove(selection);
				card.revealUpdate(this, game);
				this.discardCard(card, game.discardPile);
				validMove = true;
			} else {
				System.out.println("This card cannot be played... Try again.");
				selection = this.scan.nextInt();
			}
		}
	}
	
	public void promptTrade(Game game) {
		Card card;
		int selection;
		int pSelect;
		Player target = null;
		System.out.println("Which card would you like to trade?");
		selection = this.scan.nextInt();
		boolean validMove = false;
		while (!validMove) {
			while ((selection < 0) || (selection >= this.hand.size())) {
				System.out.println("This index doesn't exist... Try again.");
				selection = this.scan.nextInt();
			}
			if (this.hand.get(selection).canTrade) {
				card = this.hand.hand.remove(selection);
				System.out.println("Who would you like to give this to?");
				this.displayIntel();
				pSelect = this.scan.nextInt();
				while ((pSelect < 0) || (pSelect >= game.gameSize) || (pSelect == this.position)) {
					System.out.println("Not a valid target... Try again.");
					pSelect = this.scan.nextInt();
				}
				target = game.turnOrder[pSelect];
				if (game.day.revealTrades) {
					System.out.println("This trade has been snuffed out!");
					System.out.println("Player " + this.position + " has traded the card "
							+ card.name + " to Player " + pSelect);
					System.out.println();
				}
				this.tradeCard(card, target);
				validMove = true;
				
			} else {
				System.out.println("This card cannot be traded... Try again.");
				selection = this.scan.nextInt();
			}
		}
	}

	public void promptBuy(Game game) {
		int shopSize = game.shop.returnSize();
		if (shopSize < 1) {
			System.out.println("There are no cards in the shop left...");
			return;
		}
		boolean endTurn = false;
		System.out.println("Here are the current shop cards:");
		game.shop.displayContents();
		System.out.printf("You have %d clout\n", this.clout);
		System.out.println("What would you like to buy? Type the size of "
				+ "the shop to exit");
		int choice = this.scan.nextInt();
		while (!endTurn) {
			while ((choice < 0) && (choice > shopSize)) {
				System.out.println("Invalid action... Try again.");
				choice = this.scan.nextInt();
			}
			if (choice == shopSize) {
				endTurn = true;
			} else {
				if (((ShopCard) game.shop.get(choice)).cost > this.clout) {
					System.out.println("You do not have enough clout to "
							+ "buy this. Pick again.");
					choice = this.scan.nextInt();
				} else {
					this.buyCard(game.shop, choice, game);
					endTurn = true;
				}
			}
		}
	}

	public boolean promptEscape() {
		System.out.println("Would you like to skip school for the rest of "
				+ "the day? (y or n)");
		char response;
		boolean res = false;
		response = this.scan.next().charAt(0);
		while (response != 'n' && response != 'y') {
			System.out.println("Not a valid input... Try again");
			response = this.scan.next().charAt(0);
		}
		if (response == 'n') {
			res = false;
		} else if (response == 'y') {
			res = true;
		}
		return res;
	}
	
}
