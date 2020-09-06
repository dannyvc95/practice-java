/**
 * Generate a random number in range of 0 and MAX_NUMBER
 * and ask the user to try to guess that number
 * 
 * @author Daniel Valle
 */

package files;

import java.util.Scanner;

public class GuessNumberGame {

  private final static int MAX_NUMBER = 20;
  private final static int START_PLAYER_LIFES = 10;
  private final static int EASTER_EGG_NUMBER = -1;
  private final int RANDOM_NUMBER;
  
  private int playerLifes;
  Scanner input;

  public GuessNumberGame() {
    RANDOM_NUMBER = (int)(Math.random() * MAX_NUMBER);
    playerLifes = START_PLAYER_LIFES;
    input = new Scanner(System.in);
  }

  public void startGame() {
    System.out.println("Try to guess a number between 0 and " + MAX_NUMBER);

    while(!gameover()) {
      System.out.println("You have " + playerLifes + " lifes...");

      int playerGuessNumber = playerGuessNumber();
      if (playerGuessNumber == RANDOM_NUMBER) {
        break;
      } else {
        easterEgg(playerGuessNumber);
        System.out.println("Try again!");
        playerLifes--;
      }
    }

    playerStatus();
    input.close();
  }

  private boolean gameover() {
    return playerLifes < 1;
  }

  private int playerGuessNumber() {
    System.out.print("Guess the number: ");
    return input.nextInt();
  }

  private void playerStatus() {
    if (playerLifes > 0) {
      System.out.println("You're a winner!");
    } else {
      System.out.println("You're a looser!");
    }
  }

  private void easterEgg(int playerGuessNumber) {
    if (playerGuessNumber == EASTER_EGG_NUMBER) {
      System.out.println("Next time try with " + RANDOM_NUMBER);
    }
  }
}
