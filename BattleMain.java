import java.util.Scanner;


public class BattleMain {

	public static void main(String[] args) {
		System.out.println("Weclome to BATTLESHIPS! \n");
		
		
		//Create Console
		BattleConsole console = new BattleConsole("Console v.01");
		
		//*Do Stuff with the console*
		Scanner reader = new Scanner(System.in);
		//Place Ship 1	
		
		console.placeShip(2,console.getBoardPlayerOne());
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n Type any character to continue (and press enter)");
		String wait = scanner.next();
		console.placeShip(2,console.getBoardPlayerTwo());
		//Place Ship 2
		console.placeShip(2,console.getBoardPlayerOne());
		console.placeShip(2,console.getBoardPlayerTwo());
		//Place Ship 3
		console.placeShip(3,console.getBoardPlayerOne());
		console.placeShip(3,console.getBoardPlayerTwo());
		//Place Ship 4
		console.placeShip(3,console.getBoardPlayerOne());
		console.placeShip(3,console.getBoardPlayerTwo());
		//Place Ship 5
		console.placeShip(3,console.getBoardPlayerOne());
		console.placeShip(3,console.getBoardPlayerTwo());
		//Place Ship 6
		console.placeShip(4,console.getBoardPlayerOne());
		console.placeShip(4,console.getBoardPlayerTwo());
		//Place Ship 7
		console.placeShip(5,console.getBoardPlayerOne());
		console.placeShip(5,console.getBoardPlayerTwo());
		
		//FIRE
		System.out.println("All ships placed. Now FIRE!!!");
		
		boolean gameOver = false;
		
		while(gameOver == false){
			//Player one shoot
			System.out.println("Player 1 fire!!!");
			console.showBoard(10,true,console.getBoardPlayerTwo());
			console.fire(console.getBoardPlayerTwo());
			if (console.isGameEnd(console.getBoardPlayerTwo()) == true){
				System.out.println("Player 1 wins!");
				gameOver = true;
				break;
			}
			//Player two shoot
			System.out.println("Player 2 fire!!!");
			console.showBoard(10,true,console.getBoardPlayerOne());
			console.fire(console.getBoardPlayerOne());
			if (console.isGameEnd(console.getBoardPlayerOne()) == true){
				System.out.println("Player 2 wins!");
				gameOver = true;	
			}
		}	
		

	}

}
