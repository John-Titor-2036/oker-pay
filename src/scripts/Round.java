package scripts;

import java.util.Scanner;

public class Round {
	
	Scanner sc;
	static int roundNumber = 0;
	Game game;
	
	int pot;
	int bet;
	
	public Round(Game game){
		pot = 0;
		bet = 0;
		this.game = game;
		System.out.println("\nRound Numer: " + roundNumber + "\n");
		sc = new Scanner(System.in);
		game.getPlayer().newHand();
		game.takeAnte();
		System.out.println(game.getPlayer().getPoints());
		//game.getComputer().newHand();
	}
	
	public int getPot(){ return pot; }
	public int getBet(){ return bet; }
	
	public void setPot(int amt){ pot = amt; }
	public void setBet(int amt){ bet = amt; }
	
	public void preFlop(){ 
		printHand();
	    requestAction();
	}
	
	private void printHand(){
		System.out.println("Your hand is: ");
	    System.out.println("Number: " + game.getPlayer().getCurrentHand()[0].getNumber() + "\t Type: " + game.getPlayer().getCurrentHand()[0].getSuite()); 
	    System.out.println("Number: " + game.getPlayer().getCurrentHand()[1].getNumber() + "\t Type: " + game.getPlayer().getCurrentHand()[1].getSuite());
	}
	

	public void requestAction(){
		System.out.println("What would you like to do?");
		String action = sc.nextLine();
		action = action.toUpperCase();
		if(action.equals(Actions.CHECK.toString())) game.getPlayer().check();
		if(action.equals(Actions.FOLD.toString())) game.getPlayer().fold();
		if(action.equals(Actions.RAISE.toString())) {
			System.out.println("How much would you like to raise?");
			int raiseAmt = sc.nextInt();
			game.getPlayer().raise(raiseAmt);
		}
		if(action.equals(Actions.CALL.toString())) game.getPlayer().call();

	}
	
}
