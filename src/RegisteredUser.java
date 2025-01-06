public class RegisteredUser {
    private static int accountCounter = 1000;   

    private String username;
    private String email;
    private Account account;
    private final int accountNumber; 

    public RegisteredUser(String username, String email, Account account) {
        this.username = username;
        this.email = email;
        this.account = account;
        this.accountNumber = accountCounter++; 
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Account getAccount() {
        return account;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void displayDetails() {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Account Number: " + accountNumber);
        account.showAccountDetails();
    }
}
