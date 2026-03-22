package Projects;
 import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
   

/**
 * GAME 2: Rock Paper Scissors (Beginner)
 * ----------------------------------------
 * Best-of-5 match against the computer.
 * Player types R / P / S.  Computer picks randomly.
 *
 * Concepts: arrays, switch, methods, score tracking
 */
public class Game2_RockPaperScissors {

    static final String[] CHOICES = {"Rock", "Paper", "Scissors"};
    static final Random   RAND    = new Random();

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner   = new Scanner(System.in);
        int playerScore   = 0;
        int computerScore = 0;
        int roundsToWin   = 3;  // first to 3 wins

        System.out.println("==============================");
        System.out.println("   Rock  Paper  Scissors!     ");
        System.out.println("   First to 3 wins the match. ");
        System.out.println("==============================\n");

        while (playerScore < roundsToWin && computerScore < roundsToWin) {
            System.out.printf("Score — You: %d | CPU: %d%n", playerScore, computerScore);
            System.out.print("Enter R (Rock), P (Paper), or S (Scissors): ");
            String input = scanner.next().trim().toUpperCase();

            int playerChoice = parseChoice(input);
            if (playerChoice == -1) {
                System.out.println("  Invalid input, please enter R, P, or S.\n");
                continue;
            }

            int cpuChoice = RAND.nextInt(3);
            System.out.println("  You chose: " + CHOICES[playerChoice]);
            System.out.println("  CPU chose: " + CHOICES[cpuChoice]);

            int result = evaluate(playerChoice, cpuChoice);
            switch (result) {
                case 1 -> {
                    System.out.println("  → You win this round! ✓\n");
                    playerScore++;
                }
                case -1 -> {
                    System.out.println("  → CPU wins this round. ✗\n");
                    computerScore++;
                }
                default -> System.out.println("  → It's a tie!\n");
            }
        }

        System.out.println("==============================");
        if (playerScore > computerScore) {
            System.out.println("  🏆 YOU WIN THE MATCH! 🏆");
        } else {
            System.out.println("  CPU wins the match. Better luck next time!");
        }
        System.out.printf("  Final Score — You: %d | CPU: %d%n", playerScore, computerScore);
        System.out.println("==============================");
        scanner.close();
    }

    // Returns 1 if player wins, -1 if CPU wins, 0 for tie
    static int evaluate(int player, int cpu) {
        if (player == cpu) return 0;
        // Rock(0) beats Scissors(2), Paper(1) beats Rock(0), Scissors(2) beats Paper(1)
        if ((player == 0 && cpu == 2) ||
            (player == 1 && cpu == 0) ||
            (player == 2 && cpu == 1)) {
            return 1;
        }
        return -1;
    }

    static int parseChoice(String input) {
        return switch (input) {
            case "R" -> 0;
            case "P" -> 1;
            case "S" -> 2;
            default -> -1;
        };
    }
}
    
}
