
import java.util.Scanner;

public class RegisterUser {

    public static String registerPassword;
    public static String registerUsername;

    static Scanner registerUserInput = new Scanner(System.in);

    public static String setUsernameInput() {
        System.out.println("Please enter a username that contains an underscore and is no more than 5 characters in length.");
        return registerUserInput.nextLine();
    }

    public static boolean checkUsernameComplexity(String username) {
        if (username.length() > 5 || !username.contains("_")) {
            System.out.println("Username is not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters in length. \n User registration failed.");
            return false;
        } else {
            System.out.println("Username successfully captured.");
            registerUsername = username;
            return true;
        }
    }

    public static String registerUsername() {
        while (true) {
            String username = setUsernameInput();
            if (checkUsernameComplexity(username)) {
                return username;
            }
        }
    }
    public static String setPasswordInput() {
        System.out.println("Please enter a password that contains at least 8 characters, a capital letter, a number, and a special character.");
        return registerUserInput.nextLine();
    }
    public static boolean checkPasswordComplexity(String password) {
        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*") || !password.matches(".*[!@#$%^&*].*")) {
            System.out.println("Password is not correctly formatted, please ensure that the password is no more than 5 characters in length. \n User registration failed.");
            return false;
        } else {
            System.out.println("Password successfully captured.");
            registerPassword = password;
            return true;
        }
    }

        public static String registerUserPassword() {
            while (true) {
                String password = setPasswordInput();
                if (checkPasswordComplexity(password)) {
                    return password;
                }
            }
        }
}