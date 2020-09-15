package card;

import player.Characters;

public class IdentityCard extends Card{
	
	public IdentityCard(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI){
		super(name, desc, team, character, type, cAI);
	}

	public void update() {
	}

	public void reveal() {
	}

	public void trade() {
	}

	public void drawUpdate() {		
	}
}
