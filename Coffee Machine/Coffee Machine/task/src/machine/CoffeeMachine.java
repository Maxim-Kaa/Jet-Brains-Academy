package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int capsTotal = 9;
    static int waterTotal = 400;
    static int milkTotal = 540;
    static int beansTotal = 120;
    static int moneyTotal = 550;

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String firstAnswer = scanner.next();
            if ("remaining".equals(firstAnswer)) {
                remaining(waterTotal, milkTotal, beansTotal, capsTotal, moneyTotal);
            }else if ("exit".equals(firstAnswer)) {
                break;
            } else if ("fill".equals(firstAnswer)) {
                fill();
            } else if ("take".equals(firstAnswer)) {
                System.out.println("I gave you $" + moneyTotal);
                moneyTotal = 0;
            } else if ("buy".equals(firstAnswer)) {
                buy();
            }
        } while (true);


    }

    public static void main(String[] args) {
        menu();
    }
    public static void remaining(int waterTotal, int milkTotal, int beansTotal, int capsTotal, int moneyTotal) {
        System.out.println("The coffee machine has:\n" +
                waterTotal + " ml of water\n" +
                milkTotal + " ml of milk\n" +
                beansTotal + " g of coffee beans\n" +
                capsTotal + " disposable cups\n" +
                "$" + moneyTotal + " of money");
    }
    public static void buy() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to mai menu: ");
            String buyAnswer = scanner.next();
            if ("back".equals(buyAnswer)) {
                break;
            } else if ("1".equals(buyAnswer)) {
                if (waterTotal < 250 || beansTotal < 16) {
                    if (waterTotal < 250) {
                        System.out.println("Sorry, not enough water!");
                        break;
                    } else {
                        System.out.println("Sorry, not enough coffee beans!");
                        break;
                    }
                }else {
                    waterTotal -= 250;
                    beansTotal -= 16;
                    moneyTotal += 4;
                    capsTotal -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }

            }else  if ("2".equals(buyAnswer)) {
                if (waterTotal < 350 || milkTotal < 75 || beansTotal < 20) {
                    if (waterTotal < 350) {
                        System.out.println("Sorry, not enough water");
                        break;
                    } else if (milkTotal < 75) {
                        System.out.println("Sorry, not enough milk");
                        break;
                    } else {
                        System.out.println("Sorry, not enough coffee beans!");
                        break;
                    }
                } else {
                    waterTotal -= 350;
                    beansTotal -= 20;
                    moneyTotal += 7;
                    milkTotal -= 75;
                    capsTotal -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }

            } else if ("3".equals(buyAnswer)) {
                if (waterTotal < 200 || milkTotal < 100 || beansTotal < 12) {
                    if (waterTotal < 200) {
                        System.out.println("Sorry, not enough water");
                        break;
                    }else if (milkTotal < 100) {
                        System.out.println("Sorry, not enough milk");
                        break;
                    }else {
                        System.out.println("Sorry, not enough coffee beans!");
                        break;
                    }
                } else {
                    waterTotal -= 200;
                    beansTotal -= 12;
                    moneyTotal += 6;
                    milkTotal -= 100;
                    capsTotal -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                    break;
                }
            }
        }
    }
    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addCaps = scanner.nextInt();
        waterTotal += addWater;
        beansTotal += addBeans;
        milkTotal += addMilk;
        capsTotal += addCaps;
    }

}
