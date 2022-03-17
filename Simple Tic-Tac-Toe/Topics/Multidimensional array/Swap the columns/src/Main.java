import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int k = 0; k < n; k++) {
            for (int p = 0; p < m; p++) {
                matrix[k][p] = scanner.nextInt();
            }
        }
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        for (int k = 0; k < matrix.length; k++) {
            int temp = matrix[k][i];
            matrix[k][i] = matrix[k][j];
            matrix[k][j] = temp;
            for (int p = 0; p < matrix[k].length; p++) {

                System.out.print(matrix[k][p] + " ");
            }
            System.out.println();
        }
        // put your code here
    }
}