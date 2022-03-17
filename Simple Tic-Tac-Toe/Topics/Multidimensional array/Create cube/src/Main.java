
class ArrayOperations {
    public static int[][][] createCube() {
        final int len = 3;
        int[][][] cube = new int[len][len][len];
        for (int i = 0; i < cube.length; i++) {
            int element = 0;
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    cube[i][j][k] = element;
                    element++;
                }
            }

        }
        // write your code here

        return cube;
    }
}