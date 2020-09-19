package card.anatolecards;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.*;
import player.*;

public class HistoryPaper extends Card{
	public HistoryPaper(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate(Player player, Game game) {
		
	}
}