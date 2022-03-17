import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int count = 0;
        for (int num:nums) {
            if (num == n) {
                count++;
            }
        }
        System.out.println(count);
        // put your code here
    }
}
