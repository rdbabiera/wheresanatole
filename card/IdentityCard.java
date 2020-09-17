package card;

import player.Characters;
import player.Player;

public class IdentityCard extends Card{
	
	public IdentityCard(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI){
		super(name, desc, team, character, type, cAI);
	}

	public void drawUpdate() {		
	}

	public void turnUpdate() {
		
	}

	public void revealUpdate() {
		
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}
}
