import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        System.out.println(expression(a, b, c, d));
        // put your code here
    }

    public static double expression(double a, double b, double c, double d) {
        final double mult1 = 10.5;
        final double mult2 = 4.4;
        final double div = 2.2;
        return a * mult1 + b * mult2 + (c + d) / div;
    }
}