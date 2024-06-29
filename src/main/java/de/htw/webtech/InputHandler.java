package de.htw.webtech;


import java.util.Scanner;

public class InputHandler {

    public String getPlayerAction(Scanner scanner) {
        while (true) {
            System.out.print("Hit or stand? (h/s): ");
            String action = scanner.nextLine();
            if (action.equals("h") || action.equals("s")) {
                return action;
            } else {
                System.out.println("Invalid action. Please enter 'h' or 's'.");
            }
        }
    }

    public boolean playAgain(Scanner scanner) {
        while (true) {
            System.out.print("Play again? (y/n): ");
            String playAgain = scanner.nextLine();
            if (playAgain.equals("y")) {
                return true;
            } else if (playAgain.equals("n")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'y' or 'n'.");
            }
        }
    }
}
