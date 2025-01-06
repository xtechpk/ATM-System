import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<RegisteredUser> registeredUsers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Register User");
            System.out.println("2. Access ATM");
            System.out.println("3. View Registered Users");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    accessATM(scanner);
                    break;
                case 3:
                    viewRegisteredUsers();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner) {
        scanner.nextLine(); // Consume newline

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.println("Choose Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your choice: ");
        int accountChoice = scanner.nextInt();

        System.out.print("Set an initial PIN: ");
        int pin = scanner.nextInt();

        Account account;
        if (accountChoice == 1) {
            account = new Savings(username, 0.0, 3.5, pin);
        } else if (accountChoice == 2) {
            account = new Current(username, 0.0, 200.0, pin);
        } else {
            System.out.println("Invalid choice! Registration failed.");
            return;
        }

        RegisteredUser newUser = new RegisteredUser(username, email, account);
        registeredUsers.add(newUser);
        System.out.println("User registered successfully!");
        System.out.println("Generated Account Number: " + newUser.getAccountNumber());
    }

    private static void accessATM(Scanner scanner) {
        scanner.nextLine(); // Consume newline

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        RegisteredUser user = registeredUsers.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElse(null);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }

        Account account = user.getAccount();

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (!account.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN! Access Denied.");
            return;
        }

        ATMTransaction transaction = (ATMTransaction) account;

        System.out.println("\nChoose an Action:");
        System.out.println("1. View Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Update PIN");
        System.out.print("Enter your choice: ");
        int actionChoice = scanner.nextInt();

        switch (actionChoice) {
            case 1:
                transaction.viewBalance();
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                transaction.addFunds(depositAmount);
                break;
            case 3:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                transaction.removeFunds(withdrawAmount);
                break;
            case 4:
                System.out.print("Enter old PIN: ");
                int oldPin = scanner.nextInt();
                System.out.print("Enter new PIN: ");
                int newPin = scanner.nextInt();
                account.updatePin(oldPin, newPin);
                break;
            default:
                System.out.println("Invalid action! Try again.");
        }
    }

    private static void viewRegisteredUsers() {
        if (registeredUsers.isEmpty()) {
            System.out.println("No registered users found.");
            return;
        }

        System.out.println("\nRegistered Users:");
        for (RegisteredUser user : registeredUsers) {
            user.displayDetails();
            System.out.println();
        }
    }
}