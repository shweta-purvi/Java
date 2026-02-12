import java.util.Scanner;

abstract class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

public class SimpleBankSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavingsAccount myAccount = new SavingsAccount(500.00); // Initial balance
        boolean running = true;

        System.out.println("Welcome to Simple Bank System");

        while (running) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next(); // Clear invalid input
            }

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + myAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    if (scanner.hasNextDouble()) {
                        myAccount.deposit(scanner.nextDouble());
                    } else {
                        System.out.println("Invalid amount.");
                        scanner.next();
                    }
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    if (scanner.hasNextDouble()) {
                        myAccount.withdraw(scanner.nextDouble());
                    } else {
                        System.out.println("Invalid amount.");
                        scanner.next();
                    }
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
