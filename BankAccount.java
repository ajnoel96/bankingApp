import java.util.Scanner;

public class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    void deposit(int amount) {
        if(amount > 0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount > 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

     void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        }

        else if (previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        }

        else {
            System.out.println("No transaction occured");
        }
    }

    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is" + customerId + "\n");
        System.out.println("A. Check Balance\n" +
                "B. Deposit\n" +
                "C. Withdraw\n" +
                "D. Previous transaction\n" +
                "E. Exit\n");

        do {
            System.out.println("Enter an option: ");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option) {

                case 'A':
                    System.out.println("Balance = " + balance + "\n");
                    break;

                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 'D':
                    getPreviousTransaction();
                    System.out.println("\n");
                    break;

                case 'E':
                    break;

                default:
                    System.out.println("Invalid Option; please reselect.");
            }
        }
        while (option != 'E');
        System.out.println("Thank you for using our services");
    }
}
