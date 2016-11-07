import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class BattleConsole {

	//Attributes
	String consoleName;
	Square[][] boardPlayerOne;
	Square[][] boardPlayerTwo;
	int boardSize;
	
	//Constructor
	public BattleConsole(String consoleName) {
		
		this.consoleName = consoleName;
		this.boardSize = 12;
		this.boardPlayerOne = new Square[boardSize][boardSize];
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				boardPlayerOne[i][j] = new Square();
			}
		}
		this.boardPlayerTwo = new Square[boardSize][boardSize];
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				boardPlayerTwo[i][j] = new Square();
			}
		}
	}
	
	
	//Methods
	
	//Place Method
	
	public boolean placeShip(int shipSize,  Square[][] player){
		if(player == boardPlayerOne){
			System.out.println("Player 1, please enter the direction you want your ship to be placed (up) or (right).");
		}
		else {
			System.out.println("Player 2, please enter the direction you want your ship to be placed (up) or (right)");
		}
		Scanner reader1 = new Scanner(System.in);
		String direction = reader1.next();
		//reader1.close();
		switch(direction){
	
			case ("up"):
				placeShipUp(shipSize, player);
				reader1.nextLine();
				return true;
			case ("right"):
				placeShipRight(shipSize, player);
				reader1.nextLine();
				return true;
			//case ("left"):
			//case ("down"):
			default:
				System.out.println("Not a valid direction, please enter up or right");
				reader1.nextLine();
				return false;
				
		}
		
		
	}
	
	//Methods for placing ships
	//Up
	public boolean placeShipUp(int shipSize, Square[][] player){
		
		//Take reade input to place the ship on the board
		if(player == boardPlayerOne){
			showBoard(player.length,false,getBoardPlayerOne());
			System.out.println("Player 1, where would you like to place your ship (of size " + shipSize + ") on the board.");
		}
		else {
			showBoard(player.length,false,getBoardPlayerTwo());
			System.out.println("Player 2, where would you like to place your ship (of size " + shipSize + ") on the board.");
		}
		
		Scanner reader = new Scanner(System.in);
		
		String coord = reader.next();
		List<String> coordSplit = Arrays.asList(coord.split(","));
		int a = Integer.parseInt(coordSplit.get(0));
		int b = Integer.parseInt(coordSplit.get(1));
		
		
		//Check that the ship can be placed legally
		boolean available = true;
		
		if((a>)||(a<0)||(b>player.length-1)||(b<0)){
			System.out.println("You must place the ship on the board!");
			return available;
		}
		
		
		if(player.length < (b+shipSize)){
			System.out.println("The ship cannot be placed here, please try somewhere else.");
			return available;
		}
		
		
		for(int i = 0; i<shipSize; i++){
			if(player[a][b+i].getIsEmpty() == false){
				available = false;
			}
		}
		
		
		for(int k = 0; k<shipSize; k++){
			if(available == false){
				System.out.println("This ship can't be placed here, it would overlap with another ship.");
				return available;
			}
			else {
				player[a][b+k].setIsEmpty(false);
				
			}
		}
		if (available == true){
			System.out.println("Ship placed successfully at ("+ a + "," + b + ") pointing up.\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		return available;
	}
	
	//Right
public boolean placeShipRight(int shipSize, Square[][] player){
		
		//Take read input to place the ship on the board
		if(player == boardPlayerOne){
			System.out.println("Player 1, where would you like to place your ship (of size " + shipSize + ") on the board.");
		}
		else {
			System.out.println("Player 2, where would you like to place your ship (of size " + shipSize + ") on the board.");
		}
		
		Scanner reader = new Scanner(System.in);
		
		String coord = reader.next();
		List<String> coordSplit = Arrays.asList(coord.split(","));
		int a = Integer.parseInt(coordSplit.get(0));
		int b = Integer.parseInt(coordSplit.get(1));
		
		//reader.close();
		//Check that the ship can be placed legally
		boolean available = true;
		
		if((a>player.length-1)||(a<0)||(b>player.length-1)||(b<0)){
			System.out.println("You must place the ship on the board!");
			return available;
		}
		
		
		if(player.length < (a+shipSize)){
			System.out.println("The ship cannot be placed here, please try somewhere else.");
			return available;
		}
		
		
		for(int i = 0; i<shipSize; i++){
			if(player[a+i][b].getIsEmpty() == false){
				available = false;
			}
		}
		
		
		for(int k = 0; k<shipSize; k++){
			if(available == false){
				System.out.println("This ship can't be placed here, it would overlap with another ship.");
				return available;
			}
			else {
				player[a+k][b].setIsEmpty(false);
				
			}
		}
		if (available == true){
			System.out.println("Ship placed successfully at ("+ a + "," + b + ") pointing right.\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		return available;
	}
	//...
	
	//fire Returns NoShip if square is empty. Returns Hit! if square is not empty. 
	//Returns item hit already if isHit is true
	
	//firing method
	public void fire(Square[][] player){
		Scanner reader = new Scanner(System.in);
		
		String coord = reader.next();
		List<String> coordSplit = Arrays.asList(coord.split(","));
		int a = Integer.parseInt(coordSplit.get(0));
		int b = Integer.parseInt(coordSplit.get(1));
		
		if((a>player.length-1)||(a<0)||(b>player.length-1)||(b<0)){
			System.out.println("You must fire at the board!");
			return;
		}
		if(player[a][b].getIsHit() == true){
			System.out.println("You have already fired at this square!");
		}
		else if(player[a][b].isEmpty == true){
			System.out.println("This square does not contain a ship.");
			player[a][b].setIsHit(true);
		}
		else {
			System.out.println("Ship Hit!!!");
			player[a][b].setIsHit(true);
		}
		
	}
	
	//Method for checking if all ships are hit!
	
	public boolean isGameEnd(Square[][] player){
		for(int i = 0; i<boardSize; i++){
			for(int j = 0; j<boardSize; j++){
				if((player[i][j].getIsEmpty() == false) && (player[i][j].getIsHit() == false)){
					return false;
				}
				
			}
		}
			return true;
	}

	//Getters and Setters
	public Square[][] getBoardPlayerOne() {
		return boardPlayerOne;
	}


	public Square[][] getBoardPlayerTwo() {
		return boardPlayerTwo;
	}

	//Methods for printing board
	public void showBoard(int boardSize, Boolean isGame, Square[][] player){
        	for (int i=0; i<boardSize;i++){
                	System.out.print(" _");
        	}
        	System.out.print("\n");
        	for(int j=boardSize-1; j>=0; j--){
			for(int k=0; k<boardSize;k++) {
                        	if (isGame == true)
                                	showSquare(j,k,player);
                        	else
                                	showShips(j,k,player);
                	}
                	System.out.print("|  " + j + "\n");
        	}
		System.out.println(" 0 1 2 3 4 5 6 7 8 9 1011");
	}
	public void showSquare(int c,int r, Square[][] playera){
        	if(playera[r][c].getIsHit()==true && playera[r][c].getIsEmpty()==true){
                	System.out.print("|O");
		}
        	else if(playera[r][c].getIsHit()==true && playera[r][c].getIsEmpty()==false){
                	System.out.print("|X");
        	}
		else
                	System.out.print("|_");
	}
	public void showShips(int c, int r, Square[][] playerb){
        	if(playerb[r][c].getIsEmpty()==false)
                	System.out.print("|S");
        	else
                	System.out.print("|_");
	}
}
