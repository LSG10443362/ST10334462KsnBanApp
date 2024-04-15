
import java.util.Scanner;

public class RegisterUser {

    public static String registerPassword;
    public static String registerUsername;

    static Scanner registerUserInput = new Scanner(System.in);

    public static String registerUsername() {
        while (true) {
            System.out.println("Please enter a username that contains an underscore and is no more than 5 characters in length.");
            String username = registerUserInput.nextLine();

            if (username.length() > 5 || !username.contains("_")) {
                System.out.println("Username is not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters in length. \n User registration failed.");
            } else {
                System.out.println("Username successfully captured.");
                registerUsername = username;
                return username;
            }
        }
    }
    public static String registerUserPassword() {
        while (true) {
            System.out.println("Please enter a password that contains at least 8 characters, a capital letter, a number, and a special character.");
            String password = registerUserInput.nextLine();

            if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*") || !password.matches(".*[!@#$%^&*].*"))/*(OpenAI, 2020)*/{
                System.out.println("Password is not correctly formatted, please ensure that the password is no more than 5 characters in length. \n User registration failed.");
            } else {
                System.out.println("Password successfully captured.");
                registerPassword = password;
                return password;
            }
        }
    }
}