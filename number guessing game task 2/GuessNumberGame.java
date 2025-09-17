import javax.swing.JOptionPane;
import java.util.Random;

public class GuessNumberGame {
    public static void main(String[] args) {
        int totalScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            Random random = new Random();
            int correctNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            while (!guessed && attempts < 10) {
                String input = JOptionPane.showInputDialog(null,
                        "Guess a number between 1 and 100\nAttempt " + (attempts + 1) + " of 10:");
                
                // Handle Cancel
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game cancelled.");
                    return;
                }

                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess == correctNumber) {
                    guessed = true;
                    int roundScore = (11 - attempts) * 10;
                    totalScore += roundScore;
                    JOptionPane.showMessageDialog(null, "Correct! You guessed the number in " + attempts + " attempts.\n" +
                            "You earned " + roundScore + " points this round.");
                } else if (guess < correctNumber) {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                }
            }

            if (!guessed) {
                JOptionPane.showMessageDialog(null, "You've used all attempts! The correct number was: " + correctNumber);
            }

            // Ask to play again
            int response = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again?",
                    JOptionPane.YES_NO_OPTION);

            if (response != JOptionPane.YES_OPTION) {
                playAgain = false;
                JOptionPane.showMessageDialog(null, "Thanks for playing!\nYour total score is: " + totalScore);
            }
        }
    }
}
