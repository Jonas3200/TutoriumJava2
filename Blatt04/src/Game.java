
public class Game {

	private Player[][] game;

	Game(Player[][] game) {
		this.game = game;
	}

	/*
	 * Anweisungsblock Code Anderer Code
	 */
	@Override
	public String toString() {
		int totalValue = 0;
		for (Player[] row : game)
			for (Player p : row)
				if (p != null)
					totalValue += p.getValue();
		return "Total value of all players: " + totalValue;
	}

	public String toString2() {
		int totalValue = 0;
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				/* game[i] = row */
				if (game[i][j] != null) {
					/* game[i][j] = p */
					totalValue = totalValue + game[i][j].getValue();
				}
			}
		}
		return "Total value of all players: " + totalValue;
	}

	public static void main(String[] args) {
		Player[][] game = new Player[8][8];
		game[0][1] = new Knight(Level.NOVICE);
		game[2][4] = new Knight(Level.EXPERT);
		game[6][7] = new Wizard(Level.MASTER);
		System.out.println(new Game(game));
	}

	
	
	
	
//	public static void main(String[] args) {
//		
//		int size = 8;
//		
//		Player[][] playersInGame = new Player[size][size];
//		
//		playersInGame[0][1] = new Knight(Level.NOVICE);
//		playersInGame[2][4] = new Knight(Level.EXPERT);
//		playersInGame[6][7] = new Wizard(Level.MASTER);
//		
//		Game game = new Game(playersInGame);
//		System.out.println(game);
//		
//	}	
	
	
	
	
	
	/*
	 * VA 07: Donnerstag, 04.05
	 * VA 08: Donnerstag, 18.05. // 2 Wochen Später 
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
