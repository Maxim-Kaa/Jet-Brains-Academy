import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ticket = scanner.nextLine();
        char[] chars = ticket.toCharArray();
        int[] numbs = new int[chars.length];
        int firstHalf = 0;
        int secondHalf = 0;
        for (int i = 0; i < numbs.length; i++) {
            numbs[i] = Character.getNumericValue(chars[i]);
            if (i < numbs.length / 2) {
                firstHalf += numbs[i];
            } else {
                secondHalf += numbs[i];
            }
        }
        if (firstHalf == secondHalf) {
            System.out.println("Lucky");
        } else {
            System.out.println("Regular");
        }
        // put your code here
    }
}