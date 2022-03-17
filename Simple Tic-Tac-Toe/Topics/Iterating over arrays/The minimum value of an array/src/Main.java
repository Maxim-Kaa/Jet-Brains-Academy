import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            min = arr[0];
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min); // put your code here
    }
}
