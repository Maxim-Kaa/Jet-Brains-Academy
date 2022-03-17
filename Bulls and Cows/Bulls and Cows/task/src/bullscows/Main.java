package bullscows;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game play = new Game();
        play.gamePlay();
    }
}

class Game {
    private String secret;
    private int bulls;
    private int cows;
    private int secretLength;
    private String Length;
    private final String allChars;
    private String stars;
    private final int maxLength;
    private String rng;
    private int range;
    private boolean continueGame;

    public Game() {
        bulls = 0;
        cows = 0;
        allChars = "abcdefghijklmnopqrstuvwxyz";
        stars = "";
        maxLength = 36;
        continueGame = true;
    }

    private void checkGuess(String g) {
        for (int i = 0; i < secretLength; i++) {
            if (secret.charAt(i) == g.charAt(i)) {
                bulls++;
            } else {
                for (int j = 0; j < secretLength; j++){
                    if (secret.charAt(i) == g.charAt(j))
                    cows++;
                }
            }
        }
    }

    private void gradeIt() {
        String c = "cow";
        String b = "bull";
        if (bulls > 1) {
            b = "bulls";
        }
        if (cows > 1 ) {
            c = "cows";
        }
        if (cows == 0 && bulls == 0) {
            System.out.println("Grade: None.");
        } else if (cows == 0 && bulls > 0) {
            System.out.println("Grade: " + bulls + " " + b );
        } else if (bulls == 0 && cows > 0) {
            System.out.println("Grade: " + cows + " " + c );
        } else {
            System.out.println("Grade: " + bulls + " " + b + " and " + cows + " " + c);
        }
    }
    private void setSecret() {

        Random random = new Random(100000);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        Length = scanner.nextLine();
        secretLength = Integer.parseInt(Length);
        System.out.println("Input the number of possible symbols in the code:");
        rng = scanner.nextLine();
        range = Integer.parseInt(rng);
        if (secretLength <= maxLength && secretLength < range && range <= maxLength) {
            StringBuilder secret2 = new StringBuilder();
            String secretChars;
            do {
                String secret1 = String.valueOf(Math.random());
                if (range > 10) {
                    secretChars = allChars.substring(0, range - 10);
                } else {
                    secretChars = "";
                }
                secret1 = secret1.substring(2);
                secret2 = new StringBuilder(secret2 + secret1);
                secret2.reverse();
                for (int i = 0; i < secret2.length() - 1; i++) {
                    for (int j = i + 1; j < secret2.length(); j++) {
                        if (secret2.charAt(i) == secret2.charAt(j) && range > 10) {
                            secret2.replace(j, j + 1, String.valueOf(secretChars.charAt(random.nextInt(range - 10))));
                        }
                    }
                }
                for (int i = 0; i < secret2.length() - 1; i++) {
                    for (int j = i + 1; j < secret2.length(); j++) {
                        if (secret2.charAt(i) == secret2.charAt(j)) {
                            secret2.deleteCharAt(j);
                            j--;
                        }
                    }
                }
                secret2.reverse();
            } while (secret2.length() < secretLength);
            secret = String.valueOf(secret2.delete(secretLength, secret2.length()));
            for (int i = 0; i < secret.length(); i++) {
                stars = stars.concat("*");
            }
            if (secretLength > 0) {
                if (range > 10) {
                    System.out.println("The secret is prepared: " + stars + " (0-9, a-" + secretChars.charAt(secretChars.length() - 1)+ ").");
                } else {
                    System.out.println("The secret is prepared: " + stars + " (0-9)");
                }
                System.out.println("Okay, let's start a game!");
            } else {
                System.out.println("Error: minimum number of possible symbols in the code is 1.");
            }
        } else if (secretLength <= maxLength && secretLength > range) {
            continueGame = false;
            System.out.println("Error: it's not possible to generate a code with a \n" +
                    "length of " + secretLength + " with " + range + " unique symbols.");
        } else if (maxLength < range) {
            continueGame = false;
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        } else if (secretLength > maxLength) {
            continueGame = false;
            System.out.println("Error: can't generate a secret number with a length of " + secretLength + " because\n" +
                    "there aren't enough unique symbols.");

        }

    }
    public void gamePlay() {
        try {
            int turn = 1;
            setSecret();
            Scanner scanner = new Scanner(System.in);
            while (bulls < secretLength && continueGame){
                bulls = 0;
                cows = 0;
                System.out.println("Turn " + turn + ":");
                turn++;
                String guess = scanner.nextLine();
                if (guess.length() == secretLength) {
                    checkGuess(guess);
                } else {
                    System.out.println("Wrong number of characters");
                    continue;
                }
                gradeIt();
                checkWin(bulls);
            }
        } catch (NumberFormatException e) {
            if (rng == null) {
                System.out.println("Error: \"" + Length + "\" isn't a valid number.");
            } else {
                System.out.println("Error: \"" + rng + "\" isn't a valid number.");
            }
        }

    }
    private void checkWin(int bulls) {
        if (bulls == secretLength) {
            System.out.println("Congratulations! You guessed the secret code.");
        }
    }
}
