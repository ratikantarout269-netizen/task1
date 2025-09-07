import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0; // total score across rounds
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // random number between 1-100
            int attemptsLeft = 7; // maximum attempts allowed
            boolean guessedCorrectly = false;

            System.out.println("\nI have picked a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it!");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");

                // check if user entered a number
                if (!scanner.hasNextInt()) {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    scanner.next(); // clear wrong input
                    continue;
                }

                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("✅ Correct! You guessed the number.");
                    guessedCorrectly = true;
                    score += attemptsLeft * 10; // higher score if more attempts left
                    break;
                } else if (userGuess > numberToGuess) {
                    System.out.println("📉 Too high!");
                } else {
                    System.out.println("📈 Too low!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + score);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n🎯 Game Over! Your final score is: " + score);
        System.out.println("Thanks for playing!");

        scanner.close();
    }
}
