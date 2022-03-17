import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.asList(scanner.nextLine().split("\\s+"));
        List<String> lst = new ArrayList<>();
        for (int i = 1; i < list.size(); i += 2) {
            lst.add(list.get(i));
        }
        for (int i = lst.size() - 1; i >= 0; i--) {
            System.out.print(lst.get(i) + " ");
        }
    }
}