/*
  The user chooses between 5 different types of cookies and chooses how
  many boxes of cookies they desired.  The user also enters their age.
  The program will calculate the subtotal based on type of cookie and number
  of boxes ordered.  It will then apply a discount based on age.  Then the
  sales tax is added and a final summary is displayed.
 */
import java.util.Scanner;

public class CookieDrive {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //declare needed variables
        double costPerBox = 0;

        //declare the constant for sales tax
        final double SALES_TAX = 0.0635;
        
        //declare constant for age limit
        final int AGE_LIMIT = 60;

        //declare a constant for percentage reduction based on age
        final double PERCENT_REDUCTION = 0.1;
        
        //display the cookie type menu
        System.out.println("Welcome to the Cookie Drive...");
        System.out.println("1 - Thin Mints");
        System.out.println("2 - Trefoils");
        System.out.println("3 - Samoas");
        System.out.println("4 - Tagalongs");
        System.out.println("5 - Do-si-dos");

        //get user's menu choice
        System.out.print("Enter the number of the type of cookie would you "
                + "like: ");
        int cookieType = input.nextInt();

        //get the number of boxes desired from the user
        System.out.print("Enter the number of boxes desired: ");
        int numberOfBoxes = input.nextInt();

        //get the user's age
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        //determine base price per box
        if (numberOfBoxes < 10) {
            switch (cookieType) {
                case 1:
                case 4:
                    costPerBox = 3.95;
                    break;
                case 2:
                    costPerBox = 2.95;
                    break;
                case 3:
                case 5:
                    costPerBox = 4.95;
            }
        } else {
            switch (cookieType) {
                case 1:
                    costPerBox = 3.55;
                    break;
                case 2:
                    costPerBox = 2.75;
                    break;
                case 3:
                    costPerBox = 4.55;
                    break;
                case 4:
                    costPerBox = 3.75;
                    break;
                case 5:
                    costPerBox = 4.75;
            }
        }
        
        //begin order summary output
        System.out.println("\nYOUR ORDER SUMMARY");

        //display now many boxes ordered and type ordered
        System.out.print("You ordered " + numberOfBoxes);

        //display appropriate single/multiple box grammar
        System.out.print((numberOfBoxes == 1 ? " box of " : " boxes of "));

        //display type name
        switch (cookieType) {
            case 1:
                System.out.println("Thin Mints.");
                break;
            case 2:
                System.out.println("Trefoils.");
                break;
            case 3:
                System.out.println("Samoas.");
                break;
            case 4:
                System.out.println("Tagalongs.");
                break;
            case 5:
                System.out.println("Do-si-dos.");
        }
        
        //display price per box
        System.out.println("The price per box is $" + costPerBox);

        //calculate and display the initial subtotal
        double subTotal = costPerBox * numberOfBoxes;
        System.out.println("The initial subtotal is $" + subTotal);
        
        //apply and display age discount if applicable
        if (age >= AGE_LIMIT) {
            System.out.println("You receive a 10% age discount.");
            subTotal -= subTotal * PERCENT_REDUCTION;
        }
        else {
            System.out.println("You do not qualify for the age discount.");
        }

        //display subtotal after age decision
        System.out.println("Your current subtotal is $" + subTotal);
        
        //calculate tax
        double tax = subTotal * SALES_TAX;

        //display sales tax
        System.out.println("The sales tax is $" + tax);
        
        //calculate total due
        double total = subTotal + tax;

        //display total due
        System.out.println("The total amount due is $" + total);

        //thank the user
        System.out.println("Thank you!");
    }
}
