package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.fillGrid();
        game.gameGrid();
        game.makeMove();
        game.gameGrid();
        game.whoWins();

    }
}
class TicTacToe {
    private final char[][] grid;
    private char player;

    public TicTacToe() {
        grid = new char[3][3];
    }

    private void changePlayer(char ch){
        if (ch == 'O') {
            player = 'X';
        } else {
            player = 'O';
        }
    }

    public void makeMove() {
        while (!isFullGrid() && isPossible() && !checkForWin()) {
            changePlayer(player);
            while (true){
                try {
                    Scanner scanner = new Scanner(System.in);
                    while (true) {
                        System.out.println("Enter the coordinates:");
                        int row = scanner.nextInt() - 1;
                        int col = scanner.nextInt() - 1;
                        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                            if(grid[row][col] != 'X' && grid[row][col] != 'O') {
                                grid[row][col] = player;
                                break;
                            }else {
                                System.out.println("This cell is occupied! Choose another one!");
                            }
                        } else {
                            System.out.println("Coordinates should be from 1 to 3!");
                        }

                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("You should enter numbers!");
                }
            }
            gameGrid();
        }
    }

    public void fillGrid() {
        String input = "         ";
        int count = 1;
        for (int i = 0; i < 3; i++) {
            count -= 1;
            for (int j = 0; j < 3; j++, count++) {
                grid[i][j] = input.charAt(i + count);
            }
        }
        player = 'O';
    }
    public void gameGrid() {
        System.out.println("---------");
        int count = 1;
        for (int i = 0; i < 3; i++) {
            count -= 1;
            System.out.print("| ");
            for (int j = 0; j < 3; j++, count++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    private boolean isFullGrid() {
        for (char[] row: grid) {
            for (char cell:row) {
                if (cell != 'X' && 'O' != cell) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkForWin() {
        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());
    }

    private boolean checkDiagonalsForWin() {
        return ((check(grid[0][0], grid[1][1], grid[2][2])) || (check(grid[0][2], grid[1][1], grid[2][0])));
    }
    private boolean checkColumnsForWin() {
        for (int i = 0; i < 3; i++) {
            if (check(grid[0][i], grid[1][i], grid[2][i])) {
                return true;
            }
        }
        return false;
    }

    private boolean check(char c1, char c2, char c3) {
        return (player == c1 && c1 == c2 && c2 == c3);
    }

    private boolean checkRowsForWin() {
        for (int i = 0; i < 3; i++) {
            if (check(grid[i][0], grid[i][1], grid[i][2])) {
                return true;
            }
        }
        return false;
    }

    private boolean isPossible() {;
        int countX = 0;
        int countO = 0;
        for (char[] row:grid) {
            for (char el:row) {
                if ('X' == el) {
                    countX++;
                } else if ('O' == el) {
                    countO++;
                }
            }
        }
        return Math.abs(countX - countO) <= 1;
    }
    public void whoWins() {
        if (isPossible() && checkForWin()) {
            System.out.println(player + " wins");
        } else if (isPossible() && !checkForWin()) {
            if (isFullGrid()) {
                System.out.println("Draw");
            } else {
                System.out.println("Game not finished");
            }
        } else {
            System.out.println("Impossible");
        }
    }
}
