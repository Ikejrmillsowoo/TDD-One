package rocks.zipcode;

/** 
 * EXERCISE 2: BankAccount
 * 
 * Implement a BankAccount class that passes all the tests.
 * The class should handle deposits, withdrawals, and maintain a balance.
 */


// Student must implement this class
public class BankAccount {
    // TODO: Implement this class to make the tests pass
    String accountNumber = "";
    String ownerName = "";
    double accountBalance = 0.0;

    
    public BankAccount(String accountNumber, String ownerName, Double accountBalance) {
        // Your implementation here
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.accountBalance = accountBalance;
    }
    
    public String getAccountNumber() {
        // Your implementation here
        return this.accountNumber;
    }
    
    public String getOwnerName() {
        // Your implementation here
        return this.ownerName;
    }
    
    public double getBalance() {
        // Your implementation here
        return this.accountBalance;
    }
    
    public void deposit(double amount) {
        // Your implementation here
        if (amount >= 0) {
            this.accountBalance += amount;
        }else {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
    }
    
    public void withdraw(double amount) {
        // Your implementation here
        if (amount < this.accountBalance && amount >= 0) {
            this.accountBalance -= amount;
        }
        else if (amount <= 0){
            throw new IllegalArgumentException("Withdrawals amount must be positive");
        }
        else {
            throw new IllegalStateException("Insufficient funds");
        }
    }
}
