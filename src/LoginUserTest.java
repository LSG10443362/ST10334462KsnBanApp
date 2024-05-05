import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class LoginUserTest {
    @Test
    public void testLoginUsernameFalse() {
        String username = "kyle!!!!";
        RegisterUser.registerUsername = username;
        String expectedMessage = "Username is incorrect, please try again.";
        String actualMessage = LoginUser.loginUsername();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
     @Test
        public void testLoginUsernameTrue() {
            String username = "kyl_1";
            RegisterUser.registerUsername = username;
            String expectedMessage = "Username matches.";
            String actualMessage = LoginUser.loginUsername();
            Assertions.assertEquals(expectedMessage, actualMessage);
        }
}
