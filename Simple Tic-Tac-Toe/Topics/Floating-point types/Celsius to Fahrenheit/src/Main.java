import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(toFahrenheit(scanner.nextDouble()));
        // put your code here
    }

    private static double toFahrenheit(double c) {
        final double mult = 1.8;
        final  double div = 32;
        return c * mult + div;
    }
}