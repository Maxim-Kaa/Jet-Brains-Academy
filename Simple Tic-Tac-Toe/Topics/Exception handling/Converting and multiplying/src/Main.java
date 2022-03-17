
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        final int multi = 10;
        while (num > 0) {
            String input = scanner.nextLine();
            try {
                num = Integer.parseInt(input);
                if (num > 0) {
                    num *= multi;
                    System.out.println(num);
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Invalid user input: " + input);
            }

        }
        // put your code here
    }
}