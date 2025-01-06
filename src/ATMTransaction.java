public interface ATMTransaction {
    void viewBalance();
    void addFunds(double amount);
    void removeFunds(double amount);
}
