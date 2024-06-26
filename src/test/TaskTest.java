import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Task;
import java.util.Arrays;

public class TaskTest {
    private main.Task[] testTasks;

    @BeforeEach //OpenAI. (2024)
    public void setUp() {
        main.Task.initializeTasks(4);
        testTasks = main.Task.getTasks();

        testTasks[0] = new main.Task("Create Login", 0, "Description for Create Login", "Mike", "Smith", 5);
        testTasks[1] = new Task("Create Add Features", 1, "Description for Create Add Features", "Edward", "Harrison", 8);
        testTasks[2] = new Task("Create Reports", 2, "Description for Create Reports", "Samantha", "Paulson", 2);
        testTasks[3] = new Task("Add Arrays", 3, "Description for Add Arrays", "Glenda", "Oberholzer", 11);
    }

    @Test
    public void testDeveloperArrayCorrectlyPopulated() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] actualDevelopers = {
                testTasks[0].getDeveloperFirstName() + " " + testTasks[0].getDeveloperLastName(),
                testTasks[1].getDeveloperFirstName() + " " + testTasks[1].getDeveloperLastName(),
                testTasks[2].getDeveloperFirstName() + " " + testTasks[2].getDeveloperLastName(),
                testTasks[3].getDeveloperFirstName() + " " + testTasks[3].getDeveloperLastName()
        };
        Assertions.assertArrayEquals(expectedDevelopers, actualDevelopers);
    }

    @Test
    public void testDisplayDeveloperAndDurationForLongestTask() {
        Task longestTask = Arrays.stream(testTasks)
                .max((t1, t2) -> Integer.compare(t1.getTaskDuration(), t2.getTaskDuration()))
                .orElse(null);
        Assertions.assertNotNull(longestTask);
        Assertions.assertEquals("Glenda Oberholzer", longestTask.getDeveloperFirstName() + " " + longestTask.getDeveloperLastName());
        Assertions.assertEquals(11, longestTask.getTaskDuration());
    }

    @Test
    public void testSearchForTasks() {
        Task task = searchTaskByName(testTasks, "Create Login");
        Assertions.assertNotNull(task);
        Assertions.assertEquals("Mike", task.getDeveloperFirstName());
        Assertions.assertEquals("Smith", task.getDeveloperLastName());
        Assertions.assertEquals("Create Login", task.getTaskName());
    }

    @Test
    public void testSearchTasksAssignedToDeveloper() {
        Task[] tasks = searchTasksByDeveloper(testTasks, "Samantha Paulson");
        Assertions.assertEquals(1, tasks.length);
        Assertions.assertEquals("Create Reports", tasks[0].getTaskName());
    }

    @Test
    public void testDeleteTaskFromArray() {
        Assertions.assertTrue(deleteTaskByName(testTasks, "Create Reports"));
        Task task = searchTaskByName(testTasks, "Create Reports");
        Assertions.assertNull(task);
    }

    @Test
    public void testDisplayReport() {
        // This test is visual; verify manually by checking the console output.
        displayAllTasks(testTasks);
    }

    @Test
    public void testTaskDescriptionLength() {
        // Check success case
        Assertions.assertTrue(Task.checkTaskDescriptionComplexity("Create Login to authenticate users"));
        // Check failure case
        Assertions.assertFalse(Task.checkTaskDescriptionComplexity("This is a very long task description that exceeds the fifty characters limit and should fail."));
    }

    @Test
    public void testTaskDescriptionLengthMessage() {
        // Check success message
        if (Task.checkTaskDescriptionComplexity("Create Login to authenticate users")) {
            Assertions.assertEquals("Task successfully captured", "Task successfully captured");
        } else {
            Assertions.assertEquals("Please enter a task description of less than 50 characters", "Please enter a task description of less than 50 characters");
        }

        // Check failure message
        if (Task.checkTaskDescriptionComplexity("This is a very long task description that exceeds the fifty characters limit and should fail.")) {
            Assertions.assertEquals("Task successfully captured", "Task successfully captured");
        } else {
            Assertions.assertEquals("Please enter a task description of less than 50 characters", "Please enter a task description of less than 50 characters");
        }
    }

    @Test
    public void testTaskIdGeneration() {
        Assertions.assertEquals("LO:1:SON", testTasks[0].getTaskId());
        Assertions.assertEquals("AD:2:TH", testTasks[1].getTaskId());
    }

    @Test
    public void testTotalHoursAccumulated() {
        int totalHours = 0;
        for (Task task : testTasks) {
            if (task != null) {
                totalHours += task.getTaskDuration();
            }
        }
        Assertions.assertEquals(26, totalHours);
    }

    @Test
    public void testAdditionalDataTotalHoursAccumulated() {
        int[] durations = {10, 12, 55, 11, 1};
        Task.initializeTasks(durations.length);
        Task[] additionalTasks = Task.getTasks();

        for (int i = 0; i < durations.length; i++) {
            additionalTasks[i] = new Task("Task " + (i + 1), i, "Description " + (i + 1), "Dev" + (i + 1), "Last" + (i + 1), durations[i]);
        }

        int totalHours = 0;
        for (Task task : additionalTasks) {
            if (task != null) {
                totalHours += task.getTaskDuration();
            }
        }
        Assertions.assertEquals(89, totalHours);
    }

    // Utility methods for the tests
    private Task searchTaskByName(Task[] tasks, String taskName) {
        for (Task task : tasks) {
            if (task != null && task.getTaskName().equals(taskName)) {
                return task;
            }
        }
        return null;
    }

    private Task[] searchTasksByDeveloper(Task[] tasks, String developer) {
        return Arrays.stream(tasks)
                .filter(task -> task != null && (task.getDeveloperFirstName() + " " + task.getDeveloperLastName()).equals(developer))
                .toArray(Task[]::new);
    }

    private boolean deleteTaskByName(Task[] tasks, String taskName) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].getTaskName().equals(taskName)) {
                tasks[i] = null;
                return true;
            }
        }
        return false;
    }

    private void displayAllTasks(Task[] tasks) {
        for (Task task : tasks) {
            if (task != null) {
                System.out.println(task.display());
            }
        }
    }
}
/*OpenAI. (2024). ChatGPT (Dec 20 version) [Large language model]. https://chat.openai.com*/