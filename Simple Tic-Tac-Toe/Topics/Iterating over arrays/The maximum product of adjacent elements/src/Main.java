import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbs = new int[len];
        numbs[0] = scanner.nextInt();
        int prod = numbs[0] * numbs[1];
        for (int i = 1; i < numbs.length; i++) {
            numbs[i] = scanner.nextInt();
            int prodNext = numbs[i - 1] * numbs[i];
            if (prod < prodNext) {
                prod = prodNext;
            }
        }
        System.out.println(prod);
        // put your code here
    }
}