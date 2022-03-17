import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] date = scanner.nextLine().split("-");
        String[] newDate = new String[date.length];
        System.arraycopy(date, 1, newDate, 0, 2);
        for (int i = 0; i < newDate.length - 1; i++) {
            System.out.print(newDate[i] + "/");
        }
        newDate[newDate.length - 1] = date[0];
        System.out.println(newDate[newDate.length - 1]);
    }
}