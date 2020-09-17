package card.anatolecards;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;
import player.Player;

public class Alibi extends Card{
	public Alibi(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	public void turnUpdate() {
		
	}

	public void revealUpdate() {
		
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}

	public void drawUpdate() {
		
	}
}
