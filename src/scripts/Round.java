package scripts;

import java.util.Scanner;

public class Round {
	
	private Scanner sc;
	private static int roundNumber = 0;
	private Game game;
	
	private int pot;
	private int bet;
	
	public Round(Game game){
		pot = 0;
		bet = 0;
		this.game = game;
		roundNumber++;
		setPot(game.getAnte() * game.getPlayers().size());
		setBet(pot);
		sc = new Scanner(System.in);
		game.getPlayer().newHand();
		game.takeAnte();
		//game.getComputer().newHand();
	}
	
	public int getPot(){ return pot; }
	public int getBet(){ return bet; }
	
	public void setPot(int amt){ pot = amt; }
	public void setBet(int amt){ bet = amt; }
	
	public void preFlop(){ 
		printTable();
		requestAction();
	}	
	public void preTurn(){
	    printTable();
		requestAction();
	}	
	public void preRiver(){
	    printTable();
		requestAction();
	}	
	public void postRiver(){
	    printTable();
		requestAction();		
	}
	
	private void printTable(){
		System.out.println("*********************************");
		System.out.println("Round: " + roundNumber + "\n");
		System.out.println("The current pot is: " + pot);
		System.out.println("The max bet is: " + bet);
		
		System.out.println("\n" + "Current cards on the table: ");
		for(int i = 0; i < game.getTable().getCardsOnTable().size(); i++){
			System.out.println("Number: " + game.getTable().getCardsOnTable().get(i).getNumber() + "\t Type: " + game.getTable().getCardsOnTable().get(i).getSuite());
		}
		System.out.println();
		
		System.out.println("Your hand is:");
	    System.out.println("Number: " + game.getPlayer().getCurrentHand()[0].getNumber() + "\t Type: " + game.getPlayer().getCurrentHand()[0].getSuite()); 
	    System.out.println("Number: " + game.getPlayer().getCurrentHand()[1].getNumber() + "\t Type: " + game.getPlayer().getCurrentHand()[1].getSuite());
	    String meter = "[";
	    int strength = game.getPlayer().getHand().initialHandStrength();
	    for(int i = 0; i < 10; i++) {
	    	if(strength > 0) meter += "=";
	    	else meter += " ";
	    	strength--;
	    }
	    meter += "]";
	    System.out.println("\n" + "Hand Strength: " + meter + "\n");
	    System.out.println("You have: " + game.getPlayer().getPoints() + " points");
		System.out.println("*********************************");
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
