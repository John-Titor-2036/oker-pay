package scripts;

public class Game {
	Player user;
	Player computer;
	Round round;
	Table table;
	public Table getTable(){ return table; }
	public Round getRound(){ return round; }
	public Player getPlayer(){ return user; }	
	public Player getComputer(){ return computer; }
	
	public Game(){
		table = new Table();
		System.out.println("Game");
		user = new Player(this);
		//computer = new Computer(this);
		round = new Round(this);
		round.preFlop();
	}
	

}
