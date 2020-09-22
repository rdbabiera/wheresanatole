package game;

import java.util.ArrayList;
import java.util.Random;

import card.*;
import player.*;

public class Game {
	int i;
	public int gameSize;
	public Day day;
	public Day nextDay;
	public Intel[] publicIntel;
	public Deck anatoleCards;
	public Deck discardPile;
	public Deck drawnSpecials;
	public Deck idCards;
	public Deck mainDeck;
	public Deck shop;
	public int playerSpot;
	
	public ArrayList<Card> aCards;
	public ArrayList<Card> tCards;
	
	public Player[] turnOrder;
	public boolean aWin, tWin;
	
	public Game(int sizeAnatole, int sizeToby) {
		Random rand = new Random();
		gameSize = sizeAnatole + sizeToby;
		int teamRand, charRand;
		
		/* Initialize Decks and Board */
		this.anatoleCards = new Deck("anatolecards.csv");
		this.discardPile = new Deck("discard");
		this.drawnSpecials = new Deck("discard");
		this.idCards = new Deck("identitycards.csv");
		this.mainDeck = new Deck("maindeck.csv");
		this.shop = new Deck("shopcards.csv");
		this.day = new Day();
		this.nextDay = new Day();
		this.turnOrder = new Player[gameSize];
		this.aWin = false;
		this.tWin = false;
		
		this.mainDeck.shuffle();
		
		/* Initialize Turn Order and Players */
		int i;	
		this.aCards = new ArrayList<Card>();
		this.tCards = new ArrayList<Card>();
		for (i=11; i>=0; i--) {
			if (this.idCards.deck.get(i).team == CardTeam.ANATOLE) {
				this.aCards.add(this.idCards.removeCard(i));
			} else if (this.idCards.deck.get(i).team == CardTeam.TOBY) {
				this.tCards.add(this.idCards.removeCard(i));
			}
		}
				
		teamRand = rand.nextInt(2);
		Human player = null;
		if (teamRand == 0) {
			if (sizeAnatole == 1) {
				player = new Human(aCards.remove(0), gameSize);
				sizeAnatole--;
			} else {
				charRand = rand.nextInt(aCards.size());
				player = new Human(aCards.remove(charRand), gameSize);
				sizeAnatole--;
			}
		} else if (teamRand == 1) {
			if (sizeToby == 1) {
				player = new Human(tCards.remove(0), gameSize);
				sizeToby--;
			} else {
				charRand = rand.nextInt(tCards.size());
				player = new Human(tCards.remove(charRand), gameSize);
				sizeToby--;
			}
		}
		System.out.println("Player is: " + player.identity);
		
		if (!player.identity.equals("Toby")) {
			this.turnOrder[0] = new TobyAI(tCards.remove(0), gameSize, 0);
			sizeToby--;
			if (gameSize == 2) {
				this.playerSpot = 1;
			} else {
				this.playerSpot = rand.nextInt((gameSize - 1)) + 1;
			}
		} else {
			this.playerSpot = 0;
			this.turnOrder[0] = player;
		}
		
		int anatoleSpot;
		Player anatole = null;
		
		if (!player.identity.equals("Anatole")) {
			if (gameSize == 2) {
				anatoleSpot = 1;
			} else {
				anatoleSpot = rand.nextInt((gameSize - 1)) + 1;
				while (anatoleSpot == this.playerSpot) {
					anatoleSpot = rand.nextInt((gameSize - 1)) + 1;
				}
			}		
			anatole = new AI(aCards.remove(0), gameSize, anatoleSpot);
			sizeAnatole--;
		} else {
			anatoleSpot = this.playerSpot;
		}
		
		player.position = this.playerSpot;
		
		for (i=1; i<gameSize; i++) {
			if ((i == this.playerSpot)){
				this.turnOrder[i] = player;
			} else if ((i == anatoleSpot) && (anatoleSpot != this.playerSpot)) {
				this.turnOrder[i] = anatole;
			} else {
				teamRand = rand.nextInt(2);
				if ((teamRand == 0) && (sizeAnatole > 0)) {
					charRand = rand.nextInt(aCards.size());
					this.turnOrder[i] = new AI(aCards.remove(charRand), gameSize, i);
					sizeAnatole--;
				} else if ((teamRand == 0) && (sizeAnatole == 0)){
					charRand = rand.nextInt(tCards.size());
					this.turnOrder[i] = new AI(tCards.remove(charRand), gameSize, i);
					sizeToby--;
				} else if ((teamRand == 1) && (sizeToby > 0)) {
					charRand = rand.nextInt(tCards.size());
					this.turnOrder[i] = new AI(tCards.remove(charRand), gameSize, i);
					sizeToby--;
				} else if ((teamRand == 1) && (sizeToby == 0)) {
					charRand = rand.nextInt(aCards.size());
					this.turnOrder[i] = new AI(aCards.remove(charRand), gameSize, i);
					sizeAnatole--;
				}				
			}
		}
		
		/* Intel Initialization */
		this.publicIntel = new Intel[gameSize];
		for (i=0; i<gameSize; i++) {
			this.publicIntel[i] = new Intel();
		}
		this.publicIntel[0].team = CardTeam.TOBY;
		this.publicIntel[0].character = Characters.TOBY;
		for (i=0; i<gameSize; i++) {
			this.turnOrder[i].intel[0].character = Characters.TOBY;
			this.turnOrder[i].intel[0].team = CardTeam.TOBY;
			if (i != 0) {
				this.turnOrder[i].intel[i].character = this.turnOrder[i].idcard.character;
				this.turnOrder[i].intel[i].team = this.turnOrder[i].team;
			}
		}	
		
	}
	
	public void startDay() {
		int currentTurn = 0;
		int guess;
		int victoryCheck;
		while (currentTurn < gameSize) {
			turnOrder[currentTurn].promptDraw(this);
			if (currentTurn == 0) {
				guess = this.turnOrder[0].promptToby(gameSize);
				if (guess != -1) {
					victoryCheck = anatoleCheck(this.turnOrder, guess);
					if (victoryCheck == 1) {
						this.aWin = true;
						return;
					} else if (victoryCheck == 2) {
						this.tWin = true;
						return;
					}
				}
			}
			turnOrder[currentTurn].playTurn(this);
			currentTurn++;
		}
	}
	
	public int anatoleCheck(Player[] turnOrder, int guess) {
		if (!turnOrder[guess].identity.equals("Anatole")) {
			addAlibi(this.mainDeck, this.anatoleCards);
			return 0;
		} else {
			if (turnOrder[guess].hand.checkFor("History Paper") == 1) {
				System.out.println("Toby: 'Where's my history paper, Anatole?'");
				System.out.println("Anatole: 'Right here.'");
				System.out.println("Team Anatole has claimed victory!");
				return 1;
			} else if (turnOrder[guess].hand.checkFor("Alibi") == 1) {
				turnOrder[guess].hand.discardSpecific("Alibi");
				System.out.println("Anatole has been found... But! He has "
						+ "an alibi on hand. The history paper will now be "
						+ "added to the top 3 cards of the deck. Pray that one of his"
						+ " friends has it...");
				addPaper(this.mainDeck, this.anatoleCards);
				return 0;
			}
			System.out.println("Anatole has been caught red handed without"
					+ " protection. Team Toby wins!");
			return 2;
		}
	}
	
	public void addAlibi(Deck main, Deck anatole) {
		if (anatole.deck.size() == 0) {
			return;
		} else if (anatole.deck.size() == 1) {
			System.out.println("This is Toby's third incorrect guess! The "
					+ "History Paper has been added to the top of the deck!");
		} else {
			System.out.println("An alibi has been added to the top of the "
					+ "deck!");
		}
		main.deck.add(anatole.removeCard(0));
	}
	
	public void addPaper(Deck main, Deck anatole) {
		if (anatole.deck.size() < 1) {
			return;
		}
		Random rand = new Random();
		int index = rand.nextInt(3);
		while ((index >= main.deck.size()) && (index > 0)) {
			index--;
		}
		main.deck.add(index, anatole.removeCard((anatole.deck.size() - 1)));
	}

	public void updateDay() {
		this.day = this.nextDay;
		this.nextDay = new Day();
	}
	
	public void updatePresence() {
		int i;
		for (i=0; i<this.gameSize; i++) {
			
		}
	}
	
	public void updatePublicInfo() {
		int i, j;
		for (i=0; i<this.gameSize; i++) {
			for (j=0; j<this.gameSize; j++) {
				if (this.turnOrder[i].intel[j].character == Characters.UNKNOWN) {
					this.turnOrder[i].intel[j].character = this.publicIntel[j].character;
				}
				if (this.turnOrder[i].intel[j].team == CardTeam.UNKNOWN) {
					this.turnOrder[i].intel[j].team = this.publicIntel[j].team;
				}
			}
		}
	}
	
}  
