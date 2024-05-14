import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class KanBan {
    private static final List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the KanBan App");
        Scanner userInput = new Scanner(System.in);

        /*System.out.println("Please Enter Your First Name");
        String firstName = userInput.nextLine();
        System.out.println("Please Enter Your Last Name");
        String lastName = userInput.nextLine();

        RegisterUser.registerUsername();
        RegisterUser.registerUserPassword();


        boolean loginSuccess;
        do {
            loginSuccess = LoginUser.login();
            if (!loginSuccess) {
                System.out.println("Login failed. Please try again.");
            }
        } while (!loginSuccess);
        System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");*/
        boolean  loginSuccess = true;

        if (loginSuccess) {
            boolean quit = false;
            while (!quit) {
                System.out.println("1. Add task\n2. Display task details\n3. Quit application");
                int choice = userInput.nextInt();
                userInput.nextLine();
                switch (choice) {
                    case 1:
                        Task.addTask(userInput);
                        break;
                    case 2:
                        if (Task.getTasks().isEmpty()) {
                            System.out.println("No tasks to display.");
                        } else {
                            Task.displayTaskDetails();
                        }
                        break;
                    case 3:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }


}
/*References listed below

Farrell, J. (2019). Java Programming 9th Edition. Cengage Learning.

OpenAI. (2024). ChatGPT (Dec 20 version) [Large language model]. https://chat.openai.com*/
