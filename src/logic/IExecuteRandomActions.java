package tp.p1.logic;

public interface IExecuteRandomActions {
	
	static boolean canGenerateRandomOvni(Game game){
		return game.getRandNum().nextInt() <	game.getLevel().getOvniFrequency();
	}
	static boolean canGenerateRandomBomb(Game game){
		return game.getRandNum().nextDouble() <	game.getLevel().getShootFrequency();
	}
}
