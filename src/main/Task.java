package main;

import javax.swing.*;
import java.util.Scanner;

public class Task {
    private static Task[] tasks;
    private static int taskNumber = 0;

    private String taskName;
    private int taskDuration;
    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;
    private String taskId;
    private String taskStatus;

    public static void initializeTasks(int maxTasks) {
        tasks = new Task[maxTasks];
    }

    public static Task[] getTasks() {
        return tasks;
    }

    public String getTaskName() {
        return taskName;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    public String getDeveloperLastName() {
        return developerLastName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public static boolean checkTaskNameComplexity(String taskName) {
        return taskName.length() <= 50 && taskName.matches("^[a-zA-Z0-9_]*$");
    }

    public static boolean checkTaskDescriptionComplexity(String taskDescription) {
        return taskDescription.length() <= 200;
    }

    public static boolean checkDeveloperNameComplexity(String developerFirstName, String developerLastName) {
        return developerFirstName.length() <= 50 && developerLastName.length() <= 50 &&
                developerFirstName.matches("^[a-zA-Z]*$") && developerLastName.matches("^[a-zA-Z]*$");
    }

    public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = taskNumber + 1;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskId = generateTaskId(taskName, developerLastName);
        this.taskStatus = "To Do";
    }

    private String generateTaskId(String taskName, String developerLastName) {
        String firstTwoLettersOfTaskName = taskName.substring(0, 2).toUpperCase();
        String lastThreeLettersOfDeveloperName = developerLastName.length() >= 3 ?
                developerLastName.substring(developerLastName.length() - 3).toUpperCase() : developerLastName.toUpperCase();
        return firstTwoLettersOfTaskName + ":" + this.taskNumber + ":" + lastThreeLettersOfDeveloperName;
    }

    public static void addTask(Scanner userInput) {
        if (taskNumber >= tasks.length) {
            System.out.println("Task list is full. Cannot add more tasks.");
            return;
        }
        System.out.println("Enter task name:");
        String taskName = userInput.next();
        if (!checkTaskNameComplexity(taskName)) {
            System.out.println("Task name is not correctly formatted. Task creation failed.");
            return;
        }

        System.out.println("Enter task description (max 200 characters):");
        String description = userInput.next();
        if (!checkTaskDescriptionComplexity(description)) {
            System.out.println("Task description is not correctly formatted. Task creation failed.");
            return;
        }

        System.out.println("Enter developer's first name:");
        String developerFirstName = userInput.next();
        System.out.println("Enter developer's last name:");
        String developerLastName = userInput.next();
        if (!checkDeveloperNameComplexity(developerFirstName, developerLastName)) {
            System.out.println("Developer name is not correctly formatted. Task creation failed.");
            return;
        }

        System.out.println("Enter task duration:");
        int taskDuration = userInput.nextInt();

        Task task = new Task(taskName, taskNumber, description, developerFirstName, developerLastName, taskDuration);
        tasks[taskNumber] = task;
        taskNumber++;
        System.out.println("Task added successfully.");
    }

    public String display() {
        return "Task Name: " + taskName + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Developer: " + developerFirstName + " " + developerLastName + "\n" +
                "Task Duration: " + taskDuration + "\n" +
                "Task ID: " + taskId + "\n" +
                "Task Status: " + taskStatus;
    }

    public static void displayTaskDetails() {
        int totalHours = 0;

        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        for (Task task : tasks) {
            JOptionPane optionPane = new JOptionPane(task.display(), JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog(frame, "Task Details");
            dialog.setModal(true);//OpenAI. (2024)
            dialog.setVisible(true);//OpenAI. (2024)
            totalHours += task.getTaskDuration();
        }

        JOptionPane optionPane = new JOptionPane("Total Hours: " + totalHours, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(frame, "Total Hours");//OpenAI. (2024)
        dialog.setModal(true);//OpenAI. (2024)
        dialog.setVisible(true);//OpenAI. (2024)
    }
}
/*Reference List
OpenAI. (2024). ChatGPT (Version GPT-4) [Large language model]. Available at: https://www.openai.com/chatgpt [Accessed: 30 May 2024]

 */