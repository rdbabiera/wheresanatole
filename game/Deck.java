package game;
import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import card.*;
import card.anatolecards.*;
import card.maindeck.*;
import card.shop.*;
import player.Characters;

public class Deck {
	ArrayList<Card> deck;
	
	public Deck(String filename) {
		String name;
		String desc;
		CardTeam team;
		Characters character;
		PlayType pType;
		int cost = 0;
		CardAI cAI;
		Card temp = null;
		
		String row;
		BufferedReader csvReader = null;
		this.deck = new ArrayList<Card>();
		if (filename == "discard") {
			return;
		}
		
		try {
			csvReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				name = data[0];
				desc = data[1];
				team = CardTeam.valueOf(data[2]);
				character = Characters.valueOf(data[3]);
				pType = PlayType.valueOf(data[4]);	
				cost = Integer.parseInt(data[5]);
				cAI = CardAI.valueOf(data[6]);
				
				if (filename == "maindeck.csv") {
					switch (name) {
						case "Ace":
							temp = new Ace(name, desc, team, character, pType, cAI);
							break;
						case "Backstab":
							temp = new Backstab(name, desc, team, character, pType, cAI);
							break;
						case "Ban Hammer":
							temp = new BanHammer(name, desc, team, character, pType, cAI);
							break;
						case "Bash Tax":
							temp = new BashTax(name, desc, team, character, pType, cAI);
							break;
						case "Blank":
							temp = new Blank(name, desc, team, character, pType, cAI);
							break;
						case "Breach and Clear":
							temp = new BreachAndClear(name, desc, team, character, pType, cAI);
							break;
						case "Cancel Culture":
							temp = new CancelCulture(name, desc, team, character, pType, cAI);
							break;
						case "Clout":
							temp = new Clout(name, desc, team, character, pType, cAI);
							break;
						case "Cough Card":
							temp = new CoughCard(name, desc, team, character, pType, cAI);
							break;
						case "Defuse Kit":
							temp = new DefusalKit(name, desc, team, character, pType, cAI);
							break;
						case "Drop Me T4?":
							temp = new DropT4(name, desc, team, character, pType, cAI);
							break;
						case "Early Dismissal":
							temp = new EarlyDismissal(name, desc, team, character, pType, cAI);
							break;
						case "Escape":
							temp = new Escape(name, desc, team, character, pType, cAI);
							break;
						case "Ghost Sauce":
							temp = new GhostSauce(name, desc, team, character, pType, cAI);
							break;
						case "IT'S ME":
							temp = new ItsMe(name, desc, team, character, pType, cAI);
							break;
						case "Kenneth I'm Sorry":
							temp = new KennethCard(name, desc, team, character, pType, cAI);
							break;
						case "La Montagne":
							temp = new LaMontagne(name, desc, team, character, pType, cAI);
							break;
						case "Pink Slip":
							temp = new PinkSlip(name, desc, team, character, pType, cAI);
							break;
						case "Radar Jammer":
							temp = new RadarJammer(name, desc, team, character, pType, cAI);
							break;
						case "Reported":
							temp = new Reported(name, desc, team, character, pType, cAI);
							break;
						case "Snack Bomb":
							temp = new Snackbomb(name, desc, team, character, pType, cAI);
							break;
						case "Spasm":
							temp = new Spasm(name, desc, team, character, pType, cAI);
							break;
						case "Stink Bomb":
							temp = new StinkBomb(name, desc, team, character, pType, cAI);
							break;
						case "Suspension":
							temp = new Suspension(name, desc, team, character, pType, cAI);
							break;
						case "Walled Off":
							temp = new WalledOff(name, desc, team, character, pType, cAI);
							break;
						case "Weekend at Bernie's":
							temp = new WeekendBernies(name, desc, team, character, pType, cAI);
							break;
						case "Yapstone":
							temp = new Yapstone(name, desc, team, character, pType, cAI);
							break;				
					}
				} else if (filename == "alancards.csv") {
					switch (name) {
						case "Alibi":
							temp = new Alibi(name, desc, team, character, pType, cAI);
							break;
						case "History Paper":
							temp = new HistoryPaper(name, desc, team, character, pType, cAI);
							break;
					}
				} else if (filename == "shopcards.csv") {
					switch (name) {
						case "Overheard in the Study Room":
							temp = new Overheard(name, desc, team, character, pType, cost, cAI);
							break;
						case "Ark Family Evolved":
							temp = new ArkEvolved(name, desc, team, character, pType, cost, cAI);
							break;
						case "World Fair":
							temp = new WorldFair(name, desc, team, character, pType, cost, cAI);
							break;
						case "Toby the Uber Driver":
							temp = new Uber(name, desc, team, character, pType, cost, cAI);
							break;
						case "Exit Strategy":
							temp = new ExitStrat(name, desc, team, character, pType, cost, cAI);
							break;
						case "Left Steam Open":
							temp = new LeftSteamOpen(name, desc, team, character, pType, cost, cAI);
							break;
					}
				} else if (filename == "identitycards.csv") {
					temp = new IdentityCard(name, desc, team, character, pType, cAI);
				}
				
				deck.add(temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void shuffle() {
		Collections.shuffle(this.deck);
	}
	public void addCard(Card card) {
		this.deck.add(card);
		this.shuffle();
	}
	public void displayContents() {
		int i;
		System.out.println("Printing Deck Contents...");
		for (i=0;i<deck.size();i++) {
			Card temp = this.deck.get(i);
			System.out.printf("Card #%d:\nName: %s\n", i, temp.name);
			System.out.printf("\tDescription: %s\n\tTeam: %s\n",temp.desc, 
					temp.team.name());
			System.out.printf("\tCharacter: %s\n\tPlayType: %s\n",
					temp.character.name(), temp.type.name());
		}
		System.out.println("End of Deck!");
	}
	
	public Card removeCard(int index) {
		Card card = this.deck.remove(index);
		return card;
	}
}
