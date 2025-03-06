package rocks.zipcode;
/** 
 * EXERCISE 1: StringUtils
 * 
 * Implement the StringUtils class to make all tests pass.
 * The class should have methods to:
 * - reverse a string
 * - count occurrences of a character in a string
 * - check if a string is a palindrome (ignoring case and non-alphanumeric characters)
 */

 // Student must implement this class
public class StringUtils {
    // TODO: Implement the following methods to make the tests pass
    
    public static String reverse(String str) {
        // Your implementation here
        StringBuilder sb = new StringBuilder(str);
        return String.valueOf(sb.reverse());
    }
    
    public static int countOccurrences(String str, char c) {
        // Your implementation here
        int count = 0;
        char[] arrToCount = str.toCharArray();
        for (int i = 0; i < arrToCount.length; i++) {
            if (arrToCount[i] == c) {
                count++;
            }
        }
        return count;
    }
    
    public static boolean isPalindrome(String str) {
        // Your implementation here
        // Note: Ignoring case and non-alphanumeric characters
        String newStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        StringBuilder sb = new StringBuilder(newStr);
        return newStr.equals(String.valueOf(sb.reverse()));
    }
}

