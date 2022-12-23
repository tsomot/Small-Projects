/** BankAccount.java
  * @description makes a bank account class for Lake Forest Bank
  * @author Tenzin Tsomo
  * @ version 1.0 2022-09-19
  */

public class BankAccount{

    // attributes
    private String firstName;
    private String lastName;
    private double balance;
    private int accountNumber;
    private static final long ROUTING_NUMBER = 3847295023L; //L indicates to make raw number a long
    private static int counter = 0;

    // methods

    // TODO: Write getters for all attributes
    // TODO: toString()

    /** Changes the first name attribute */
    public void setFirstName(String newFirstName){
      firstName = newFirstName;
    }

    /** Changes the last name attribute */
    public void setLastName(String newLastName){
      lastName = newLastName;
    }

    /** Constructor for the bank account class */
    public BankAccount(String firstName, String lastName, double startingBalance){
      this.firstName = firstName;
      this.lastName = lastName;
      balance = startingBalance;
      counter++; //increase counter by 1
      accountNumber = counter;
    }

    /** Getter for the static attribute counter */
    public static int getNumOfBankAccounts(){
      return counter;
    }

    /** Getter for the first name attribute */
    public String getFirstName(){
      return firstName;
    }

    /** method to deposit money into account */
    public void deposit(double amount){
      balance += amount; //adding amount to balance
    }

    /** method to withdraws money into account */
    public double withdrawal(double amount){

      if (amount <= balance){
        balance -= amount; //subtracting amount to balance
      }else{
        System.out.println("You cannot withdraw " + amount);
        System.out.println("Your balance is only " + balance);
        amount = 0;
      }

      return amount;
    }

    /** main method for testing */
    public static void main(String[] args) {
      BankAccount account1 = new BankAccount("Danny", "DeVito", 540.25);
      BankAccount account2 = new BankAccount("Benedict", "Cumberbatch", 25.43);
      BankAccount account3 = new BankAccount("Harry", "Styles", 32.12);
      BankAccount account4 = new BankAccount("Harrison", "Ford", 19.77);
      System.out.println(BankAccount.getNumOfBankAccounts()); //4
      System.out.println(account1.getFirstName()); // Danny
      System.out.println(account3.withdrawal(10.00)); //10.0
      account2.withdrawal(300.00); // print the error message
      System.out.println(account4); // print the memory address
    }


}// end of class
