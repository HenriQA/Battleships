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
		this.boardSize = 10;
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
	
	public void placeShip(int shipSize, Square[][] player){
		
		//Take reade input to place the ship on the board
		if(player == boardPlayerOne){
			showBoard(false,getBoardPlayerOne());
			System.out.println("Player 1, where would you like to place your ship (of size " + shipSize + ") on the board.");
		}
		else {
			showBoard(false,getBoardPlayerTwo());
			System.out.println("Player 2, where would you like to place your ship (of size " + shipSize + ") on the board.");
		}
		
		Scanner reader = new Scanner(System.in);
		//Get direction
		String direction = "";
		System.out.println("Please enter the direction you will place the ship ('up', 'down', 'left' or 'right').");
		boolean isDirection = false;
	
		while(isDirection == false){
			String localDirection = reader.next();
			if (localDirection.equals("up") || localDirection.equals("down") || localDirection.equals("left") || localDirection.equals("right") || localDirection.equals("diagonal") || localDirection.equals("diagonalflip") || localDirection.equals("knight")){
				direction = localDirection;
				isDirection = true;
				break;
			}
			else{
				isDirection = false;
				System.out.println("This is not a valid direction, please enter another");
			}
		} 
		
		// Get coordinates
		boolean isPossibleCoord = false;
		int a = 0;
		int b = 0;
		while(isPossibleCoord == false){
			String coord;
			System.out.println("Please enter the coordinates you'd like your ship to be placed");
			while(!reader.hasNext("\\d+,\\d+")) {
				System.out.println("Please enter coordinates");
    				reader.next(); 
			}
			coord = reader.next();
			List<String> coordSplit = Arrays.asList(coord.split(","));
			a = Integer.parseInt(coordSplit.get(0));
			b = Integer.parseInt(coordSplit.get(1));			
			
			//Error checking
			if(a<0 || a >player.length || b<0 || b>player.length){
				System.out.println("This coordinate does not lie on the board");
				continue;
			}
			
			else if(direction.equals("up") && b + (shipSize-1) < player.length){
				isPossibleCoord = true;
			}
			else if(direction.equals("down") && b - (shipSize-1) >= 0){
				isPossibleCoord = true;
			}
			else if(direction.equals("right") && a + (shipSize-1) < player.length){
				isPossibleCoord = true;
			}
			else if(direction.equals("left") && a - (shipSize-1) >= 0){
				isPossibleCoord = true;
			}
			else if(direction.equals("diagonal") && a + (shipSize-1) < player.length && b+ (shipSize -1) < player.length){
				isPossibleCoord = true;
			}
			else if(direction.equals("diagonalflip") && a - (shipSize-1) >= 0 && b+ (shipSize -1) < player.length){
				isPossibleCoord = true;
			}
			else if(direction.equals("knight") && a + 2*(shipSize)-1 < player.length && b + (shipSize -1) < player.length){
				isPossibleCoord = true;
			}
			else{
				System.out.println("The ship will not fit if it's placed here, please choose somewhere else");
				continue;
			}
		
			for(int i = 0; i<shipSize; i++){
				if(direction.equals("up") && player[a][b+i].getIsEmpty() == false){
					isPossibleCoord = false;
				}
				else if(direction.equals("right") && player[a+i][b].getIsEmpty() == false){
					isPossibleCoord = false;
				}
				else if(direction.equals("down") && player[a][b-i].getIsEmpty() == false){
					isPossibleCoord = false;
				}
				else if (direction.equals("left") && player[a-i][b].getIsEmpty() == false){
					isPossibleCoord = false;
				}
				else if (direction.equals("diagonal") && player[a+i][b+i].getIsEmpty() == false){
					isPossibleCoord = false;
				}
				else if (direction.equals("diagonalflip") && player[a-i][b+i].getIsEmpty() == false){
					isPossibleCoord = false;
				}
				else if (direction.equals("knight") && player[a+2*i][b+i].getIsEmpty() == false){
					isPossibleCoord = false;
				}
			}
			if(isPossibleCoord == false){
				System.out.println("The ship cannot be placed here, it will overlap with another");
			}
		} 	
		//Place the ship
		
		System.out.println("Your ship has been placed successfully at " + a + "," + b + " pointing " + direction + ".");
		for(int k=0; k<shipSize; k++){
			if(direction.equals("up")){
				player[a][b+k].setIsEmpty(false);
			}
			else if(direction.equals("down")){
				player[a][b-k].setIsEmpty(false);
			}
			else if(direction.equals("right")){
				player[a+k][b].setIsEmpty(false);
			}
			else if(direction.equals("left")){
				player[a-k][b].setIsEmpty(false);
			}
			else if(direction.equals("diagonal")){
				player[a+k][b+k].setIsEmpty(false);
			}
			else if(direction.equals("diagonalflip")){
				player[a-k][b+k].setIsEmpty(false);
			}
			else if(direction.equals("knight")){
				player[a+2*k][b+k].setIsEmpty(false);
			}
		}
	}
	//...
	
	//fire Returns NoShip if square is empty. Returns Hit! if square is not empty. 
	//Returns item hit already if isHit is true
	
	//firing method
	public boolean fire(Square[][] player){
		Scanner reader = new Scanner(System.in);
		String coord;
		while(true){
			while(!reader.hasNext("\\d+,\\d+")) {
				System.out.println("These are not in the valid format");
    				reader.next(); 
			}
			coord = reader.next();
			List<String> coordSplit = Arrays.asList(coord.split(","));
			int a = Integer.parseInt(coordSplit.get(0));
			int b = Integer.parseInt(coordSplit.get(1));
			if((a>player.length-1)||(a<0)||(b>player.length-1)||(b<0)){
				System.out.println("You must fire at the board!");
				continue;
			}
			if(player[a][b].getIsHit() == true){
				System.out.println("You have already fired at this square!");
				return false;
			}
			else if(player[a][b].isEmpty == true){
				System.out.println("This square does not contain a ship.");
				player[a][b].setIsHit(true);
				return false;
			}
			else {
				System.out.println("Ship Hit!!!");
				player[a][b].setIsHit(true);
				return true;
			}
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
	public void showBoard(Boolean isGame, Square[][] player){
        	for (int i=0; i<player.length;i++){
                	System.out.print(" _");
        	}
        	System.out.print("\n");
        	for(int j=player.length-1; j>=0; j--){
			for(int k=0; k<boardSize;k++) {
                        	if (isGame == true)
                                	showSquare(j,k,player);
                        	else
                                	showShips(j,k,player);
                	}
                	System.out.print("|  " + j + "\n");
        	}
		System.out.print(" 0 ");
		for(int j=1; j<player.length;j++){
			if (j < 10)
				System.out.print(j + " ");
			else
				System.out.print(j);
		}
		System.out.print("\n");
			
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
