package card;

import player.Characters;

public abstract class Card {
	public String name;
	public String desc;
	public CardTeam team;
	public Characters character;
	public PlayType type;
	public CardAI cAI;
	
	public Card(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI){
		this.name = name;
		this.desc = desc;
		this.team = team;
		this.character = character;
		this.type = type;
		this.cAI = cAI;
	}
}
