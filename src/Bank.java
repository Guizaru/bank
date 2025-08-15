
import java.util.Locale;
import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("=== WELCOME TO THE BANK===");
        System.out.println("=== PLEASE, SELECT AN OPERATION ON THE MENU BELOW: ===");
        BankService.options(sc);
    }
}
