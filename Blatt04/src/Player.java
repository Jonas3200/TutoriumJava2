
public abstract class Player {

	private int value;
	private Level level;
	
	Player(int value, Level level){
		this.value = value;
		this.level = level;
	}

	public int getValue() {
		return value;
	}

	public Level getLevel() {
		return level;
	}
	
	
}
