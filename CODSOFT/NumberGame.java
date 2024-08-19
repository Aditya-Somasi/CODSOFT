import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playAgain;
        do {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int userGuess = 0;
            int maxAttempts = 10;

            System.out.println("Guess a number between 1 and 100!");

            while (attempts < maxAttempts && userGuess != numberToGuess) {
                System.out.print("Enter your guess: ");
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                }
            }

            if (userGuess != numberToGuess) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (1 for Yes, 0 for No): ");
            playAgain = scanner.nextInt();

        } while (playAgain == 1);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}
