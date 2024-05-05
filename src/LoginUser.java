import java.util.Scanner;

public class LoginUser {
    static Scanner loginUserInput;

    static String username;
    static String password;

    public static void setUsernameInput() {
        if (loginUserInput != null) {
            System.out.println("Please enter your username.");
            username = loginUserInput.nextLine();
        }
    }

    public static void setUsernameInput(String usernameInput) {
        username = usernameInput;
    }

    public static void setPasswordInput() {
        if (loginUserInput != null) {
            System.out.println("Please enter your password.");
            password = loginUserInput.nextLine();
        }
    }

    public static void setPasswordInput(String passwordInput) {
        password = passwordInput;
    }

    public static boolean checkUsernameMatch(String loginUsername) {
        return loginUsername.equals(RegisterUser.registerUsername);
    }

    public static boolean checkPasswordMatch(String loginPassword) {
        return loginPassword.equals(RegisterUser.registerPassword);
    }

    public static String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Login successful.";
        } else {
            return "Login failed. Please try again.";
        }
    }

    public static boolean login() {
        loginUserInput = new Scanner(System.in);
        boolean loginSuccess = false;
        while (!loginSuccess) {
            setUsernameInput();
            setPasswordInput();
            boolean usernameMatch = checkUsernameMatch(username);
            boolean passwordMatch = checkPasswordMatch(password);
            loginSuccess = usernameMatch && passwordMatch;
            System.out.println(returnLoginStatus(loginSuccess));
        }
        loginUserInput.close();
        return loginSuccess;
    }
}