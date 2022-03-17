import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] rectangle = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rectangle[i][j] = scanner.nextInt();
            }
            System.out.println();
        }

        int[][] newRectangle = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newRectangle[i][j] = rectangle[n - 1 - j][i];
                System.out.print(newRectangle[i][j] + " ");
            }
            System.out.println();
        }

        // put your code here
    }
}