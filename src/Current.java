public class Current extends Account implements ATMTransaction {
    private double overdraftCap;

    public Current(String holderName, double accountBalance, double overdraftCap, int pin) {
        super(holderName, accountBalance, pin);
        this.overdraftCap = overdraftCap;
    }

    @Override
    public void viewBalance() {
        System.out.println("Current Account Balance: $" + accountBalance);
    }

    @Override
    public void addFunds(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Added $" + amount + ". Updated Balance: $" + accountBalance);
        } else {
            System.out.println("Invalid amount to add!");
        }
    }

    @Override
    public void removeFunds(double amount) {
        if (amount > 0 && amount <= (accountBalance + overdraftCap)) {
            accountBalance -= amount;
            System.out.println("Removed $" + amount + ". Updated Balance: $" + accountBalance);
        } else {
            System.out.println("Overdraft limit exceeded or invalid amount!");
        }
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Current Account Holder: " + holderName);
        System.out.println("Balance: $" + accountBalance);
        System.out.println("Overdraft Limit: $" + overdraftCap);
    }
}
