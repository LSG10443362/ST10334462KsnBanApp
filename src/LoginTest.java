import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    public void testCheckUserName() {
        Login login = new Login();
        boolean result = login.checkUserName();
        Assertions.assertTrue(result);
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        boolean result = login.checkPasswordComplexity();
        Assertions.assertTrue(result);
    }

    @Test
    public void testRegisterUser() {
        Login login = new Login();
        boolean isUserNameValid = login.checkUserName();
        boolean isPasswordComplex = login.checkPasswordComplexity();
        String result = login.registerUser(isUserNameValid, isPasswordComplex);
        Assertions.assertNotNull(result);
    }

    @Test
    public void testLoginUser() {
        Login login = new Login();
        boolean isUserNameValid = login.checkUserName();
        boolean isPasswordComplex = login.checkPasswordComplexity();
        login.registerUser(isUserNameValid, isPasswordComplex);
        boolean result = login.loginUser(login.registeredUsername, login.registeredPassword);
        Assertions.assertTrue(result);
    }
}