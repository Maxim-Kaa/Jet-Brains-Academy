import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        final int four = 4;
        double d = Math.pow(b, 2) - four * a * c;
        if (d > 0) {
            double root1 = (-b + Math.sqrt(d)) / (2 * a);
            double root2 = (-b - Math.sqrt(d)) / (2 * a);
            if (root1 < root2) {
                System.out.println(root1 + " " + root2);
            } else {
                System.out.println(root2 + " " + root1);
            }
        } else if (d == 0) {
            double root = (-b + Math.sqrt(d)) / (2 * a);
            System.out.println(root);

        } else  {
            System.out.println("No roots ;-))");
        }
        // put your code here
    }
}