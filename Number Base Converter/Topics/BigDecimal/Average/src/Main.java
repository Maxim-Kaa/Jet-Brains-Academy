import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal a = new BigDecimal(sc.next()).add(new BigDecimal(sc.next())).add(new BigDecimal(sc.next()));
        System.out.println(a.divide(new BigDecimal("3"), 0, RoundingMode.DOWN));
        // write your code here
    }
}