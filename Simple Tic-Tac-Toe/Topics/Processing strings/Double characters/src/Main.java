import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] chars = str.split("");
        for (String ch:chars) {
            System.out.print(ch + ch);
        }

        // put your code here
    }
}