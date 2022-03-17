import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbs = new int[len];
        int count = 0;
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = scanner.nextInt();
            if (i > 1 && numbs[i] == numbs[i - 1] + 1 && numbs[i] == numbs[i - 2] + 2) {
                count++;
            }
        }
        System.out.println(count);
        // put your code here
    }
}