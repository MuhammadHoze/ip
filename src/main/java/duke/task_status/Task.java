package duke.task_status;

public class Task {

    protected String description;
    protected boolean isDone;
    protected boolean isDeleted;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.isDeleted = false;

    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void markInstructionAsDone() {
        isDone = true;
    }

    public void markInstructionAsDeleted() {
        isDeleted = true;
    }
}
