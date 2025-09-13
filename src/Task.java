//Represents a singular task

public class Task {
    private String description; //task description
    private boolean completed; //states if task is true or false

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        return (completed ? "[✓] " : "[ ] ") + description;
    }

    public void markComplete() {
        this.completed = true;
    }

}
