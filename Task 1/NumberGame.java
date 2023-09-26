//Code Written By Vivek Bhosale
//This is Only for Internship 
import java.util.*;
import java.util.Scanner;

public class NumberGame
{
    public NumberGame() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the Number Guessing Game!");
        int score = 0;

        String playAgainInput;

        // Loop to play the game multiple times
        for (boolean playAgain = true; playAgain; playAgain = playAgainInput.equalsIgnoreCase("yes")) 
        {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            // Loop for each guessing attempt
            while (attempts < maxAttempts)
            {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                scanner.nextLine(); 
                attempts++;

                if (userGuess == targetNumber) 
                {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    score++;
                    break; // Exit the guessing loop if the guess is correct
                } else if (userGuess < targetNumber) 
                {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            // Check if the player has run out of attempts
            if (attempts >= maxAttempts) {
                System.out.println("Sorry, You've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.println("Do you want to play again? (yes/no): ");
            playAgainInput = scanner.nextLine();
        }

        System.out.println("Game over! Your score: " + score);
        scanner.close();
    }
}
