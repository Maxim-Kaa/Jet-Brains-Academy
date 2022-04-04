package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class MagicNumber {
    private static int base;
    private static int sourceBase;

    public static  void processingRequest(String input) {
        try{
            Scanner sc = new Scanner(System.in);
            String[] bases = input.split("\\s");
            sourceBase = Integer.parseInt(bases[0]);
            base = Integer.parseInt(bases[1]);
            while (true) {
                System.out.printf("Enter number in base %d to convert to base %d (To go back type /back) ", sourceBase, base);
                String in = sc.nextLine();
                if ("/back".equals(in)) {
                    break;
                } else if (isFractional(in)) {
                    String[] numbers = in.split("\\.");
                    BigDecimal num = new BigDecimal(new BigInteger(numbers[0], sourceBase));
                    BigDecimal fractionDec = new BigDecimal(fracToDec(numbers[1]));
                    if (base == 10) {
                        System.out.println("Conversion result: " + num.add(fractionDec).setScale(5, RoundingMode.HALF_DOWN) + "\n");
                    } else {
                        String number = num.toBigInteger().toString(base);
                        System.out.println("Conversion result: " + number + "." + decToTarget(fractionDec) + "\n");
                    }

                } else {
                    BigInteger num = new BigInteger(in, sourceBase);
                    if (base == 10) {
                        System.out.println("Conversion result: " + num + "\n");
                    } else {
                        System.out.println("Conversion result: " + num.toString(base) + "\n");
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid input");
        }

    }

    public static void CreateRequest() throws IOException, NumberFormatException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String input = reader.readLine();
            if ("/exit".equals(input)) {
                reader.close();
                break;
            }
            else {
                processingRequest(input);
            }
        }
    }

    private static boolean isFractional(String in) {
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }

    private static String fracToDec(String in) {
        double sum = 0;
        for (int i = 0; i < in.length(); i++) {
            int div = (int) Math.pow(sourceBase, i + 1);
            int b = Character.getNumericValue(in.charAt(i));
            double a = (double) b / div;
            sum += a;
        }
        return String.valueOf(sum);
    }

    private static String decToTarget(BigDecimal a) {
        a = a.multiply(new BigDecimal((int) Math.pow(base, 6)));
        BigDecimal[] res = a.divideAndRemainder(new BigDecimal(base));
        StringBuilder fr = new StringBuilder("");
        int count = 0;
        while (count < 5) {
            a = res[0];
            res = a.divideAndRemainder(new BigDecimal(base));
            fr.append(res[1].toBigInteger().toString(base));
            count++;
        }
        return String.valueOf(fr.reverse());
    }
}

