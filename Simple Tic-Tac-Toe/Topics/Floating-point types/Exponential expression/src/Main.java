import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        final int pow3 = 3;
        final int pow2 = 2;
        System.out.println(Math.pow(x, pow3) + Math.pow(x, pow2) + x + 1);
        // put your code here
    }
}