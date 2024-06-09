import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        // Create users
        User user1 = new User("1", "John Doe", "john@example.com");
        User user2 = new User("2", "Jane Smith", "jane@example.com");

        // Create tasks
        Task task1 = new Task("1", "Task 1", "Description 1", new Date(), 1, user1);
        Task task2 = new Task("2", "Task 2", "Description 2", new Date(), 2, user2);
        Task task3 = new Task("3", "Task 3", "Description 3", new Date(), 1, user1);

        //add tasks to the task manager
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        //update a task
        task2.setDescription("Updated description");
        taskManager.updateTask(task2);

        //search tasks
        List<Task> searchResults = taskManager.searchTasks("Task");
        System.out.println("Search results");
        for (Task task : searchResults){
            System.out.println(task.getTitle());
        }

        //filter tasks
        List<Task> filteredTasks = taskManager.filterTasks(TaskStatus.PENDING,new Date(0),new Date(),1);
        System.out.println("Filtered tasks");
        for (Task task : filteredTasks){
            System.out.println(task.getTitle());
        }

        //mark task as completed
        taskManager.markTaskAsCompleted("1");

        //get task history for a user
        List<Task> taskHistory = taskManager.getTaskHistory(user1);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

        //delete a task
        taskManager.deleteTask("3");
    }
}