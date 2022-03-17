import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbs = new int[len];
        for (int i = 0; i < len; i++) {
            numbs[i] = scanner.nextInt();
        }
        int maxSeq = 1;
        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            if (numbs[i] < numbs[i + 1]) {
                count++;
                if (count > maxSeq) {
                    maxSeq = count;
                }
            } else {
                count = 1;
            }
        }
        System.out.println(maxSeq);
        // put your code here
    }
}