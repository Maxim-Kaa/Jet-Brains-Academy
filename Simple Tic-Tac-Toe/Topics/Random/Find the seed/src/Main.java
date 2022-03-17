import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int minSeed = a;
        int maxRandom = k;
        int localMax = k - 1;
        for (int i = a; i < b; ++i) {
            Random random = new Random(i);
            if (localMax < maxRandom) {
                maxRandom = localMax;
                if (i > 0) {
                    minSeed = i - 1;
                } else {
                    minSeed = i;
                }
            }
            int minLocalMax = 0;
            for (int j = 0; j < n; j++) {

                int r = random.nextInt(k);
                if (r > minLocalMax) {
                    localMax = r;
                    minLocalMax = r;
                }
            }
        }
        System.out.println(minSeed);
        System.out.println(maxRandom);

        // write your code here
    }
}