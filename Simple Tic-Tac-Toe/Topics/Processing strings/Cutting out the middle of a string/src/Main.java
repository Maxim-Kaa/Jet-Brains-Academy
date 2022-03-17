import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str1;
        String str2  = str.substring(str.length() / 2 + 1);
        if (str.length() % 2 != 0) {
            str1 = str.substring(0, str.length() / 2);
        } else {
            str1 = str.substring(0, str.length() / 2 - 1);
        }
        System.out.println(str1 + str2);

        // put your code here
    }
}