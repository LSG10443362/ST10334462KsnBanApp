import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class RegisterUserTest {

    @Test
    public void testUsernameFormatFalse() {
        String username = "kyle!!!!!!!!";
        RegisterUser.registerUsername = username;
        String expectedMessage = "Username is not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters in length. \n User registration failed.";
        String actualMessage = RegisterUser.registerUsername();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testUsernameFormatTrue() {
        String firstName = "Kyle";
        String lastName = "Smith";
        String username = "kyl_1";
        RegisterUser.registerUsername = username;
        String expectedMessage = "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        String actualMessage = "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testPasswordFormatTrue() {
        String password = "Ch&&sec@ke99!";
        RegisterUser.registerPassword = password;
        String expectedMessage = "Password successfully captured.";
        String actualMessage = RegisterUser.registerUserPassword();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void testPasswordFormatFalse() {
        String password = "password";
        RegisterUser.registerPassword = password;
        String expectedMessage = "Password is not correctly formatted, please ensure that the password is no more than 5 characters in length. \n User registration failed.";
        String actualMessage = RegisterUser.registerUserPassword();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

}
