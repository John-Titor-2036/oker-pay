package scripts;

public class Player {

	private Game game;
	private Hand hand;

	private int points;
	
	private boolean folded;

	public Player(Game game) {
		this.game = game;
		newHand();
		points = 10000;
	}

	public boolean isFolded(){ return folded; }
	public int getPoints() {
		return points;
	}
	public void setPoints(int num) { points = num; }

	public void newHand() {
		hand = new Hand(game, game.getTable().getDeck().deal(), game.getTable().getDeck().deal());
	}

	public void fold() {
		hand = null;
		folded = true;
		game.isRoundActive();
	}

	public boolean check() {
		return true;
	}

	public boolean call() {
		if (game.getRound().getBet() > points) {
			game.getRound().setPot(game.getRound().getPot() + points);
			points = 0;
			return false;
		}
		game.getRound().setPot(game.getRound().getPot() + game.getRound().getBet());
		points -= game.getRound().getBet();
		return true;
	}

	public boolean raise(int amt) {
		if (amt >= game.getRound().getBet()) {
			if (amt > points) {
				game.getRound().setPot(points);
				points = 0;
				return false;
			}
			game.getRound().setPot(game.getRound().getPot() + amt);
			game.getRound().setBet(amt);
			points -= amt;
			return true;
		}
		System.out.println("Must raise at least something greater than or equal to " + game.getRound().getBet());		
		return false;
		
	}
	public Hand getHand(){ return hand; }
	public Card[] getCurrentHand() {
		return hand.getHand();
	}
}
