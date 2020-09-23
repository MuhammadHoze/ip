package duke.task_status;

public abstract class Task {

    protected String description;
    protected boolean isDone;
    protected boolean isDeleted;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.isDeleted = false;

    }

    public String getStatusIcon() {
        return (isDone ? "/" : "X");
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

    public String toFile() {
        String numStr = "";
        if (isDone) {
            numStr = "1|";
        } else {
            numStr = "0|";
        }
        return  numStr + description;
    }
}