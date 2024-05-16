import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {
    private static final List<Task> tasks = new ArrayList<>();
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    private String taskName;

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getDeveloperFirstName() {
        return developerFirstName;
    }

    public void setDeveloperFirstName(String developerFirstName) {
        this.developerFirstName = developerFirstName;
    }

    public String getDeveloperLastName() {
        return developerLastName;
    }

    public void setDeveloperLastName(String developerLastName) {
        this.developerLastName = developerLastName;
    }

    private int taskNumber;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    private String taskDescription;
    private String developerFirstName;
    private String developerLastName;

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    private int taskDuration;
    private String taskId;

    public String getTaskStatus() {
        return taskStatus;
    }
    public static List<Task> getTasks() {
        return tasks;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    private String taskStatus;

    public Task(String taskName, int taskNumber, String taskDescription, String developerFirstName, String developerLastName, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerFirstName = developerFirstName;
        this.developerLastName = developerLastName;
        this.taskDuration = taskDuration;
        this.taskId = generateTaskId(taskName, developerLastName);
        this.taskStatus = "To Do";
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
    protected static void addTask(Scanner userInput) {
        System.out.println("Enter task name:");
        String taskName = userInput.next();
        System.out.println("Enter task number:");
        int taskNumber = userInput.nextInt();
        System.out.println("Enter task description (max 50 characters):");
        String description = userInput.next();
        description = description.length() > 50 ? description.substring(0, 50) : description;
        System.out.println("Enter developer's first name:");
        String developerFirstName = userInput.next();
        System.out.println("Enter developer's last name:");
        String developerLastName = userInput.next();
        System.out.println("Enter task duration:");
        int taskDuration = userInput.nextInt();

        Task task = new Task(taskName, taskNumber, description, developerFirstName, developerLastName, taskDuration);
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private String generateTaskId(String taskName, String developerLastName) {
        return taskName.substring(0, 2) + ":" + developerLastName.substring(developerLastName.length() - 3);
    }





    public static void displayTaskDetails() {
        int totalHours = 0;

        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);

        for (Task task : tasks) {
            JOptionPane optionPane = new JOptionPane(task.display(), JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog(frame, "Task Details");
            dialog.setModal(true);
            dialog.setVisible(true);
            totalHours += task.getTaskDuration();
        }

        JOptionPane optionPane = new JOptionPane("Total Hours: " + totalHours, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(frame, "Total Hours");
        dialog.setModal(true);
        dialog.setVisible(true);
    }







}
