import java.util.Scanner;
import java.lang.Process;
import java.util.InputMismatchException;
import java.io.Console;


class Main {

  public static void main(String[] args) {


	  System.out.println("""

░█████╗░░█████╗░██╗░░░░░██╗██╗░░░██╗░█████╗░██╗░░██╗██╗░██████╗
██╔══██╗██╔══██╗██║░░░░░██║╚██╗░██╔╝██╔══██╗██║░░██║╚█║██╔════╝
███████║███████║██║░░░░░██║░╚████╔╝░███████║███████║░╚╝╚█████╗░
██╔══██║██╔══██║██║░░░░░██║░░╚██╔╝░░██╔══██║██╔══██║░░░░╚═══██╗
██║░░██║██║░░██║███████╗██║░░░██║░░░██║░░██║██║░░██║░░░██████╔╝
╚═╝░░╚═╝╚═╝░░╚═╝╚══════╝╚═╝░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝░░░╚═════╝░

████████╗██╗░█████╗░████████╗░█████╗░░█████╗░████████╗░█████╗░███████╗
╚══██╔══╝██║██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██╔════╝
░░░██║░░░██║██║░░╚═╝░░░██║░░░███████║██║░░╚═╝░░░██║░░░██║░░██║█████╗░░
░░░██║░░░██║██║░░██╗░░░██║░░░██╔══██║██║░░██╗░░░██║░░░██║░░██║██╔══╝░░
░░░██║░░░██║╚█████╔╝░░░██║░░░██║░░██║╚█████╔╝░░░██║░░░╚█████╔╝███████╗
░░░╚═╝░░░╚═╝░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝░╚════╝░░░░╚═╝░░░░╚════╝░╚══════╝""");
  Scanner scanner = new Scanner(System.in);
	System.out.print("Press the 'Enter' key to continue ...");
  	scanner.nextLine();
	  
	  
	  System.out.print("\033[H\033[2J");
	  System.out.flush();
	
	  

    // determine which player is to move
    boolean playerOneTurn = true;

    // creates a board object
    Board board = new Board();

    // Set Name
    System.out.println("Enter the name of player 1: ");
    String playerOneName = scanner.next();

    System.out.println("Enter the name of player 2: ");
    Scanner p2NameScanner = new Scanner(System.in);
    String playerTwoName = p2NameScanner.next();

    // creates the player
    Player playerOne = new Player(playerOneName, 'X');
    Player playerTwo = new Player(playerTwoName, 'O');
    // This will continue to run the game until there is a winner or no empty spaces
    while (board.evaluateBoard() == '-') {

	  			System.out.print("\033[H\033[2J");
	  System.out.flush();

      
      Player currentPlayer;
      board.drawBoard();

      if (playerOneTurn) {
        currentPlayer = playerOne;
      } else {
        currentPlayer = playerTwo;
      }

	  System.out.println(currentPlayer.getName() + " is playing " + currentPlayer.getPlayerLetter());

      boolean valid = false;
      int move = 0;

      do {
        try {
          move = scanner.nextInt();
		  
          valid = true;
        } catch (InputMismatchException e) {
          System.out.println("This is not a valid move");
          scanner.nextLine();
          continue;
        }

        if (!(move > 0 && move < 10) || board.isPlayed(move)) {
          System.out.println("That is an invalid move.");
		  valid = false;
          continue;
        }
      } while (!valid);
      
      
      board.addMove(move);
      currentPlayer.setMove(move);
      board.updateBoard(currentPlayer);

      playerOneTurn = !playerOneTurn;

      switch (board.evaluateBoard()) {
        case 'D':
          System.out.print("The game is a draw!");
          break;
        case '-':
          break;
        default:	  
		  System.out.print("\033[H\033[2J");
	      System.out.flush();
          
		  board.drawBoard();
          System.out.print("The winner is " + currentPlayer.getName());



          
 		  break;
	  }
    }
  }
}