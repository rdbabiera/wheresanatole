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
	public Deck alanCards;
	public Deck discardPile;
	public Deck drawnSpecials;
	public Deck idCards;
	public Deck mainDeck;
	public Deck shop;
	
	public ArrayList<Card> aCards;
	public ArrayList<Card> tCards;
	
	public Player[] turnOrder;
	
	public Game(int sizeAlan, int sizeTony) {
		Random rand = new Random();
		gameSize = sizeAlan + sizeTony;
		int teamRand, charRand;
		
		/* Initialize Decks and Board */
		this.alanCards = new Deck("alancards.csv");
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
			if (this.idCards.deck.get(i).team == CardTeam.ALAN) {
				this.aCards.add(this.idCards.removeCard(i));
			} else if (this.idCards.deck.get(i).team == CardTeam.TONY) {
				this.tCards.add(this.idCards.removeCard(i));
			}
		}
				
		teamRand = rand.nextInt(2);
		Human player = null;
		int playerSpot;
		if (teamRand == 0) {
			charRand = rand.nextInt(aCards.size());
			player = new Human(aCards.remove(charRand));
			sizeAlan--;
		} else if (teamRand == 1) {
			charRand = rand.nextInt(tCards.size());
			player = new Human(tCards.remove(charRand));
			sizeTony--;
		}
		
		System.out.println("Player is: "+ player.identity);
		
		if (player.identity != "Tony") {
			this.turnOrder[0] = new TonyAI(tCards.remove(0));
			sizeTony--;
			playerSpot = rand.nextInt((gameSize - 1)) + 1;
		} else {
			playerSpot = 0;
			this.turnOrder[0] = player;
		}
		
		int alanSpot;
		
		Player alan = null;
		if (player.identity != "Alan") {
			alanSpot = rand.nextInt((gameSize - 1)) + 1;
			while (alanSpot == playerSpot) {
				alanSpot = rand.nextInt((gameSize - 1)) + 1;
			}
			alan = new AI(aCards.remove(0));
			sizeAlan--;
		} else {
			alanSpot = playerSpot;
		}
		
		for (i=1; i<gameSize; i++) {
			System.out.println(playerSpot);
			if ((i == playerSpot)){
				this.turnOrder[i] = player;
			} else if ((i == alanSpot) && (alanSpot != playerSpot)) {
				this.turnOrder[i] = alan;
			} else {
				teamRand = rand.nextInt(2);
				if ((teamRand == 0) && (sizeAlan > 0)) {
					charRand = rand.nextInt(aCards.size());
					this.turnOrder[i] = new AI(aCards.remove(charRand));
					sizeAlan--;
				} else if ((teamRand == 0) && (sizeAlan == 0)){
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
					sizeAlan--;
				}				
			}
		}
		/* End of Initialization */
		

	}
	
	public void updateDay() {
		this.day = this.nextDay;
		this.nextDay = new Day();
	}
}  
