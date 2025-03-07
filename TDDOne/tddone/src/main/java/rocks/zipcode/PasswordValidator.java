package rocks.zipcode;

/**
 * EXERCISE 5: PasswordValidator
 * 
 * The PasswordValidator class is implemented, and students need to write tests for it.
 * Your tests should verify that the validation rules work correctly.
 */

// The implementation (already written)
public class PasswordValidator {
    private static final int MIN_LENGTH = 8;
    private static final int MAX_LENGTH = 20;
    
    public boolean isValid(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }
        
        // Check length
        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH) {
            return false;
        }
        
        // Check for at least one uppercase letter
        if (!containsUppercase(password)) {
            return false;
        }

        // Check for at least one lowercase letter
        if (!containsLowercase(password)) {
            return false;
        }
        
        // Check for at least one digit
        if (!containsDigit(password)) {
            return false;
        }
        
        // Check for at least one special character
        return containsSpecialChar(password);
    }
    
    private boolean containsUppercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean containsLowercase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean containsSpecialChar(String password) {
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";
        for (char c : password.toCharArray()) {
            if (specialChars.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
