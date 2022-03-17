import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        boolean isAlf = true;
        for (int i = 0; i < str.length - 1; i++) {
            int compareResult = str[i].compareTo(str[i + 1]);
            if (compareResult > 0) {
                isAlf = false;
                break;
            }
        }
        System.out.println(isAlf);
    }
}