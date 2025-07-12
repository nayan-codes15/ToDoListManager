
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
    static ArrayList<Task> taskList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== To-Do List Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> completeTask();
                case 4 -> deleteTask();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 5);
    }

    static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        taskList.add(new Task(title));
        System.out.println("Task added!");
    }

    static void viewTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks to show.");
            return;
        }
        for (int i = 0; i < taskList.size(); i++) {
            taskList.get(i).displayTask(i + 1);
        }
    }

    static void completeTask() {
        System.out.print("Enter task number to mark as completed: ");
        int num = sc.nextInt();
        if (num >= 1 && num <= taskList.size()) {
            taskList.get(num - 1).markCompleted();
            System.out.println("Task marked as completed!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    static void deleteTask() {
        System.out.print("Enter task number to delete: ");
        int num = sc.nextInt();
        if (num >= 1 && num <= taskList.size()) {
            taskList.remove(num - 1);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number.");
        }
    }
}
