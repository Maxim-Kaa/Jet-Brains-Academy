// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    long ps = System.nanoTime();
    long ps2 = System.nanoTime();
    StringBuilder ps3 = new StringBuilder(String.valueOf(ps) + String.valueOf(ps2));
    System.out.println(ps3);
  }
}
