import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal startingAmount = new BigDecimal(sc.nextLine());
        double yearlyPercent = sc.nextInt();
        int years = sc.nextInt();
        final int hundreed = 100;
        BigDecimal a = BigDecimal.valueOf(1 + yearlyPercent / hundreed).pow(years);
        BigDecimal finalAmount = startingAmount.multiply(a);
        System.out.printf("Amount of money in the account: %s", finalAmount.setScale(2, RoundingMode.CEILING));
        // write your code here
    }
}