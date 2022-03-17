import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfCompanies = scanner.nextInt();
        double[] incomes = new double[numOfCompanies];
        double[] taxes = new double[numOfCompanies];
        int count = 0;
        double payment = 0;
        for (int i = 0; i < incomes.length; i++) {
            incomes[i] = scanner.nextInt();
        }
        for (int i = 0; i < taxes.length; i++) {
            taxes[i] = scanner.nextInt();
            double eachPay = incomes[i] * taxes[i];
            if (eachPay >= payment) {
                payment = eachPay;
                count = i + 1;
            }
        }
        System.out.println(count);
        // write your code here
    }
}