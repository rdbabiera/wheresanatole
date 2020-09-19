package card.maindeck;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import game.Game;
import player.Characters;
import player.Player;

public class EarlyDismissal extends Card{
	public EarlyDismissal(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}

	@Override
	public void turnUpdate(Player player, Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void revealUpdate(Player player, Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tradeUpdate(Player sender, Player recep) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawUpdate(Player player, Game game) {
		// TODO Auto-generated method stub
		
	}
}