import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        isPalindrome(str);
        // put your code here
    }

    public static void isPalindrome(String str) {
        String str2 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str2 += str.charAt(i);
        }
        if (str.equalsIgnoreCase(str2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}