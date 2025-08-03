import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //Initial message
        System.out.println("Welcome to the Gordura Bank!");

        //account number
        int accountNumber;
        String number;
        System.out.println("Please, enter the number of your account:");
        do {
            accountNumber = sc.nextInt();
            number = String.valueOf(accountNumber);
            if (number.length() != 4) {
                System.out.println("Please, type at least 4 numbers.");
            }
        } while (number.length() != 4);
        System.out.println("Proceeding...");
        sc.nextLine();

        //account name
        System.out.println("Please, enter your name:");
        String accountName = sc.nextLine();

        //initial deposit
        System.out.println("Is there an initial deposit? (y/n)");
        char answer = sc.next().charAt(0);
        double balance = 0.0;
        while (true) {
            if (answer == 'y') {
                System.out.println("Enter initial deposit value:");
                balance = sc.nextDouble();
                break;
            } else if (answer == 'n') {
                System.out.println("No initial deposit, proceeding data...");
                break;
            } else {
                System.out.println("Invalid answer, please enter y or n");
                answer = sc.next().charAt(0);
            }
        }
        //making a new deposit
        Account account = new Account(accountNumber, accountName, balance);
        System.out.println("Account data:\n" + account);
        //deposit
        System.out.println("Do you want to make a new deposit? (y/n)");
        answer = sc.next().charAt(0);
        while (true) {
            if (answer == 'y') {
                System.out.println("Enter deposit value:");
                double newDeposit = sc.nextDouble();
                account.deposit(newDeposit);
                System.out.println("Updated account data:\n" + account);
                break;
            } else if (answer == 'n') {
                System.out.println("Your current balance is: " + balance);
                break;
            } else {
                System.out.println("Invalid answer, please enter y or n");
                answer = sc.next().charAt(0);
            }
        }

        // making a withdraw
        System.out.println("Do you want to make a withdraw? (y/n)");
        answer = sc.next().charAt(0);
        while (true) {
            if (answer == 'y') {
                System.out.println("Enter withdraw value:");
                double newWithdraw= sc.nextDouble();
                account.withdraw(newWithdraw);
                System.out.println("Updated account data:\n" + account);
                break;
            } else if (answer == 'n') {
                System.out.println("Your current balance is: " + balance);
                break;
            } else {
                System.out.println("Invalid answer, please enter y or n");
                answer = sc.next().charAt(0);
            }
        }
        sc.close();
    }
}
