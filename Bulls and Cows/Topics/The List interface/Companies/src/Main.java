import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>(List.of(scanner.nextLine().split(" ")));
        System.out.println(list);
        // put your code here
    }
}