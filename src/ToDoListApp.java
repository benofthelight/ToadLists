// ToDoListApp.java
// Main application that manages the to-do list
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");

            int choice = readInt("Choose an option (1-5): ", 1, 5);

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> completeTask();
                case 4 -> removeTask();
                case 5 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
            }
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                int val = Integer.parseInt(input);
                if (val < min || val > max) {
                    System.out.println("Enter a number between " + min + " and " + max);
                } else {
                    return val;
                }
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number. Try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();
        if (description.isEmpty()) {
            System.out.println("Task cannot be empty.");
            return;
        }
        tasks.add(new Task(description));
        System.out.println("Task added!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet!");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(i + ". " + tasks.get(i));
            }
        }
    }

    private static void completeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to complete.");
            return;
        }
        viewTasks();
        int index = readInt("Enter task number: ", 0, tasks.size() - 1);
        tasks.get(index).markComplete();
        System.out.println("Task marked complete!");
    }

    private static void removeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to remove.");
            return;
        }
        viewTasks();
        int index = readInt("Enter task number: ", 0, tasks.size() - 1);
        Task removed = tasks.remove(index);
        System.out.println("Removed: " + removed);
    }
}
