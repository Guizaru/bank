
public class Account {
    private final int accountNumber;
    private String password;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double balance, String password) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return accountNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public boolean validatePassword(String inputPassword){
        return this.password.equals(inputPassword);
    }
    public boolean changePassword(String oldPassword, String newPassword) {
        if (validatePassword(oldPassword)) {
            this.password = newPassword;
            return true;
        }
        return false;
    }
    public void deposit(double deposit){
        if (deposit <= 0){
            System.out.println("Invalid value!");
            return;
        }
        balance += deposit;
    }
    public void withdraw(double draw){
        if (draw <= 0){
            System.out.println("Invalid value!");
            return;
        }
        double totalToWithdraw = draw + 5.00;
        if (totalToWithdraw > balance){
            System.out.println("Insufficient funds.");
            return;
        }
        balance -= totalToWithdraw;
    }
    public String toString() {
        return "Account number: "+ accountNumber+ " |"+
                " Holder: " + name + " |"+
                String.format(" Balance: $ %.2f", balance);
    }
}
