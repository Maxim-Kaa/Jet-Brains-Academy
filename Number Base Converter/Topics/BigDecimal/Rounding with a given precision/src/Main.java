import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal num = new BigDecimal(sc.nextLine());
        int scale = sc.nextInt();
        System.out.println(num.setScale(scale, RoundingMode.HALF_DOWN));
        // write your code here
    }   
}