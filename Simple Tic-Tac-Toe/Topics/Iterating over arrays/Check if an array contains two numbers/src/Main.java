import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbs = new int[len];
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean isNext = false;
        for (int i = 0; i < numbs.length - 1; i++) {
            if (numbs[i] == n && numbs[i + 1] == m || numbs[i] == m && numbs[i + 1] == n) {
                isNext = true;
            }
        }
        System.out.println(isNext);
    }
}