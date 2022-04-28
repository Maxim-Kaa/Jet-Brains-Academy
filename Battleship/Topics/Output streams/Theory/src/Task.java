// You can experiment here, it won’t be checked

import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.Arrays;

public class Task {
  public static void main(String[] args) throws IOException {
    String[] words = {"This", " ", "is", " ", "a", " ", "test"};
    String w = words[0] + words[1] + words[2] + words[3] + words[4] + words[5] + words[6];
    char[] chars = w.toCharArray();


    System.out.println(Arrays.toString(chars));
    // put your code here
  }
}
