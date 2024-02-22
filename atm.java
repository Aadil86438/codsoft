import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public boolean withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. New balance: " + account.checkBalance());
            return true;
        } else {
            System.out.println("Withdrawal failed. Please check your balance and try again.");
            return false;
        }
    }

    public boolean deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.println("Deposit successful. New balance: " + account.checkBalance());
            return true;
        } else {
            System.out.println("Deposit failed. Please deposit a valid amount.");
            return false;
        }
    }

    public void checkBalance() {
        System.out.println("Your balance is: " + account.checkBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance $1000
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to codsoft ATM!");

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("ENTER YOUR CHOICE: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ENTER AMOUNT TO WITHDRAW: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("ENTER AMOUNT TO DEPOSIT: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }
}
