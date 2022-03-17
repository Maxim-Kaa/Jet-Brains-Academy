
class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        int m = twoDimArray.length;
        int n = twoDimArray[m - 1].length;
        int[][] numbs = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                numbs[i][n - 1 - j] = twoDimArray[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                twoDimArray[i][j] = numbs[i][j];
            }
        }
        // write your code here
    }
}