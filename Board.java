import java.util.ArrayList;

public class Board {

  private final char[][] board = {
      {
          '-',
          '-',
          '-'
      },
      {
          '-',
          '-',
          '-'
      },
      {
          '-',
          '-',
          '-'
      }
  };

  ArrayList<Integer> moveArray = new ArrayList<>();

  public void addMove(final int move) {
    moveArray.add(move);
  }

  public boolean isPlayed(int move) {
    return this.moveArray.contains(move);
  }






	
  public char[][] getBoard() {
    return this.board;
  }

  public void drawBoard() {
    System.out.println("------------");
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (col == 0) {
          System.out.print("| ");
        };
        System.out.print(board[row][col] + " | ");

      }
      System.out.println("\n------------"); 
    }
  }
  //

  public void updateBoard(final Player player) {

    switch (player.getMove()) {
      case 1:
        this.board[0][0] = player.getPlayerLetter();
        break;
      case 2:
        this.board[0][1] = player.getPlayerLetter();
        break;
      case 3:
        this.board[0][2] = player.getPlayerLetter();
        break;
      case 4:
        this.board[1][0] = player.getPlayerLetter();
        break;
      case 5:
        this.board[1][1] = player.getPlayerLetter();
        break;
      case 6:
        this.board[1][2] = player.getPlayerLetter();
        break;
      case 7:
        this.board[2][0] = player.getPlayerLetter();
        break;
      case 8:
        this.board[2][1] = player.getPlayerLetter();
        break;
      case 9:
        this.board[2][2] = player.getPlayerLetter();
        break;
    }

  }

  public char evaluateBoard() {
    // Check rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0] != '-' && (board[i][0] == board[i][1] && board[i][1] == board[i][2])) {
        return board[i][0];
      }
    }

    // Check columns
    for (int i = 0; i < 3; i++) {
      if (board[0][i] != '-' && (board[0][i] == board[1][i] && board[1][i] == board[2][i])) {
        return board[0][i];
      }
    }

    // Check first diagonals
    if (board[0][0] != '-' && (board[0][0] == board[1][1] && board[1][1] == board[2][2])) {
      return board[0][0];
    }
    // Check for the second diagonal
    if (board[0][2] != '-' && (board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
      return board[0][2];
    }

    // check if the game is not drawn
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == '-') {
          return '-';
        }
      }
    }

    return 'D';
  }

  public boolean isBoardFull(final char[][] board) {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i][j] == ' ') {
          return false;
        }
      }
    }
    return true;
  }

}