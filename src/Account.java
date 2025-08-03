public class Account {
    private final int accountNumber;
    private String name;
    private double balance;

    public Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double deposit){
        balance += deposit;
    }
    public void withdraw(double draw){
        balance -= draw + 5.00;
    }
    public String toString() {
        return "Account "+ accountNumber+ ","+
                " Holder: " + name + ","+
                " Balance: "+ "$ " +balance;
    }
}
