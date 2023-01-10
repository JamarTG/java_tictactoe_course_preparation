public class Player {

  private String name;
  private char playerLetter;
  private int score;
  private int move;

  public Player(String name, char playerLetter) {
    this.playerLetter = playerLetter;
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public int getScore() {
    return this.score;
  }

  public void setMove(int move) {
    this.move = move;
  }

  public int getMove() {
    return this.move;
  }

  public char getPlayerLetter() {
    return this.playerLetter;
  }
}
