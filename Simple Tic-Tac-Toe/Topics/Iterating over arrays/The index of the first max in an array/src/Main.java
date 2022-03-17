import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbs = new int[len];
        int maxInd = 0;
        int maxNumb = 0;
        for (int i = 0; i < len; i++) {
            numbs[i] = scanner.nextInt();
            if (numbs[i] > maxNumb) {
                maxNumb = numbs[i];
                maxInd = i;
            }
        }
        System.out.println(maxInd);
        // put your code here
    }
}