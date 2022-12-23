/** BugsInCode.java
  * @description Illustrates loops
  * @author Tenzin Tsomo 
  * @version 1.0, 2022-09-26
*/

import java.util.Scanner;
import java.util.Random;

public class BugsInCode{

  //attributes
  private Scanner input = new Scanner(System.in);
  private int number;
  private Random rand = new Random();

  //methods
  /** Constructor for the class */
  public BugsInCode(){} // empty constructor

  /** managing input from the user */
  public void inputFromUser(){

    // getting input from user
    System.out.println("Please enter a number between 1 and 150: ");
    number = input.nextInt();

    // checking that input is valid
    if (number <= 0 ){
      System.out.println("Invalid input, please give something higher than 0.");
      inputFromUser(); // <--- example of recursion
    } else if(number > 150){
      System.out.println("Invalid input, please give something lower than 150.");
      inputFromUser(); // <--- example of recursion
    }
    //input is valid!
    // number attribute is satisfied
  }

  /** method to generate the lyrics of bugs in code song */
  public void bugsInTheCode(){
    inputFromUser();
    String s;
    int i = number; //attribute that stores the user input

    // the middle criterion needs to be true during the loop
    while(i>0){ //i = 99, i = 98. i = 97, ...
      switch(i){
        case 1:
            s = "";
            s += "There is 1 bug in my code, ";
            s += "1 bug in my code. \n";
            s += "I find it and I solve it. Now there ";
            i = rand.nextInt(101);
              switch(i){
                case 0:
                  s += "are no bugs in my code!";
                  break;
                case 1:
                  s += "is 1 bug in my code. \n";
                  break;
                default:
                  s += "are " + i + " bugs in my code. \n";
                  break;
              }
            System.out.println(s);
            break;
        default:
            s = "";
            s += "There are " + i + " bugs in my code, ";
            s += i + " bugs in my code. \n";
            s += "I find one and I solve it. Now there ";
            i = rand.nextInt(101);
            //When i is 2, i-1 is 1 so we need it to be singular
              if ( i > 1){
                s += "are " + i + " bugs in my code. \n";
              }else if (i==0){
                s += "are no bugs in my code!";
              }else{
                s += "is 1 bug in my code. \n";
              }
            System.out.println(s);
      }//end of switch statement
    }//emd of the while loop

    // 1 bottle of beer

  }

  /** Example of a for loop */
  public void bottlesOfBeer(){

    inputFromUser();
    String s;

    // the middle criterion needs to be true during the loop
    for (int i=number; i>1; i--){ //i = 99, i = 98. i = 97, ...
      s = "";
      s += i + " bottles of beer on the wall, ";
      s += i + " bottles of beer. \n";
      s += "You take one down, pass it around ";
      //When i is 2, i-1 is 1 so we need it to be singular
        if ( (i-1)> 1){
          s += (i - 1) + " bottles of beer on the wall. \n";
        }else{
          s +="1 bottle of beer on the wall. \n";
        }
      System.out.println(s);
    }

    // 1 bottle of beer
    s = "";
    s += "1 bottle of beer on the wall, ";
    s += "1 bottle of beer. \n";
    s += "You take one down, pass it around ";
    s += "No bottles of beer on the wall and you have a problem! \n";
    System.out.println(s);
  }

  /** main method for testing */
  public static void main(String[] args) {
    BugsInCode test = new BugsInCode();
    test.bugsInTheCode(); // test out the code
    test.bottlesOfBeer();
  }
}//end of class
