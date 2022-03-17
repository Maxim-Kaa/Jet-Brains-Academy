class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        /*for (int i = 0; i < twoDimArray.length; i += twoDimArray.length - 1) {
            int j =0;
            if (twoDimArray[i].length > 1) {
                for ( j = 0; j < twoDimArray[i].length; j += twoDimArray[i].length - 1) {
                    System.out.print(twoDimArray[i][j] + " ");
                }
            } else {
                System.out.print(twoDimArray[i][j] + " " + twoDimArray[i][j]);
            }
            System.out.println();
        }*/
        // Failed test #7 of 8. Wrong answer
        int i = twoDimArray.length;
        System.out.println(twoDimArray[0][0] + " " + twoDimArray[0][twoDimArray[0].length - 1]);
        System.out.println(twoDimArray[i - 1][0] + " " + twoDimArray[i - 1][twoDimArray[i - 1].length - 1]);
        // write your code here
    }
}