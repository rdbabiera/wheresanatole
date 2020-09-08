package player;
import card.Card;

public class Player {
	int i;
	/* Set Player Attributes */
	public int position;
	public Hand hand;
	public Card idcard;
	public String identity;
	public String appearance;
	public Team team;
	public int[] presence; /* [At School, Days to be Missed, Is Alive] */
	public int[] statuses; /* Days with Bomb, Clout */
	public Intel[] intel;
	
	/* Constructor */
	public Player() {
		this.hand = new Hand();
		this.presence = new int[3];
		this.presence[0] = 1;
		this.presence[1] = 0;
		this.presence[2] = 1;
		this.statuses = new int[2];
		this.statuses[0] = 0;
		this.statuses[1] = 0;
		this.intel = new Intel[12];
		for (i=0;i<12;i++){
			this.intel[i] = new Intel();
		}
	}

	/* Subroutines */
}