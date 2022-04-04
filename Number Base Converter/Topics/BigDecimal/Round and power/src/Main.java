import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int power = sc.nextInt();
        int scale = sc.nextInt();
        String num = sc.next();
        BigDecimal number = new BigDecimal(num);
        System.out.println(number.setScale(scale, RoundingMode.FLOOR).pow(power));
        // write your code here
    }
}