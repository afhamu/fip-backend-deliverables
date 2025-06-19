//custom exception
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Withdrawal failed: Insufficient funds. Available balance: ₦" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: ₦" + balance);
    }

   
    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

// Main class to test
// Note: The class is named 'Exceptions', so the file name should be 'Exceptions.java'

public class Exceptions {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Auwalu Falalu Hamza", 5000.0);

        System.out.println("Account holder: " + account.getAccountHolder());
        System.out.println("Current balance: ₦" + account.getBalance());

        try {
            System.out.println("\nAttempting to withdraw ₦7000...");
            account.withdraw(7000.0); // This will trigger the exception
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nAttempting to withdraw ₦3000...");
        try {
            account.withdraw(3000.0); // This should succeed
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nFinal balance: ₦" + account.getBalance());
    }
}

