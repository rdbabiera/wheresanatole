package card;

import game.Game;
import player.Characters;
import player.Player;

public class IdentityCard extends Card{
	
	public IdentityCard(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI){
		super(name, desc, team, character, type, cAI);
	}

	public void drawUpdate(Player player, Game game) {		
	}

	public void turnUpdate(Player player, Game game) {
		
	}

	public void revealUpdate(Player player, Game game) {
		
	}

	public void tradeUpdate(Player sender, Player recep) {
		
	}
}
