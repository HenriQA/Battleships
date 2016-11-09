import java.util.Scanner;


public class BattleMain {

	public static void main(String[] args) {
		System.out.println("Weclome to BATTLESHIPS! \n");
		
		
		//Create Console
		BattleConsole console = new BattleConsole("Console v.01");
		
		//*Do Stuff with the console*
		Scanner reader = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100; i++){
			sb.append("\n");
		}
		String gap = sb.toString();
		sb.append("Ship Placed Successfully! \n\n Type any character to continue (and press enter)");
		String message = sb.toString();
		//Place Ship 1	
		
		console.placeShip(2,console.getBoardPlayerOne());
		System.out.println(message);
		String wait = reader.next();
		console.placeShip(2,console.getBoardPlayerTwo());
		System.out.println(message);
		wait = reader.next();
		//Place Ship 2
	/**	console.placeShip(2,console.getBoardPlayerOne());
		System.out.println(message);
		wait = reader.next();
		console.placeShip(2,console.getBoardPlayerTwo());
		System.out.println(message);
		wait = reader.next();
		//Place Ship 3
		console.placeShip(3,console.getBoardPlayerOne());
		System.out.println(message);
		wait = reader.next();
		console.placeShip(3,console.getBoardPlayerTwo());
		System.out.println(message);
		wait = reader.next();
		//Place Ship 4
		console.placeShip(3,console.getBoardPlayerOne());
		System.out.println(message);
		wait = reader.next();
		console.placeShip(3,console.getBoardPlayerTwo());
		System.out.println(message);
		wait = reader.next();
		//Place Ship 5
		console.placeShip(3,console.getBoardPlayerOne());
		System.out.println(message);
		wait = reader.next();
		console.placeShip(3,console.getBoardPlayerTwo());
		System.out.println(message);
		wait = reader.next();
		//Place Ship 6
		console.placeShip(4,console.getBoardPlayerOne());
		System.out.println(message);
		wait = reader.next();
		console.placeShip(4,console.getBoardPlayerTwo());
		System.out.println(message);
		wait = reader.next();
		//Place Ship 7
		console.placeShip(5,console.getBoardPlayerOne());
		System.out.println(message);
		wait = reader.next();
		console.placeShip(5,console.getBoardPlayerTwo());
		System.out.println(gap);
		
	**/	//FIRE
		System.out.println("All ships placed. Now FIRE!!!");
		
		boolean gameOver = false;
		
		over:
		while(gameOver == false){
			//Player one shoot
			System.out.println("Player 1 fire!!!");
			console.showBoard(true,console.getBoardPlayerTwo());
			int cont;
			if (console.fire(console.getBoardPlayerTwo()) == true){
				cont = 5;
			}
			else
				cont = 3;
			//if (console.isGameEnd(console.getBoardPlayerTwo()) == true){
				//System.out.println("Player 1 wins!");
				//wait = reader.next();
				//console.showBoard(false, console.getBoardPlayerOne());
				//gameOver = true;
				//break over;
			//}
			//Player two shoot
			System.out.println("Player 2 fire!!!");
			console.showBoard(true,console.getBoardPlayerOne());
			console.fire(console.getBoardPlayerOne());
			if (console.isGameEnd(console.getBoardPlayerOne()) == true){
				System.out.println("Player 2 wins!");
				wait = reader.next();
				console.showBoard(false, console.getBoardPlayerOne());
				gameOver = true;	
			}
		}	
		

	}

}
