import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double p = scanner.nextDouble();
        double h = scanner.nextDouble();
        final double g = 9.8;
        System.out.println(p * g * h);
        // put your code here
    }
}