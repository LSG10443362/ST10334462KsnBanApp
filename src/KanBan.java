import java.util.Scanner;

public class KanBan {

    public static void main(String[] args) {
        System.out.println("Welcome to the KanBan App");
        Scanner userInput = new Scanner(System.in);

        System.out.println("Please Enter Your First Name");
        String firstName = userInput.nextLine();
        System.out.println("Please Enter Your Last Name");
        String lastName = userInput.nextLine();
        RegisterUser kanBan = new RegisterUser();
        kanBan.registerUsername();
        kanBan.registerUserPassword();
        LoginUser login = new LoginUser();
        login.loginUsername();
        login.loginPassword();
        System.out.println("Welcome " + firstName + " " + lastName + "it is great to see you again.") ;
    }
}

