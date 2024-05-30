package test.java;

import main.RegisterUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class RegisterUserTest {

    @Test
    public void testCheckUsernameComplexityFalse() {
        String username = "kyle!!!!!!!!";
        boolean actual = RegisterUser.checkUsernameComplexity(username);
        Assertions.assertFalse(actual);
    }

    @Test
    public void testCheckUsernameComplexityTrue() {
        String username = "kyl_1";
        boolean actual = RegisterUser.checkUsernameComplexity(username);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCheckPasswordComplexityTrue() {
        String password = "Ch&&sec@ke99!";
        boolean actual = RegisterUser.checkPasswordComplexity(password);
        Assertions.assertTrue(actual);
    }

    @Test
    public void testCheckPasswordComplexityFalse() {
        String password = "password";
        boolean actual = RegisterUser.checkPasswordComplexity(password);
        Assertions.assertFalse(actual);
    }
}