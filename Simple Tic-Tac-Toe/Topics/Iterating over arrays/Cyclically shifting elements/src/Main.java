import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] a = new int[len];
        for (int i = 1; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        a[0] = scanner.nextInt();
        for (int num:a) {
            System.out.print(num + " ");
        }

        // put your code here
    }
}
