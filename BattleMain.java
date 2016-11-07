import java.util.Scanner;


public class BattleMain {

	public static void main(String[] args) {
		System.out.println("Weclome to BATTLESHIPS! \n");
		
		
		//Create Console
		BattleConsole console = new BattleConsole("Console v.01");
		
		//*Do Stuff with the console*
		
		//Place Ship 1
		while(console.placeShip(2,console.getBoardPlayerOne()) == false){
			
		console.placeShip(2,console.getBoardPlayerOne());
		}
		while(console.placeShip(2,console.getBoardPlayerTwo()) == false){
				
		console.placeShip(2,console.getBoardPlayerTwo());
		}
		//Place Ship 2
		while(console.placeShip(2,console.getBoardPlayerOne()) == false){
			
		console.placeShip(2,console.getBoardPlayerOne());
		}
		while(console.placeShip(2,console.getBoardPlayerTwo()) == false){
			
		console.placeShip(2,console.getBoardPlayerTwo());
		}
		
		
		
		//Place Ship 3
		while(console.placeShip(3,console.getBoardPlayerOne()) == false){
			
		console.placeShip(3,console.getBoardPlayerOne());
		}
		while(console.placeShip(3,console.getBoardPlayerTwo()) == false){
			
		console.placeShip(3,console.getBoardPlayerTwo());
		}
	
		//Place Ship 4
		while(console.placeShip(3,console.getBoardPlayerOne()) == false){
			
		console.placeShip(3,console.getBoardPlayerOne());
		}
		while(console.placeShip(3,console.getBoardPlayerTwo()) == false){
			
		console.placeShip(3,console.getBoardPlayerTwo());
		}
		
		//Place Ship 5
	
		while(console.placeShip(3,console.getBoardPlayerOne()) == false){
			
		console.placeShip(3,console.getBoardPlayerOne());
		}
		while(console.placeShip(3,console.getBoardPlayerTwo()) == false){
			
		console.placeShip(3,console.getBoardPlayerTwo());
		}
		
		//Place Ship 6

		while(console.placeShip(4,console.getBoardPlayerOne()) == false){
			
		console.placeShip(4,console.getBoardPlayerOne());
		}
		while(console.placeShip(4,console.getBoardPlayerTwo()) == false){
			
		console.placeShip(4,console.getBoardPlayerTwo());
		}
		
		//Place Ship 7
		while(console.placeShip(5,console.getBoardPlayerOne()) == false){
			
		console.placeShip(5,console.getBoardPlayerOne());
		}
		while(console.placeShip(5,console.getBoardPlayerTwo()) == false){
			
		console.placeShip(5,console.getBoardPlayerTwo());
		}
		
		//FIRE
		System.out.println("All ships placed. Now FIRE!!!");
		
		boolean gameOver = false;
		
		while(gameOver == false){
			//Player one shoot
			System.out.println("Player 1 fire!!!");
			console.showBoard(12,true,console.getBoardPlayerTwo());
			console.fire(console.getBoardPlayerTwo());
			if (console.isGameEnd(console.getBoardPlayerTwo()) == true){
				System.out.println("Player 1 wins!");
				gameOver = true;
				break;
			}
			//Player two shoot
			System.out.println("Player 2 fire!!!");
			console.showBoard(12,true,console.getBoardPlayerOne());
			console.fire(console.getBoardPlayerOne());
			if (console.isGameEnd(console.getBoardPlayerOne()) == true){
				System.out.println("Player 2 wins!");
				gameOver = true;	
			}
		}	
		

	}

}
