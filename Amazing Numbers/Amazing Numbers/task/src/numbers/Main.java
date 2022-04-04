
package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!\n");
        Number.showRequests();
        Number.processingRequest();
    }
}

class Number {
    private static final int seven = 7;
    private static String userInput;
    private static final String[] properties = {"even", "odd", "buzz", "duck", "palindromic", "gapful", "spy", "square", "sunny",
            "jumping"};
    private static ArrayList<String> arguments;
    private static final ArrayList<Long> nums = new ArrayList<>(1);
    private static long num;
    private static int length;
    private static String p1;
    private static String p2;
    private static String p3;
    private static String p4;
    private static String p5;
    private static final String available = "Available properties: [EVEN, ODD, BUZZ," +
            " DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING]";

    private static boolean isBuzz(String input) {
        return isEndsWithSeven(input) || isDivideBySeven(input);
    }
    
    private static boolean isEndsWithSeven(String number) {
        return number.charAt(number.length() - 1) == '7';
    }

    private static boolean isDivideBySeven(String input) {
        return Long.parseLong(input) % seven == 0;
    }

    private static boolean isEven(String input) {
        return Long.parseLong(input) % 2 == 0;
    }

    private static boolean isDuck(String number) {
        if (number.length() > 1) {
            for (int i = 1; i <number.length(); i++) {
                if (number.charAt(i) == '0') {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPalindromic(String input) {
        StringBuilder number = new StringBuilder(input);
        String numb = String.valueOf(number.reverse());
        return input.equals(numb);
    }

    private static boolean isGapful(String number) {
        long number2 = Long.parseLong(number.charAt(0) + String.valueOf(number.charAt(number.length() - 1)));
        return number.length() > 2 && Long.parseLong(number) % number2 == 0;
    }

    private static boolean isSpy(String input) {
        long sum = 0;
        long mult = 1;
        ArrayList<Integer> numbs = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            numbs.add(Integer.parseInt(String.valueOf(input.charAt(i))));
        }
        for (long el:numbs) {
            sum += el;
            mult *= el;
        }
        return sum == mult;
    }

    private static boolean isSquare(String input) {
        long num = Long.parseLong(input);
        double a = Math.ceil(Math.sqrt(num));
        long b = (long) Math.pow(a, 2);
        return num == b;
    }

    private static boolean isSunny(String input) {
        long num = Long.parseLong(input);
        return isSquare(String.valueOf(num + 1));
    }

    private static boolean isJumping(String in) {
        int count = 0;
        for (int i = 0; i < in.length() - 1; i++) {
            int a = Integer.parseInt(String.valueOf(in.charAt(i)));
            int b = Integer.parseInt(String.valueOf(in.charAt(i + 1)));
            if (a + 1 == b || a - 1 == b) {
                count++;
            }
        }
        return count == in.length() - 1;
    }

    private static boolean isHappy(String input) {

    }

    private static void ShowFullProperties(String number) {
        StringBuilder newNumber = new StringBuilder(number);
        newNumber.reverse();
        for (int i = 0; i < newNumber.length(); i += 4) {
                    newNumber.insert(i, ",");
            }
        newNumber.reverse().deleteCharAt(newNumber.length() - 1);
        System.out.println("Properties of " + newNumber + "\n" +
                "        buzz: " + isBuzz(number) + "\n" +
                "        duck: " + isDuck(number) + "\n" +
                " palindromic: " + isPalindromic(number) + "\n" +
                "      gapful: " + isGapful(number) + "\n" +
                "      square: " + isSquare(number) + "\n" +
                "         spy: " + isSpy(number) + "\n" +
                "       sunny: " + isSunny(number) + "\n" +
                "        even: " + isEven(number) + "\n" +
                "     jumping: " + isJumping(number) + "\n" +
                "         odd: " + !isEven(number) + "\n");
    }

    private static void showEssentials(Long el) {
        String number = String.valueOf(el);
        String buzz = isBuzz(number) ? "buzz, " : "";
        String even = isEven(number) ? "even, " : "";
        String odd = !isEven(number) ? "odd, " : "";
        String duck = isDuck(number) ? "duck, " : "";
        String gap = isGapful(number) ? "gapful, " : "";
        String pal = isPalindromic(number) ? "palindromic" : "";
        String spy = isSpy(number) ? "spy, " : "";
        String square = isSquare(number) ? "square, " : "";
        String sun = isSunny(number) ? "sunny, " : "";
        String jump = isJumping(number) ? "jumping, " : "";
        System.out.println(el + " is " + buzz + even + odd + duck + spy + square + jump + sun + gap + pal);
    }

    public static void showRequests() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }

    private static void processingTwoArgs() {
        if (length > 0) {
            long[] nums  = new long[length];
            nums[0] = num;
            for (int i = 1; i < length; i++) {
                nums[i] = nums[i - 1] + 1;
            }
            for (long el:nums) {
                showEssentials(el);
            }
            System.out.println();
        } else {
            System.out.println("The second parameter should be a natural number.\n");
        }

    }

    private static void processingThreeArgs() {
        if (length > 0) {
            if (hasProp(p1)){
                fillPropArray();
            } else {
                absentPropMessage();
            }
            presentArray();
        } else {
            System.out.println("The second parameter should be a natural number.\n");
        }
    }

    private static boolean isExistsProp() {
        int amountArgs = arguments.size();
        switch (amountArgs){
            case 4:
                return hasProp(p1) && hasProp(p2);
            case 5:
                return hasProp(p1) && hasProp(p2) && hasProp(p3);
            case 6:
                return hasProp(p1) && hasProp(p2) && hasProp(p3) && hasProp(p4);
            case 7:
                return hasProp(p1) && hasProp(p2) && hasProp(p3) && hasProp(p4) && hasProp(p5);
        }
        return false;
    }

    private static void processingArgs() {
        if (length > 0) {
            if (isExistsProp() && !isExclusiveProp()){
                fillPropArray();
            } else if (!isExistsProp()) {
                absentPropMessage();
            } else {
                System.out.println("The request contains mutually exclusive properties: " +
                        isExclusivePropMessage() + "\n" +
                        "There are no numbers with these properties.");
            }
            presentArray();

        } else {
            System.out.println("The second parameter should be a natural number.\n");
        }
    }

    private static void presentArray(){
        for (long el:nums) {
            showEssentials(el);
        }
        nums.clear();
        System.out.println();
    }

    public static void processingRequest() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            num = 0;
            length = 0;
            try {
                System.out.print("Enter a request:");
                userInput = scanner.nextLine().trim();
                arguments = new ArrayList<>(List.of(userInput.split("\\s")));
                if (arguments.size() > 1) {
                    num = Long.parseLong(arguments.get(0));
                    length = Integer.parseInt(arguments.get(1));
                }
                setProperties();
                if (arguments.size() == 2) {
                    processingTwoArgs();
                } else if (arguments.size() == 3) {
                    processingThreeArgs();
                } else if (arguments.size() >= 4) {
                    processingArgs();
                } else {
                    num = Long.parseLong(userInput);
                    System.out.println();
                    if (num > 0) {
                        ShowFullProperties(userInput);
                    } else if (num == 0) {
                        System.out.println("Goodbye!");
                        break;
                    } else {
                        System.out.println("The first parameter should be a natural number or zero.\n");
                    }
                }
            } catch (NumberFormatException e) {
                if (userInput.equals("") || userInput.equals(" ")) {
                    showRequests();
                } else {
                    if (num > 0) {
                        System.out.println("The second parameter should be a natural number.\n");
                    } else {
                        System.out.println("The first parameter should be a natural number or zero.\n");
                    }
                }
            }
        }
    }
    
    private static void setProperties() {
        if (arguments.size() > 2) {
            p1 = arguments.get(2);
            if (arguments.size() > 3) {
                p2 = arguments.get(3);
                if (arguments.size() > 4) {
                    p3 = arguments.get(4);
                    if (arguments.size() > 5) {
                        p4 = arguments.get(5);
                        if (arguments.size() > 6) {
                            p5 = arguments.get(6);
                        }
                    }
                }
            }
        }
    }

    private static boolean switchNumOfProps() {
        int numProp = arguments.size();
        switch (numProp) {
            case 3:
                return getMethod(p1);
            case 4:
                return getMethod(p1) && getMethod(p2);
            case 5:
                return getMethod(p1) && getMethod(p2) && getMethod(p3);
            case 6:
                return getMethod(p1) && getMethod(p2) && getMethod(p3) && getMethod(p4);
            case 7:
                return getMethod(p1) && getMethod(p2) && getMethod(p3) && getMethod(p4) && getMethod(p5);
        }
        return false;
    }

    private static void fillPropArray() {

        while (nums.size() < length) {
            if (switchNumOfProps()) {
                nums.add(num);
            }
            num++;
        }
    }

    private static boolean getMethod(String prop) {
        String number = String.valueOf(num);
        switch (prop.toLowerCase()) {
            case "even":
                return isEven(number);
            case "odd":
                return !isEven(number);
            case "buzz":
                return isBuzz(number);
            case "duck":
                return isDuck(number);
            case "palindromic":
                return isPalindromic(number);
            case "gapful":
                return isGapful(number);
            case "spy":
                return isSpy(number);
            case "square":
                return isSquare(number);
            case "sunny":
                return isSunny(number);
            case "jumping":
                return isJumping(number);
        }
        return false;
    }

    private static boolean hasProp(String prop) {
        for (String p:properties) {
            if (p.equalsIgnoreCase(prop)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean hasProp(String prop, String[] a) {
        for (String p:a) {
            if (p.equalsIgnoreCase(prop)) {
                return true;
            }
        }
        return false;
    }

    private static String isExclusivePropMessage() {
        String[] a = new String[arguments.size() - 2];
        for (int i = 0; i < a .length; i++) {
            a[i] = arguments.get(i + 2);
        }
        String s = "";
        if (hasProp("even", a) && hasProp("odd", a)) {
            s = "[EVEN, ODD]";
        } else if (hasProp("duck", a) && hasProp("spy", a)) {
            s = "[DUCK, SPY]";
        } else if (hasProp("sunny", a) && hasProp("square", a) && !hasProp("jumping", a)) {
            s = "[SUNNY, SQUARE]";
        }
       return s;
   }

    private static boolean isExclusiveProp() {
        String[] a = new String[arguments.size() - 2];
        for (int i = 0; i < a .length; i++) {
            a[i] = arguments.get(i + 2);
        }
        boolean one = hasProp("even", a) && hasProp("odd", a);
        boolean two = hasProp("duck", a) && hasProp("spy", a);
        boolean three = hasProp("sunny", a) && hasProp("square", a);

        return one || two || three;
    }

    private static void absentPropMessage() {
        String[] a = new String[arguments.size() - 2];
        for (int i = 0; i < a .length; i++) {
            a[i] = arguments.get(i + 2).toUpperCase();
        }
        StringBuilder str = new StringBuilder("");
        int count = 0;
        for (String s : a) {
            if (!hasProp(s)) {
                str.append(s).append(", ");
                count++;
            }
        }
        StringBuilder props = new StringBuilder(str.substring(0, str.length() - 2));
        if (count > 1) {
            System.out.println("The properties [" + props + "] are wrong.\n" + available);
        }else {
            System.out.println("The property [" + props + "] is wrong.\n" + available);
        }

    }
}

