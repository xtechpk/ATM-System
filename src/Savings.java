public class Savings extends Account implements ATMTransaction {
    private double annualInterestRate;

    public Savings(String holderName, double accountBalance, double annualInterestRate, int pin) {
        super(holderName, accountBalance, pin);
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public void viewBalance() {
        System.out.println("Savings Account Balance: $" + accountBalance);
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
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Removed $" + amount + ". Updated Balance: $" + accountBalance);
        } else {
            System.out.println("Insufficient funds or invalid amount!");
        }
    }

    @Override
    public void showAccountDetails() {
        System.out.println("Savings Account Holder: " + holderName);
        System.out.println("Balance: $" + accountBalance);
        System.out.println("Interest Rate: " + annualInterestRate + "%");
    }
}
