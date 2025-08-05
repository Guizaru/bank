
import java.util.Locale;
import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("=== WELCOME TO THE BANK===");
        System.out.println("=== PLEASE, SELECT A OPERATION ON THE MENU BELOW: ===");
        Account account = null;
        int option;
        do {
            //menu
            System.out.print(menu());
            option = sc.nextInt();
            switch (option) {
                case 1:
                    if (account != null) {
                        System.out.println("Account already exist. Please, select another operation from the menu.");
                        break;
                    }
                    account = createAccount(sc);
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                     deposit(sc, account);
                    break;
                case 3:
                    if (account == null) {
                        System.out.print("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                    withdraw(sc, account);
                    break;
                case 4:
                    if (account == null) {
                        System.out.print("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                    accountData(sc, account);
                    break;
                case 5:
                    System.out.print("Thank your for using our bank!");
                    System.exit(0);
            }
        } while (option != 0);
    }
    private static Account createAccount(Scanner sc) {
        //account number
        System.out.print("\nPlease, select 4 numbers to create a new account number. You cannot type more or less than for numbers: ");
        int accountNumber;
        String number;
        double balance = 0.0;
        do {
            accountNumber = sc.nextInt();
            number = String.valueOf(accountNumber);
            if (number.length() < 4) {
                System.out.print("Invalid. You need to type 4 numbers. Please, try again: ");
            }
            else if (number.length() > 4) {
                System.out.print("Invalid number. You cannot type more than 4 numbers. Please, try again: ");
            }
        } while (number.length() != 4);
        System.out.println("Proceeding...");
        sc.nextLine();
        //account name
        System.out.print("Please, enter your name: ");
        String accountName = sc.nextLine();
        //initial deposit
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
        System.out.print("\nWould you want to make a new operation? Please, enter y or n: ");
        answer = sc.next().charAt(0);
        while (true) {
            if (answer == 'y') {
                System.out.println("Proceeding to menu...");
                break;
            } else if (answer == 'n') {
                System.out.println("Thank your for using our bank!");
                System.exit(0);
            } else {
                System.out.print("Invalid answer, please enter y or n: ");
                answer = sc.next().charAt(0);
            }
        }
        return account;
    }
    private static void deposit(Scanner sc, Account account) {
        System.out.print("Enter deposit value: ");
        double newDeposit = sc.nextDouble();
        account.deposit(newDeposit);
        System.out.println("Updated account data:\n" + account);
        System.out.print("\nWould you like to make a new operation? Please, enter y or n: ");
        char answer = sc.next().charAt(0);
        while (true) {
            if (answer == 'y') {
                System.out.println("Proceeding to menu...");
                break;
            } else if (answer == 'n') {
                System.out.println("Thank your for using our bank!");
                System.exit(0);
            } else {
                System.out.print("Invalid answer, please enter y or n: ");
                answer = sc.next().charAt(0);
            }
        }
    }
    private static void withdraw(Scanner sc, Account account){
        // making a withdrawal
        System.out.print("Enter withdraw value: ");
        double newWithdraw = sc.nextDouble();
        account.withdraw(newWithdraw);
        System.out.print("Updated account data:\n" + account);
        System.out.print("\nWould you like to make a new operation? Please, enter y or n: ");
        char answer = sc.next().charAt(0);
        while (true) {
            if (answer == 'y') {
                System.out.println("Proceeding to menu...");
                break;
            } else if (answer == 'n') {
                System.out.println("Thank your for using our bank!");
                System.exit(0);
            } else {
                System.out.print("Invalid answer, please enter y or n: ");
                answer = sc.next().charAt(0);
            }
        }
    }
    private static void accountData(Scanner sc, Account account) {
        //shows Account data
        System.out.println(account);

        System.out.print("\nWould you want to make a new operation? Please, enter y or n: ");
        char answer = sc.next().charAt(0);
        while (true) {
            if (answer == 'y') {
                System.out.println("Proceeding to menu...");
                break;
            } else if (answer == 'n') {
                System.out.println("Thank your for using our bank!");
                System.exit(0);
            } else {
                System.out.println("Invalid answer, please enter y or n");
                answer = sc.next().charAt(0);
            }
        }
    }
    public static String menu() {
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
