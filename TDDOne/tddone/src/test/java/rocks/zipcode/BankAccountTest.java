package rocks.zipcode;
// The test class (already written)
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    
    @BeforeEach
    void setUp() {
        account = new BankAccount("12345", "John Doe", 0.0);//Isaac added balance for the test.
    }
    
    @Test
    void testNewAccountHasZeroBalance() {
        assertEquals(0.0, account.getBalance());
        assertEquals("12345", account.getAccountNumber());
        assertEquals("John Doe", account.getOwnerName());
    }
    
    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance());
        
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }
    
    @Test
    void testDepositNegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50.0);
        });
        
        String expectedMessage = "Deposit amount must be positive";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(0.0, account.getBalance()); // Balance should remain unchanged
    }
    
    @Test
    void testWithdraw() {
        account.deposit(100.0);
        account.withdraw(40.0);
        assertEquals(60.0, account.getBalance());
    }
    
    @Test
    void testWithdrawInsufficientFunds() {
        account.deposit(100.0);
        
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            account.withdraw(150.0);
        });
        
        String expectedMessage = "Insufficient funds";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(100.0, account.getBalance()); // Balance should remain unchanged
    }
    
    @Test
    void testWithdrawNegativeAmount() {
        account.deposit(100.0);
        
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50.0);
        });
        
        String expectedMessage = "Withdrawals amount must be positive";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(100.0, account.getBalance()); // Balance should remain unchanged
    }
}
