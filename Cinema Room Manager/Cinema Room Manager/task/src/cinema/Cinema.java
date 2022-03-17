package cinema;

import java.math.BigDecimal;
import java.math.RoundingMode;;
import java.util.Scanner;

public class Cinema {
    static final int smallRoom = 60;
    static final int firstPrice = 10;
    static final int secondPrice = 8;
    static int countSold;
    static int income;
    static double soldInPercent;
    static  int totalIncome;


    public static void main(String[] args) {
        menu();
    }

    public static void totalIncomeCount(int rows, int seatsInRow) {
        int allSeats = rows * seatsInRow;
        if (allSeats <= smallRoom) {
            totalIncome = allSeats * firstPrice;
        } else {
            totalIncome = rows / 2 * seatsInRow * firstPrice + (rows - rows / 2) * seatsInRow * secondPrice;
        }
    }

    public static void visualiseSeats(String[][] cinema, int seatsInRow) {

        System.out.print("Cinema:\n" +
                "  ");
        for (int i = 1; i <= seatsInRow; i++) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < cinema.length; i++) {
            System.out.println();
            System.out.print(i + 1);
            for (int j = 0; j < cinema[i].length; j++) {
                System.out.print(" " + cinema[i][j]);
            }
        }
    }

    public static void priceOfSeat(int rows, int seatsInRow, int row) {
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int ticketPrice = firstPrice;
        int allSeats = rows * seatsInRow;
        if (allSeats > smallRoom && row > rows / 2) {
            ticketPrice = secondPrice;
        }
        income += ticketPrice;
        countSold++;
        soldInPercent = (double) countSold / allSeats * 100;

        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
    }

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();
        totalIncomeCount(rows, seatsInRow);
        String[][] cinema = new String[rows][seatsInRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                cinema[i][j] = "S";
            }
        }
        boolean enter = true;
        while (enter) {
            System.out.println();
            System.out.println("1. Show the seats\n" +
                        "2. Buy a ticket\n" +
                        "3. Statistics\n" +
                        "0. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    visualiseSeats(cinema, seatsInRow);
                    System.out.println();
                    break;
                case 2:
                    while (true) {
                        System.out.println("Enter a row number:");
                        int row = scanner.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        int seat = scanner.nextInt();
                        try {
                            if ("B".equals(cinema[row - 1][seat - 1])) {
                                System.out.println("That ticket has already been purchased!");

                            } else {
                                cinema[row - 1][seat - 1] = "B";
                                priceOfSeat(rows, seatsInRow, row);
                                visualiseSeats(cinema, seatsInRow);
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Wrong input!");
                        }
                    }
                    break;
                case 3:
                    BigDecimal percents = new BigDecimal(soldInPercent);
                    percents = percents.setScale(2, RoundingMode.HALF_DOWN);
                    System.out.println("Number of purchased tickets: " + countSold + "\n" +
                            "Percentage: " + percents + "%\n" +
                            "Current income: $" + income + "\n" +
                            "Total income: $" + totalIncome);
                    break;
                case 0:
                    enter = false;
            }
        }
    }
}