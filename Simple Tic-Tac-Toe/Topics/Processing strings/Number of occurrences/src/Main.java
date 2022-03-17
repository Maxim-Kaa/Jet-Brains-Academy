import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String str2 = str + "0";
        String subStr = scanner.nextLine();
        String[] newStr = str2.split(subStr);
        int count = 0;
        if (newStr.length > 1) {
            count = newStr.length - 1;
        } else {
            count = newStr.length;
        }
        System.out.println(count);
        // put your code here
    }
}