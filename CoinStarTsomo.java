/**
* CoinstarTsomo.java
* * @description Return giftcards or cash for change
* @author Tenzin Tsomo
* @version 1.0 2022-09-30
*/

import java.util.Scanner;
import java.text.NumberFormat;

  public class CoinstarTsomo{
    private int[] currencyValues, currencyAmounts = new int[10];
    private String[] currencyNamesSingular, currencyNamesPlural;
    private double totalDollarValue;
    private Scanner input;
    private NumberFormat f;
    /** Constructor for CoinstarSolution class */
    public CoinstarTsomo(){

      // initializing variables
      input = new Scanner(System.in);
      f = NumberFormat.getCurrencyInstance();
      currencyNamesSingular = new String[]{"penny", "nickel", "dime", "quarter",
                                  "one", "five", "ten", "twenty", "fifty",
                                  "one hundred"};
      currencyNamesPlural = new String[]{"pennies", "nickels", "dimes",
                                   "quarters", "ones", "fives", "tens",
                                   "twenties", "fifties", "hundreds"};
      currencyValues = new int[]{1, 5, 10, 25, 100, 500, 1000, 2000, 5000, 10000};

      System.out.println("\nCoinstar\u00AE kiosks turn the coins you toss in" +
                          " a jar into something you really \nwant–--like " +
                          "cash or a NO FEE eGift Card.\n");
      intake();
    }
    /** asks for total coinage and stores it*/
    public void intake(){

      for (int i=3; i>=0; i--){
        System.out.println("Enter the number of " + currencyNamesPlural[i]
                            + ": ");
        currencyAmounts[i] = input.nextInt();
      }
    totalValue();
    }
    /** calculates total cash value */
    public void totalValue(){

      for (int i=3; i>0; i--){
        currencyAmounts[0] += currencyAmounts[i] * currencyValues[i];
      }

      totalDollarValue = currencyAmounts[0] / 100.0;

      System.out.println("You have submitted: ");

      System.out.println("\n\n\t\t\t" + f.format(totalDollarValue) + "\n\n");

      cashOut();
    }


    /** prompts user to select a cash out method */
    public void cashOut(){

      System.out.println( "How would you like to cash out your" +
                          " coins? Select\n\t\t1 - cash, \n\t\t2" +
                          " - gift card.");
      int response = input.nextInt();
      if (response == 1){
        cash();
      }else if(response == 2){
        giftCard();
      }else{
        System.out.println("You have entered an invalid response.");
        cashOut();
      }

    }

    /** prints message about issuing hypothetical gift card */
    public void giftCard(){
      System.out.println( "You will now be issued a gift card" +
                          " in the amount of " + f.format(totalDollarValue)
                          + ".");
    }
    public void cash(){
      System.out.println( "You have selected cash. We will " +
                          "deduct a 10% fee.");
      System.out.println( "Your original balance was "
                          + f.format(totalDollarValue) + ".");

      double fee = Math.round(totalDollarValue * 10) / 100.0;
      totalDollarValue = totalDollarValue - fee;

      System.out.println( "We will deduct " + f.format(fee) +
                          " from that balance.");

      System.out.println( "Your new balance is " +
                          f.format(totalDollarValue) + ".");

      System.out.println("We will now return the same value in largest bills");
      String s = "";

      //int pennies = currencyAmounts[0];
      int pennies = (int) (totalDollarValue*100.0);

      for (int i = currencyValues.length-1; i>=0; i--){
        if (pennies >= currencyValues[i]*2){ //plural
          s += pennies/currencyValues[i] + " -- " + currencyNamesPlural[i] + " \n";
          pennies = pennies % currencyValues[i];
        }else if (pennies >= currencyValues[i]){ //singular
          s += "1 -- " + currencyNamesSingular[i] + " \n";
          pennies = pennies % currencyValues[i];
        }
      }
      System.out.println(s);

    }

    /** main method for testing */
    public static void main(String[] args) {
      CoinstarTsomo test = new CoinstarTsomo();
    }


  }
