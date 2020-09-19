package card;

import player.Characters;
import game.*;
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
	
	public abstract void turnUpdate(Player player, Game game);
	public abstract void revealUpdate(Player player, Game game);
	public abstract void tradeUpdate(Player sender, Player recep);
	public abstract void drawUpdate(Player player, Game game);
	
	public boolean playCheck(Player player) {
		if (this.team == player.team || this.team == CardTeam.GENERAL) {
			return true;
		} else if (this.character == player.idcard.character) {
			return true;
		} else {
			return false;
		}
	}	
	
}
