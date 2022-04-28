
package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BattleField field1 = new BattleField();
        field1.setField();
        field1.setFleet();
        System.out.println("The game starts!");
        field1.showFog();
        System.out.println("Take a shot!");
        field1.battle();
        // Write your code here
    }
}

class BattleField {

    private final char[][] field;

    public BattleField() {
        this.field = new char[10][11];
    }

    public void setField() {
        String rows = "ABCDEFGHIJ";
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j <= field.length; j++) {
                field[i][j] = '~';
                field[i][0] = rows.charAt(i);
            }
        }
    }

    public void showField() {
        System.out.println();
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (char[] row:field) {
            for (char el:row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    public void showFog() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (char[] row:field) {
            for (char el:row) {
                if (el == 'O') {
                    System.out.print('~' + " ");
                } else {
                    System.out.print(el + " ");
                }

            }
            System.out.println();
        }
    }

    public void setFleet() {
        showField();
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        placeShip(5, "Aircraft Carrier");
        showField();
        System.out.println("Enter the coordinates of the Battleship (4 cells):");
        placeShip(4, "Battleship");
        showField();
        System.out.println("Enter the coordinates of the Submarine (3 cells):");
        placeShip(3, "Submarine");
        showField();
        System.out.println("Enter the coordinates of the Cruiser (3 cells):");
        placeShip(3, "Cruiser");
        showField();
        System.out.println("Enter the coordinates of the Destroyer (2 cells):");
        placeShip(2, "Destroyer");
        showField();

    }

    public void placeShip(int shipLength, String shipType) {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            String point1 = scanner.next();
            String point2 = scanner.next();
            int row1 = getRow(point1);
            int col1 = getCol(point1);
            int row2 = getRow(point2);
            int col2 = getCol(point2);
            int startCol = col1;
            int endCol = col2;
            int startRow = row1;
            int endRow = row2;
            if (col1 > col2) {
                startCol = col2;
                endCol = col1;
            }
            if (row1 > row2) {
                startRow = row2;
                endRow = row1;
            }
            if (row1 == row2 && endCol - startCol + 1 == shipLength) {
                if(isFreeNearHorizontal(startRow, startCol, shipLength)) {
                    for (int j = 0; j < shipLength; j++) {
                        field[row1][j + startCol] = 'O';
                    }
                    cont = false;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            } else if (col1 == col2 && endRow - startRow + 1 == shipLength) {
                if(isFreeNearVertical(startRow, startCol, shipLength)) {
                    for (int i = 0; i < shipLength; i++) {
                        field[i + startRow][col1] = 'O';
                    }
                    cont = false;
                } else {
                    System.out.println("Error! You placed it too close to another one. Try again:");
                }
            } else if (col1 == col2 && endRow - startRow + 1 != shipLength
                    || row1 == row2 && endCol - startCol + 1 != shipLength) {
                System.out.println("Error! Wrong length of the " + shipType + "! Try again:");

            }
            else {
                System.out.println("Error! Wrong ship location! Try again:");
            }
        }
    }

    private boolean isFreeNearVertical(int startRow, int startCol, int shipLength) {
        for (int i = -1; i <= shipLength + 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (field[i + startRow][j + startCol] == 'O') {
                        return false;
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }
        return true;
    }

    private boolean isFreeNearHorizontal(int startRow, int startCol, int shipLength) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= shipLength + 1; j++) {
                try {
                    if (field[i + startRow][j + startCol] == 'O') {
                        return false;
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }
        return true;
    }

    private int getRow(String point) {
        return Coordinate.valueOf(point.substring(0, 1)).ordinal();
    }

    private int getCol(String point) {
        return Integer.parseInt(point.substring(1));
    }

    public void takeShot() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String shot = scanner.nextLine();
                int rowShot = getRow(shot);
                int colShot = getCol(shot);
                if (field[rowShot][colShot] == '~' || field[rowShot][colShot] == 'M') {
                    field[rowShot][colShot] = 'M';
                    showFog();
                    System.out.println("You missed! Try again:");
                    break;
                }else if (field[rowShot][colShot] == 'O' || field[rowShot][colShot] == 'X') {
                    field[rowShot][colShot] = 'X';
                    showFog();
                    if (!isSank(rowShot, colShot) && checkField()) {
                        System.out.println("You hit a ship! Try again:");
                    } else if (isSank(rowShot, colShot) && checkField()){
                        System.out.println("You sank a ship! Specify a new target:");
                    }
                    break;
                }
            } catch (Exception e) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }


    }

    public void battle() {
        while (checkField()) {
            takeShot();
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }

    public boolean checkField() {
        for (char[] row:field) {
            for (char el:row) {
                if (el == 'O') {
                    return  true;
                }
            }
        }
        return false;
    }

    public boolean isSank(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                try {
                    if (field[i + row][j + col] == 'O') {
                        return false;
                    }
                } catch (IndexOutOfBoundsException ignored) {
                }
            }
        }
        return true;
    }
}
