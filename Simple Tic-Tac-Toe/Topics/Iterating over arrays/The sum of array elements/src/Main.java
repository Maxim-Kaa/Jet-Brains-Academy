import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }
        System.out.println(sum);

        // put your code here
    }
}
