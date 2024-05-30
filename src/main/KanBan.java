package main;

import main.Task;

import java.util.Scanner;


public class KanBan {


    public static void main(String[] args) {
        System.out.println("Welcome to the main.KanBan App");
        Scanner userInput = new Scanner(System.in);

        /*System.out.println("Please Enter Your First Name");
        String firstName = userInput.nextLine();
        System.out.println("Please Enter Your Last Name");
        String lastName = userInput.nextLine();

        main.RegisterUser.registerUsername();
        main.RegisterUser.registerUserPassword();


        boolean loginSuccess;
        do {
            loginSuccess = main.LoginUser.login();
            if (!loginSuccess) {
                System.out.println("Login failed. Please try again.");
            }
        } while (!loginSuccess);
        System.out.println("Welcome " + firstName + " " + lastName + ", it is great to see you again.");*/
        boolean  loginSuccess = true;

        if (loginSuccess) {
            boolean quit = false;

            System.out.println("Please enter the maximum number of tasks:");
            int maxTasks = userInput.nextInt();
            userInput.nextLine(); // consume newline

            // Initialize tasks array in main.Task class
            Task.initializeTasks(maxTasks);
            while (!quit) {
                System.out.println("1. Add task\n2. Display task details\n3. Quit application\n4. Show Report");
                int choice = userInput.nextInt();
                userInput.nextLine();
                switch (choice) {
                    case 1:
                        Task.addTask(userInput);
                        break;
                    case 2:
                        if (Task.getTasks().length == 0) {
                            System.out.println("No tasks to display.");
                        } else {
                            Task.displayTaskDetails();
                        }
                        break;
                    case 3:
                        quit = true;
                        break;
                    case 4:
                        System.out.println("Coming Soon");
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
