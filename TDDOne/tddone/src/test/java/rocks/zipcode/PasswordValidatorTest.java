package rocks.zipcode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


// Student should write this test class
public class PasswordValidatorTest {
    // TODO: Write tests for the PasswordValidator class
    private int MAX_LENGTH;
    private int MIN_LENGTH;
    PasswordValidator pass = new PasswordValidator();

    @BeforeEach
    void setUP() {
      // password.isValid("semicolon");
    }
    // Test cases should include:
    // - Valid passwords

    @Test
    void test1IsValid(){

        String password = "";
        assertFalse(pass.isValid(password));
    }

    @Test
    void test2IsValid(){

        String password = " masterfield12@";
        assertFalse(pass.isValid(password));
    }

    @Test
    void test3IsValid(){

        String password = " MASTERFIELD12@";
        assertFalse(pass.isValid(password));
    }

    @Test
    void test4IsValid(){

        String password = " MasterField@";
        assertFalse(pass.isValid(password));
    }
    @Test
    void test5IsValid(){

        String password = " MasterField12@";
        assertTrue(pass.isValid(password));
    }
//   - Passwords that includes upper cases;
    @Test
    void testContainsUppercase(){
        String password = "andy12camel12}";
        assertFalse(pass.isValid(password));
    }

    @Test
    void test1ContainsUppercase(){
        String password = " Andy12Camel12}";
        assertTrue(pass.isValid(password));
    }
    // - Passwords that are too short or too long

    @Test
    void test6IsValid(){
        String password = " andy12Camel12}kiusdhjfksdhkjfasknjfdanskjdaskjdnksajndkadksjandakjdakdjndkajshdknkdqejadisjakjas";
        assertFalse(pass.isValid(password));
        //pass.
    }

    @Test
    void test7IsValid(){
        String password = "hh";
        assertFalse(pass.isValid(password));
        //pass.
    }
    // - Passwords missing uppercase, lowercase, digits, or special chars
    // - Edge cases like null or empty strings
}
