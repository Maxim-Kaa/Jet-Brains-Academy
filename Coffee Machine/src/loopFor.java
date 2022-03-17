import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.nextLine();
        switch (shape): {
            case "triangular":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double p = (a + b + c) / 2;
                System.out.println(Math.sqrt(​p * (p−a) * (p−b) * (p−c)​​​));
                break;
            case "rectangular":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                System.out.println(a * b);
                break;
            case "circle":
                double r = scanner.nextDouble();
                final double pi = 3.14;
                System.out.println(pi * (r * r));

        }
        // start coding here
    }
}
