// Import required classes and packages
import java.util.Scanner;

// Create ATMExample class to implement the ATM functionality
public class ATMExample {
    // Main method starts
    public static void main(String args[]) {
        // Declare and initialize balance, withdraw, and deposit
        int balance = 1000, withdraw, deposit, pin, attempts = 0;
        final int MAX_ATTEMPTS = 4;

        // Predefined PIN for authentication
        final int predefinedPIN = 2002;

        // Create scanner class object to get choice of user
        Scanner sc = new Scanner(System.in);

        // PIN authentication
        System.out.println("Welcome to the Automated Teller Machine!");
        System.out.println("Please enter your 4-digit PIN:");

        while (attempts < MAX_ATTEMPTS) {
            pin = sc.nextInt();

            if (pin == predefinedPIN) {
                System.out.println("PIN verified successfully.\n");
                break;
            } else {
                attempts++;
                if (attempts == MAX_ATTEMPTS) {
                    System.out.println("Maximum incorrect attempts reached. Access denied.");
                    System.exit(0);
                } else {
                    System.out.println("Incorrect PIN. Try again (" + (MAX_ATTEMPTS - attempts) + " attempts left):");
                }
            }
        }

        // ATM operations menu
        while (true) {
            System.out.println("Automated Teller Machine");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.print("Choose the operation you want to perform: ");

            // Get choice from user
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter money to be withdrawn: ");
                    // Get the withdrawal amount from user
                    withdraw = sc.nextInt();

                    // Check whether the balance is sufficient for the withdrawal amount
                    if (balance >= withdraw) {
                        balance -= withdraw; // Deduct the withdrawal amount from balance
                        System.out.println("Please collect your money.");
                    } else {
                        System.out.println("Insufficient Balance.");
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.print("Enter money to be deposited: ");
                    // Get the deposit amount from the user
                    deposit = sc.nextInt();

                    // Add the deposit amount to the total balance
                    balance += deposit;
                    System.out.println("Your Money has been successfully deposited.");
                    System.out.println("");
                    break;

                case 3:
                    // Display the total balance
                    System.out.println("Balance: " + balance);
                    System.out.println("");
                    break;

                case 4:
                    // Exit from the menu
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}