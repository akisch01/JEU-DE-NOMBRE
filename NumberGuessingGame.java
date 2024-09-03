import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
                    Random random = new Random();
                    int maxRounds = 5; // nombre maximum de tours
                    int maxAttempts = 7; // nombre maximum de tentatives par tour
                    int totalScore = 0;
                    int round = 1;
                    
                    System.out.println("Bienvenue au jeu de devinette de nombre!");
                    while (round <= maxRounds) {
                        int numberToGuess = random.nextInt(100) + 1;
                        int attempts = 0;
                        boolean hasWon = false;
                        
                        System.out.println("\nTour " + round + ": Devinez un nombre entre 1 et 100.");
                        
                        while (attempts < maxAttempts) {
                            System.out.print("Entrez votre devinette: ");
                            int userGuess = scanner.nextInt();
                            attempts++;
                            
                            if (userGuess == numberToGuess) {
                                System.out.println("Félicitations! Vous avez deviné correctement en " + attempts + " tentatives.");
                                totalScore += (maxAttempts - attempts + 1); // Plus l'utilisateur devine rapidement, plus il obtient de points
                                hasWon = true;
                                break;
                            } else if (userGuess < numberToGuess) {
                                System.out.println("Votre devinette est trop basse.");
                            } else {
                                System.out.println("Votre devinette est trop haute.");
                            }
                        }
                        
                        if (!hasWon) {
                            System.out.println("Désolé! Vous avez épuisé vos tentatives. Le nombre était " + numberToGuess);
                        }
                        
                        System.out.print("Voulez-vous jouer un autre tour? (oui/non): ");
                        String playAgain = scanner.next();
                        if (!playAgain.equalsIgnoreCase("oui")) {
                            break;
                        }
                        round++;
                    }
                    
                    System.out.println("\nJeu terminé. Votre score total est: " + totalScore);
        }
    }
}
