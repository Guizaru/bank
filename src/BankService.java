import java.util.Scanner;
public class BankService {
    static Account createAccount(Scanner sc) {
        System.out.println("\nPlease, select 4 numbers to create a new account number.");
        System.out.print("You cannot type more or less than 4 numbers: ");

        int accountNumber;
        String number;
        String password;
        double balance = 0.0;
        do {
            number = sc.nextLine();
            if (number.length() != 4) {
                System.out.print("Invalid length. Try again: ");
                continue;
            }
            if (!number.matches("\\d+")) {
                System.out.print("Only numbers allowed. Try again: ");
                continue;
            }
            accountNumber = Integer.parseInt(number);
            break;
        } while (true);
        System.out.println("Proceeding...");
        System.out.print("Please, enter your name: ");
        String accountName = sc.nextLine();
        //
        System.out.print("\nPlease, select 4 digits to create a new password: ");
        do {
            password = sc.nextLine();
            if (password.length() != 4) {
                System.out.print("Invalid length. Try again: ");
            } else if (!password.matches("\\d+")) {
                System.out.print("Only numbers allowed. Try again: ");
            }
            else{
                break;
            }
        } while (true);
        //
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
        Account account = new Account(accountNumber, accountName, balance, password);
        System.out.println("Your account has been created successfully.");
        System.out.println("Account data: \n" + account);
        BankService.askContinue(sc);
        return account;
    }
    static boolean authenticate(Scanner sc, Account account) {
        System.out.print("Enter your password: ");
        while (true) {
            String password = sc.nextLine();
            if (!account.validatePassword(password)) {
                System.out.print("Invalid password. Please, try again: ");
            } else {
                System.out.println("Proceeding...");
                return true;
            }
        }
    }
    static void deposit(Scanner sc, Account account) {
        if(!authenticate(sc,account)) return;

        System.out.print("Enter deposit value: ");
        double newDeposit = sc.nextDouble();
        account.deposit(newDeposit);
        System.out.println("Updated account data:\n" + account);
        askContinue(sc);
    }

    static void withdraw(Scanner sc, Account account) {
        if(!authenticate(sc,account)) return;

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
    static void options(Scanner sc){
        Account account = null;
        int option;
        do {
            System.out.print(BankService.menu());
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    if (account != null) {
                        System.out.println("Account already exist. Please, select another operation from the menu.");
                        break;
                    }
                    account = BankService.createAccount(sc);
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                    BankService.deposit(sc, account);
                    break;
                case 3:
                    if (account == null) {
                        System.out.print("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                    BankService.withdraw(sc, account);
                    break;
                case 4:
                    if (account == null) {
                        System.out.print("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                    BankService.accountData(sc, account);
                    break;
                case 5:
                    System.out.print("Thank your for using our bank!");
                    System.exit(0);
            }
        } while (option != 0);
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
