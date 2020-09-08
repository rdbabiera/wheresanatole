package game;

import java.io.File;
import java.util.ArrayList;

import card.*;
import player.*;

public class Game {
	int i;
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
		int gameSize = 2 + sizeAlan + sizeTony;
				
		this.alanCards = new Deck("alancards.csv");
		this.discardPile = new Deck("discard");
		this.drawnSpecials = new Deck("discard");
		this.idCards = new Deck("identitycards.csv");
		this.mainDeck = new Deck("maindeck.csv");
		this.shop = new Deck("shopcards.csv");
		this.day = new Day();
		this.nextDay = new Day();
		this.turnOrder = new Player[gameSize];
		
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
		
		
		
		
	}
	
	public void updateDay() {
		this.day = this.nextDay;
		this.nextDay = new Day();
	}
}  
