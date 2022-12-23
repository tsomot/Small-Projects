/** RockPaperScissors.java
  * @description The computer terminal game for Rock Paper Scissors
  * @author Tenzin Tsomo
  * @version 1.0, 2022-10-19
*/

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors{

  //attributes
  private Scanner input = new Scanner(System.in);
  private Player user, computer = new Player("The Computer");
  private Random rand = new Random();


  //methods

  /** Constructor for the RockPaperScissors class */
  public RockPaperScissors(){
    welcome();
  }

  /** prints welcome message to user and collects name */
  public void welcome(){
    System.out.println("------------------------------------------------");
    System.out.println("\t Welcome to Rock Paper Scissors!");
    System.out.println("------------------------------------------------\n\n");

    System.out.print("What is your name?  ");
    user = new Player(input.nextLine()); // get name and create a player

    //directions on how to play
    System.out.println("You will face off against the computer in Rock, ");
    System.out.println("Paper, Scissors. \n ");
    System.out.println("\t * Rock (R) beats Scissors (S) ");
    System.out.println("\t * Paper (P) beats Rock (R) ");
    System.out.println("\t * Scissors (S) beats Paper (P) \n");

    oneMatch();
  }

  /** A single RPS match */
  public void oneMatch(){

    getUserPlay();
    generateComputerPlay();

    // notify the user of the plays made
    System.out.println( "You played " + user.getPlay() +
                        " and the computer played " + computer.getPlay() +
                        ".\n ");

    showWinnerAndUpdateScores(); // displays the winner
    displayScores();
    playAgain();
  }

  /** prints the scores of the players */
  public void displayScores(){
    System.out.println(user.getName() + ": " + user.getScore());
    System.out.println(computer.getName() + ": " + computer.getScore() + "\n");
  }

  /** Prompts user to play again */
  public void playAgain(){
    System.out.println("Would you like to play again? (Y/N)");
    char answer = input.nextLine().charAt(0);

    switch(answer){
      case 'Y': case 'y':
        oneMatch();
        break;
      case 'N': case 'n':
        System.out.println("We didn't want to either. BYEEEEE!");
        break;
      default:
        System.out.println();
        playAgain();
        break;
    }
  }

  /** setting computer's play randomly */
  public void generateComputerPlay(){
    char plays[] = new char[]{'R', 'P', 'S'};// array of plays
    computer.setPlay(plays[rand.nextInt(3)]);
  }

  /** setting the user play */
  public void getUserPlay(){
    System.out.println("What would you like to play?");
    System.out.print("Enter R, P, or S: ");
    user.setPlay(input.nextLine().charAt(0));
  }

  /** determines the winner or if it is a tie */
  public void showWinnerAndUpdateScores(){
    switch((int) computer.getPlay() - (int) user.getPlay()){

        case 0: //ties
          System.out.println("It's a tie!");
          break;

        case 1: case 2: case -3: // user wins
          System.out.println(user.getName() + " is the winner.");
          user.incrementScore();
          break;

        case -1: case -2: case 3: // computer wins
          System.out.println(computer.getName() + " is the winner.");
          computer.incrementScore();
          break;

        default:
          break;
    }
  }

  public static void main(String[] args) {
    new RockPaperScissors();
  }



// TO DO: Build a class specifically for scoring sets of plays

private class Player{

  // attributes
  private int currentScore;
  private char currentPlay;
  private String name;

  // methods
  /** Constructor for the Player class */
  public Player(String name){
    currentScore = 0;
    this.name = name;
  }

  /** returns String name attribute */
  public String getName(){
    return name;
  }

  /** sets currentPlay attribute to 'R', 'S', or 'P' */
  public void setPlay(char play){
      currentPlay = play;
  }

  /** returns currentPlay attribute, which is 'R', 'S', or 'P' */
  public char getPlay(){
    return currentPlay;
  }

  /** adds 1 to currentScore attribute */
  public void incrementScore(){
    currentScore++;
  }

  /** returns currentScore attribute */
  public int getScore(){
    return currentScore;
  }


}

}//end of RockPaperScissors class
