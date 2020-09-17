package card;

import player.Characters;
import player.*;

public abstract class Card {
	public String name;
	public String desc;
	public CardTeam team;
	public Characters character;
	public PlayType type;
	public CardAI cAI;
	public boolean canPlay;
	public boolean canTrade;
	public boolean removeTurnEnd;
	
	
	public Card(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI){
		this.name = name;
		this.desc = desc;
		this.team = team;
		this.character = character;
		this.type = type;
		this.cAI = cAI;
	}
	
	public abstract void turnUpdate();
	public abstract void revealUpdate();
	public abstract void tradeUpdate(Player sender, Player recep);
	public abstract void drawUpdate();
}
