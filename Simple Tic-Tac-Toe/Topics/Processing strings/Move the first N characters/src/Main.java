import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        StringBuilder str;
        if (n < s.length()) {
            str = new StringBuilder(s.substring(n));
            for (int i = 0; i < n; i++) {
                str.append(s.charAt(i));
            }
        } else {
            str = new StringBuilder(s);
        }
        System.out.println(str);
    }
}