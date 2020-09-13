package card.anatolecards;

import card.Card;
import card.CardAI;
import card.CardTeam;
import card.PlayType;
import player.Characters;

public class Alibi extends Card{
	public Alibi(String name, String desc, CardTeam team, Characters character, 
			PlayType type, CardAI cAI) {
		super(name, desc, team, character, type, cAI);
	}
}
