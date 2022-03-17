import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] arr = new int[len];
        arr[0] = scanner.nextInt();
        boolean asc = true;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] < arr[i - 1]) {
                asc = false;
                break;
            }
        }
        System.out.println(asc);
        // put your code here
    }
}
