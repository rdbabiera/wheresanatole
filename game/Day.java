package game;

public class Day {
	public boolean classBan;
	public boolean revealTrades;
	public boolean playBan;
	public int playBanDays;
	public boolean tradeBan;
	public int tbDur;
	public boolean drawBan;
	public boolean breachClear;
	public int bCdays;
	public int cbDur;
	
	public Day() {
		this.classBan = false;
		this.revealTrades = false;
		this.playBan = false;
		this.tradeBan = false;
		this.drawBan = false;
		this.breachClear = false;
		this.bCdays = 0;
		this.playBanDays = 0;
		this.tbDur = 0;
		this.cbDur = 0;
	}
	
}
