package tp.p1.logic;

public enum Level {
	EASY(4, 2, 0.20, 3, 0.50, 1),
	HARD(8, 2, 0.30, 2, 0.20, 2),
	INSANE(8, 4, 0.50, 1, 0.10, 2);		
	private int numRegularAliens;
	private int numDestroyerAliens;
	private int numCyclesToMoveOneCell;
	private double ovniFrequency;
	private double shootFrequency;
	
	
	private Level(int numRegularAliens,int numDestroyerAliens,
			double shootFrequency,int numCyclesToMoveOneCell,
			double ovniFrequency,int numRowsOfRegularAliens)
	{
		this.numRegularAliens = numRegularAliens;
		this.numDestroyerAliens = numDestroyerAliens;
		this.shootFrequency = shootFrequency;
		this.numCyclesToMoveOneCell = numCyclesToMoveOneCell;
		this.ovniFrequency = ovniFrequency;
	}
	
	public int getNumRegularAliens() {
		return numRegularAliens;
	}
	public int getNumDestroyerAliens() {
		return numDestroyerAliens;
	}
	public Double getShootFrequency() {
		return shootFrequency;
	}
	public int getNumCyclesToMoveOneCell() {
		return numCyclesToMoveOneCell;
	}
	public Double getOvniFrequency() {
		return ovniFrequency;
	}
	
	public int getNumDestroyerAliensPerRow() {
		return getNumDestroyerAliens();
	}
	public static Level fromParam(String param) {
		for (Level level : Level.values())
			if (level.name().equalsIgnoreCase(param)) return level;
		return EASY;
	}
	public Double getTurnExplodeFreq(){
		return 0.05;
	}	
	
}