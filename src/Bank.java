
import java.util.Locale;
import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("=== WELCOME TO THE BANK===");
        System.out.println("=== PLEASE, SELECT AN OPERATION ON THE MENU BELOW: ===");
        Account account = null;
        int option;
        do {
            System.out.print(Functions.menu());
            option = sc.nextInt();
            switch (option) {
                case 1:
                    if (account != null) {
                        System.out.println("Account already exist. Please, select another operation from the menu.");
                        break;
                    }
                    account = Functions.createAccount(sc);
                    break;

                case 2:
                    if (account == null) {
                        System.out.println("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                    Functions.deposit(sc, account);
                    break;
                case 3:
                    if (account == null) {
                        System.out.print("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                    Functions.withdraw(sc, account);
                    break;
                case 4:
                    if (account == null) {
                        System.out.print("No account found. You need to create an account to proceed. Please, select operation 1 on the menu.");
                        break;
                    }
                    Functions.accountData(sc, account);
                    break;
                case 5:
                    System.out.print("Thank your for using our bank!");
                    System.exit(0);
            }
        } while (option != 0);
    }
}
