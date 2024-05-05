import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class LoginUserTest {
    @Test
    public void testSetUsernameInput() {
        String expectedUsername = "kyl_1";
        LoginUser.setUsernameInput(expectedUsername);
        String actualUsername = LoginUser.username;
        Assertions.assertEquals(expectedUsername, actualUsername);
    }

    @Test
    public void testCheckUsernameMatchTrue() {
        String username = "kyl_1";
        RegisterUser.registerUsername = username;
        boolean actual = LoginUser.checkUsernameMatch(username);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCheckUsernameMatchFalse() {
        String username = "kyle!!!!";
        RegisterUser.registerUsername = "kyl_1";
        boolean actual = LoginUser.checkUsernameMatch(username);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testSetPasswordInput() {
        String expectedPassword = "correctPassword";
        LoginUser.setPasswordInput(expectedPassword);
        String actualPassword = LoginUser.password;
        Assertions.assertEquals(expectedPassword, actualPassword);
    }

    @Test
    public void testCheckPasswordMatchTrue() {
        String password = "correctPassword";
        RegisterUser.registerPassword = password;
        boolean actual = LoginUser.checkPasswordMatch(password);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCheckPasswordMatchFalse() {
        String password = "wrongPassword";
        RegisterUser.registerPassword = "correctPassword";
        boolean actual = LoginUser.checkPasswordMatch(password);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testReturnLoginStatusTrue() {
        String expectedMessage = "Login successful.";
        String actualMessage = LoginUser.returnLoginStatus(true);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testReturnLoginStatusFalse() {
        String expectedMessage = "Login failed. Please try again.";
        String actualMessage = LoginUser.returnLoginStatus(false);
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testLoginTrue() {
        String username = "kyl_1";
        String password = "correctPassword";
        RegisterUser.registerUsername = username;
        RegisterUser.registerPassword = password;
        String simulatedUserInput = username + System.lineSeparator() + password + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        boolean expected = true;
        boolean actual = LoginUser.login();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testLoginFalse() {
        String username = "kyle!!!!";
        String password = "wrongPassword";
        RegisterUser.registerUsername = "kyl_1";
        RegisterUser.registerPassword = "correctPassword";
        String simulatedUserInput = username + System.lineSeparator() + password + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        boolean expected = false;
        boolean actual = LoginUser.login();
        Assertions.assertEquals(expected, actual);
    }
}