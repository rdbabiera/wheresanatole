package game;

import java.io.File;
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
	
	public Game(int sizeAnatole, int sizeTony) {
		Random rand = new Random();
		gameSize = sizeAnatole + sizeTony;
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
				player = new Human(aCards.remove(0));
				sizeAnatole--;
			} else {
				charRand = rand.nextInt(aCards.size());
				player = new Human(aCards.remove(charRand));
				sizeAnatole--;
			}
		} else if (teamRand == 1) {
			if (sizeTony == 1) {
				player = new Human(tCards.remove(0));
				sizeTony--;
			} else {
				charRand = rand.nextInt(tCards.size());
				player = new Human(tCards.remove(charRand));
				sizeTony--;
			}
		}
		
		if (!player.identity.equals("Tony")) {
			this.turnOrder[0] = new TobyAI(tCards.remove(0));
			sizeTony--;
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
		
		if (!player.identity.equals("anatole")) {
			if (gameSize == 2) {
				anatoleSpot = 1;
			} else {
				anatoleSpot = rand.nextInt((gameSize - 1)) + 1;
				while (anatoleSpot == this.playerSpot) {
					anatoleSpot = rand.nextInt((gameSize - 1)) + 1;
				}
			}		
			anatole = new AI(aCards.remove(0));
			sizeAnatole--;
		} else {
			anatoleSpot = this.playerSpot;
		}
		
		for (i=1; i<gameSize; i++) {
			if ((i == this.playerSpot)){
				this.turnOrder[i] = player;
			} else if ((i == anatoleSpot) && (anatoleSpot != this.playerSpot)) {
				this.turnOrder[i] = anatole;
			} else {
				teamRand = rand.nextInt(2);
				if ((teamRand == 0) && (sizeAnatole > 0)) {
					charRand = rand.nextInt(aCards.size());
					this.turnOrder[i] = new AI(aCards.remove(charRand));
					sizeAnatole--;
				} else if ((teamRand == 0) && (sizeAnatole == 0)){
					charRand = rand.nextInt(tCards.size());
					this.turnOrder[i] = new AI(tCards.remove(charRand));
					sizeTony--;
				} else if ((teamRand == 1) && (sizeTony > 0)) {
					charRand = rand.nextInt(tCards.size());
					this.turnOrder[i] = new AI(tCards.remove(charRand));
					sizeTony--;
				} else if ((teamRand == 1) && (sizeTony == 0)) {
					charRand = rand.nextInt(aCards.size());
					this.turnOrder[i] = new AI(aCards.remove(charRand));
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
		this.publicIntel[0].character = Characters.TONY;
		for (i=0; i<gameSize; i++) {
			this.turnOrder[i].intel[0].character = Characters.TONY;
			this.turnOrder[i].intel[0].team = CardTeam.TOBY;
			if (i != 0) {
				this.turnOrder[i].intel[i].character = this.turnOrder[i].idcard.character;
				this.turnOrder[i].intel[i].team = this.turnOrder[i].team;
			}
		}	
		
	}
	
	public void startDay() {
		int currentTurn = 0;
		while (currentTurn < gameSize) {
			/* Method to prompt */
			currentTurn++;
		}
	}
	
	public void updateDay() {
		this.day = this.nextDay;
		this.nextDay = new Day();
	}
}  
