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
	
	public boolean placeShip(int shipSize, Square[][] player){
		
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
	//Get direction
	System.out.println("Please enter the direction you will place the ship ('up', 'down', 'left' or 'right').");
	boolean isDirection = false;
	
	while(isDirection == false){
		String direction = reader.next();
		if (direction.equals(up) || direction.equals(down) || direction.equals(left) || direction.equals(right)){
			isDirection = true;
		}
		else{
			isDirection = false;
			System.out.println("This is not a valid direction, please enter another");
		}
	} 
		
	// Get coordinates
	boolean isPossibleCoord = false;
	
	while(isPossibleCoord == false){
		//Row
		System.out.println("Please enter the row you will place the ship.");	
		boolean isRow = false;
		while(isRow == false){
			String a = reader.next();
			for (j=0; j<player.length; j++){
				if(a == j){
					isRow = true;
					break;
				}
			}
			if(isRow == false){
				System.out.println("This row does not appear on the board, please enter another.");
			}
		}
		
		//Column
		String b;
		System.out.println("Please enter the column you will place the ship.");
		boolean isColumn = false;
		while(isColumn == false){
			String b = reader.next();
			for (j=0; j<player.length; j++){
				if(b == j){
					isColumn = true;
					break;
				}
			}
			if(isColumn == false){
				System.out.println("This column does not appear on the board, please enter another.");
			}
		}
		
		for(int i = 0; i<shipSize; i++){
			if(direction == up && player[a][b+i].getIsEmpty() == true){
				isPossibleCoord = false;
			}
			else if(direction == right && player[a+i][b].getIsEmpty() == true){
				isPossibleCoord = true;
			}
			else if(direction == down && player[a][b-i].getIsEmpty() == true){
				isPossibleCoord = true;
			}
			else if (direction == left && player[a-i][b].getIsEmpty() == true){
				isPossibleCoord = true;
			}
		}
		if(isPossibleCoord == false){
			System.out.println("The ship cannot be placed here, it will overlap with another");
		}
	} 		
	//Place the ship
	for(int k=0; k<shipSize; k++){
		System.out.println("Your ship has been placed successfully at " + a + "," + b + " pointing " + direction + ".\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		if(direction == up){
			player[a][b+k].setIsEmpty(false);
		}
		else if(direction == down){
			player[a][b-k].setIsEmpty(false);
		}
		else if(direction == right){
			player[a+k][b].setIsEmpty(false);
		}
		else if(direction == left){
			player[a][b+k].setIsEmpty(false);
		}
	}
			
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
