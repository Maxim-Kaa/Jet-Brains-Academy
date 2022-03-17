import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i).length() > list.get(i - 1).length()) {
                list.set(i - 1, list.get(i));
            } else {
                list.set(i, list.get(i - 1));
            }
        }
        // write your code here
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}