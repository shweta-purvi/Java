import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min = 1;
        int max = 100;
        int targetNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between " + min + " and " + max + ".");
        System.out.println("Try to guess it!");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < min || userGuess > max) {
                    System.out.println("Please guess a number between " + min + " and " + max + ".");
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }
        
        scanner.close();
    }
}
