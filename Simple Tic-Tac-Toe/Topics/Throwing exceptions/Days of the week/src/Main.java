import java.util.*;

public class Main {

    public static String getDayOfWeekName(int number) {
        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int last = daysOfWeek.length;
        return number < 1 || number > last ? String.valueOf(new IllegalArgumentException()) : daysOfWeek[number - 1];

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}