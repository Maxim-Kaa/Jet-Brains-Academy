import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
                if (matrix[maxI][maxJ] < matrix[i][j]) {
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.println(maxI + " " + maxJ);
    }
}