// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    System.out.println(Direction.valueOf("NORTH"));// put your code here
  }

  enum Direction {
    EAST("E"),
    WEST("W"),
    NORTH("N"),
    SOUTH("S");

    private final String shortCode;

    Direction(String shortCode) {
      this.shortCode = shortCode;
    }

    public String getShortCode() {
      return shortCode;
    }
  }
}
