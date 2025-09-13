// Task.java
// Represents a single to-do item
public class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void markComplete() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    @Override
    public String toString() {
        return (completed ? "[✓] " : "[ ] ") + description;
    }
}

