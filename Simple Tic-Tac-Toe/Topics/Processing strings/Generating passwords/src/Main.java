import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        String upperCase1 = "ABCDEFGHIJKLM";
        String upperCase2 = "NOPQRSTUVWXYZ";
        String lowerCase1 = "abcdefghijklm";
        String lowerCase2 = "nopqrstuvwxyz";
        String digits1 = "12345";
        String digits2 = "67890";
        char[] pwd = new char[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            if (i < a) {
                if ((i + 2) % 2 == 0) {
                    pwd[i] = upperCase1.charAt(r.nextInt(upperCase1.length()));
                } else {
                    pwd[i] = upperCase2.charAt(r.nextInt(upperCase2.length()));
                }
            } else if (i < a + b) {
                if ((i + 2) % 2 == 0) {
                    pwd[i] = lowerCase1.charAt(r.nextInt(lowerCase1.length()));
                } else {
                    pwd[i] = lowerCase2.charAt(r.nextInt(lowerCase2.length()));
                }
            } else if (i < a + b + c) {
                if ((i + 2) % 2 == 0) {
                    pwd[i] = digits1.charAt(r.nextInt(digits1.length()));
                } else {
                    pwd[i] = digits2.charAt(r.nextInt(digits2.length()));
                }
            } else {
                String alf = upperCase1 + upperCase2 + lowerCase1 + lowerCase2;
                String digits = digits1 + digits2;
                if ((i + 2) % 2 == 0) {
                    pwd[i] = alf.charAt(r.nextInt(alf.length()));
                } else {
                    pwd[i] = digits.charAt(r.nextInt(digits.length()));
                }
            }
            System.out.print(pwd[i]);
        }
    }
}