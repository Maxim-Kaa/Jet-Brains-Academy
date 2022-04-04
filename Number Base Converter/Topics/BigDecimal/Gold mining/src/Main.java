import java.math.BigDecimal;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal d = new BigDecimal(sc.nextLine());
        BigDecimal b = new BigDecimal(sc.nextLine());
        BigDecimal t = new BigDecimal(sc.nextLine());
        System.out.println(d.add(b).add(t));
        // write your code here
    }
}