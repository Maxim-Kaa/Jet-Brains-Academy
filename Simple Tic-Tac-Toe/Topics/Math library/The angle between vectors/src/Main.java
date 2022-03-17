import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double aX = scanner.nextInt();
        double aY = scanner.nextInt();
        double bX = scanner.nextInt();
        double bY = scanner.nextInt();
        double aLength = Math.sqrt(Math.pow(aX, 2) + Math.pow(aY, 2));
        double bLength = Math.sqrt(Math.pow(bX, 2) + Math.pow(bY, 2));
        double angle = Math.toDegrees(Math.acos((aX * bX + aY * bY) / (aLength * bLength)));
        System.out.println(angle);
        // put your code here
    }
}