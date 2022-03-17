import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.println(equationX(a, b, c));
        // put your code here
    }

    public static double equationX(double a, double b, double c) {
        return (c - b) / a;
    }
}