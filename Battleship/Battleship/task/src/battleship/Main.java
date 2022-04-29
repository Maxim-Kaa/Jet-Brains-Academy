
package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       BattleField.battle();

        // Write your code here
    }
}

class BattleField {

    private final char[][] field;
    private static int player = 1;

    private BattleField() {
        this.field = new char[10][11];
    }

    private static void changePlayer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press Enter and pass the move to another player");
        String ent = scanner.nextLine();
        if (player == 1) {
            player = 2;
        } else {
            player = 1;
        }
        System.out.println("...");
    }

    private void setField() {
        String rows = "ABCDEFGHIJ";
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j <= field.length; j++) {
                field[i][j] = '~';
                field[i][0] = rows.charAt(i);
            }
        }
    }

    private void showField() {
        System.out.println();
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (char[] row:field) {
            for (char el:row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }

    private void showFog() {
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
        System.out.println("---------------------");
    }

    private void setFleet() {
        System.out.println("Player " + player + ", place your ships on the game field");
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

    private void placeShip(int shipLength, String shipType) {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            try {
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
            } catch (NumberFormatException e) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }

        }
    }

    private boolean isFreeNearVertical(int startRow, int startCol, int shipLength) {
        for (int i = -1; i <= shipLength; i++) {
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
        return Coordinate.valueOf(point.substring(0, 1).toUpperCase()).ordinal();
    }

    private int getCol(String point) {
        return Integer.parseInt(point.substring(1));
    }

    private void takeShot() {
        System.out.println("Player " + player + ", it's your turn:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String shot = scanner.nextLine();
                int rowShot = getRow(shot);
                int colShot = getCol(shot);
                if (field[rowShot][colShot] == '~' || field[rowShot][colShot] == 'M') {
                    field[rowShot][colShot] = 'M';
                    System.out.println("You missed!");
                    break;
                }else if (field[rowShot][colShot] == 'O' || field[rowShot][colShot] == 'X') {
                    field[rowShot][colShot] = 'X';
                    if (!isSank(rowShot, colShot) && checkField()) {
                        System.out.println("You hit a ship!");
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

    public static void battle() {
        BattleField field1 = new BattleField();
        BattleField field2 = new BattleField();
        field1.setField();
        field1.setFleet();
        changePlayer();
        field2.setField();
        field2.setFleet();
        while (field1.checkField() && field2.checkField() ) {
            changePlayer();
            field2.showFog();
            field1.showField();
            field2.takeShot();
            if (field2.checkField()) {
                changePlayer();
                field1.showFog();
                field2.showField();
                field1.takeShot();
            }
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }

    private boolean checkField() {
        for (char[] row:field) {
            for (char el:row) {
                if (el == 'O') {
                    return  true;
                }
            }
        }
        return false;
    }

    private boolean isSankUp(int row, int col) {
        while (row > 0) {
            if (field[row][col] == 'O') {
                return false;
            } else if (field[row][col] == '~' || field[row][col] == 'M'){
                return true;
            }
            row -= 1;
        }
        return true;
    }

    private boolean isSankDown(int row, int col) {
        while (row < 10) {
            if (field[row][col] == 'O') {
                return false;
            } else if (field[row][col] == '~' || field[row][col] == 'M'){
               return true;
            }
            row += 1;
        }
        return true;
    }

    private boolean isSankLeft(int row, int col) {
        while (col > 0) {
            if (field[row][col] == 'O') {
                return false;
            } else if (field[row][col] == '~' || field[row][col] == 'M'){
                return true;
            }
            col -= 1;
        }
        return true;
    }

    private boolean isSankRight(int row, int col) {
        while (col < 11) {
            if (field[row][col] == 'O') {
                return false;
            } else if (field[row][col] == '~' || field[row][col] == 'M'){
                return true;
            }
            col += 1;
        }
        return true;
    }

    private boolean isSank(int row, int col) {
        return isSankDown(row, col) && isSankUp(row, col) && isSankLeft(row, col) && isSankRight(row, col);
    }
}
