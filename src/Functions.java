import java.util.Scanner;

public class Functions {
    static Account createAccount(Scanner sc) {
        System.out.print("\nPlease, select 4 numbers to create a new account number. You cannot type more or less than 4 numbers: ");
        int accountNumber;
        String number;
        double balance = 0.0;
        do {
            accountNumber = sc.nextInt();
            number = String.valueOf(accountNumber);
            if (number.length() < 4) {
                System.out.print("Invalid. You need to type 4 numbers. Please, try again: ");
            } else if (number.length() > 4) {
                System.out.print("Invalid number. You cannot type more than 4 numbers. Please, try again: ");
            }
        } while (number.length() != 4);
        System.out.println("Proceeding...");
        sc.nextLine();
        System.out.print("Please, enter your name: ");
        String accountName = sc.nextLine();
        System.out.print("Would you like to make an initial deposit? Type y or n: ");
        char answer = sc.next().charAt(0);
        while (true) {
            if (answer == 'y') {
                System.out.print("Enter the amount you would like to deposit: ");
                balance = sc.nextDouble();
                break;
            } else if (answer == 'n') {
                System.out.println("No initial deposit, proceeding data...");
                break;
            } else {
                System.out.println("Invalid answer. Please, enter y or n:");
                answer = sc.next().charAt(0);
            }
        }
        Account account = new Account(accountNumber, accountName, balance);
        System.out.println("Your account has been created successfully.");
        System.out.println("Account data: \n" + account);
        Functions.askContinue(sc);
        return account;
    }

    static void deposit(Scanner sc, Account account) {
        System.out.print("Enter deposit value: ");
        double newDeposit = sc.nextDouble();
        account.deposit(newDeposit);
        System.out.println("Updated account data:\n" + account);
        askContinue(sc);
    }

    static void withdraw(Scanner sc, Account account) {
        System.out.print("Enter withdraw value: ");
        double newWithdraw = sc.nextDouble();
        account.withdraw(newWithdraw);
        System.out.print("Updated account data:\n" + account);
        askContinue(sc);
    }

    static void accountData(Scanner sc, Account account) {
        System.out.println(account);
        askContinue(sc);
    }

    static void askContinue(Scanner sc) {
        System.out.print("\nWould you like to make a new operation? Please, enter y or n: ");
        char answer = sc.next().charAt(0);
        while (true) {
            if (answer == 'y') {
                System.out.println("Proceeding to menu...");
                break;
            } else if (answer == 'n') {
                System.out.println("Thank you for using our bank!");
                System.exit(0);
            } else {
                System.out.print("Invalid answer, please enter y or n: ");
                answer = sc.next().charAt(0);
            }
        }
    }
    static String menu() {
        return """
                
                === MENU ===
                1. Create account
                2. Make a deposit
                3. Make a withdraw
                4. Show account data
                5. Leave
                Select an option:\s""";
    }
}
