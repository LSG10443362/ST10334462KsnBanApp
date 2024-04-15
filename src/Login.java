import java.util.Scanner;

public class Login{
    public String firstName;
    public String lastName;
    public String registeredUsername;
    public String registeredPassword;
    public String loginUsername;
    public String loginPassword;


    public String promptFirstName() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your first name:");
        String firstName = userInput.nextLine();
        return firstName;
    }


    public String promptLastName() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your last name:");
        String lastName = userInput.nextLine();
        return lastName;
    }
    public boolean checkUserName() {
        Scanner UserInput = new Scanner(System.in);

            System.out.println("Please enter a username that contains no more than characters and must have an underscore.");
            String registeredUsername = UserInput.nextLine();
            return registeredUsername.length() < 5 && !registeredUsername.contains("_");


    }
    public boolean checkPasswordComplexity() {
        Scanner UserInput = new Scanner(System.in);

        System.out.println("Please enter a password that contains at least 8 characters, a capital letter, a number and a special character.");
        String registeredPassword = UserInput.nextLine();
        return registeredPassword.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}");
    }
    public String registerUser(boolean checkUserName, boolean checkPasswordComplexity) {
        if (checkUserName && checkPasswordComplexity) {
            return "User successfully captured.\nUser password successfully captured.";
        } else if (checkUserName && !checkPasswordComplexity) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character. \n User registration failed.");

        } else if (!checkUserName && checkPasswordComplexity) {
            System.out.println("Username is not correctly formatted, please ensure that the username contains an underscore and is no more than 5 characters in length. \n User registration failed.");

        }
        else if (!checkUserName && !checkPasswordComplexity) {
            System.out.println(" Both your username and password is not correctly formatted, please ensure that the you have meet the required complexity \n User registration failed.");
        }
        return null;
    }

    Scanner loginUserInput = new Scanner(System.in);

    public boolean loginUser(String registeredUsername, String registeredPassword) {
        while (true) {
            System.out.println("Please enter your username.");
            String loginUsername = loginUserInput.nextLine();

            System.out.println("Please enter your Password.");
            String loginPassword = loginUserInput.nextLine();
            return loginUsername.equals(registeredUsername) && loginPassword.equals(registeredPassword);

    }
    }
    public String returnLoginStatus(boolean loginUser) {
        if (loginUser) {
            return "User successfully logged in." + "\n" + "Welcome " + firstName + ", " + lastName + "it is great to see you again.";
        } else {
            return "User login failed."+ "\n" + "Username or Password incorrect, please try again.";
        }
    }
}



