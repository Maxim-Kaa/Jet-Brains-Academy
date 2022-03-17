import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] star = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[i][j] = ".";
                star[i][i] = "*";
                star[n / 2][j] = "*";
                star[i][n / 2] = "*";
                star[i][n - (i + 1)] = "*";
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(star[i][j] + " ");
            }
            System.out.println();
        }
        // put your code here
    }
}