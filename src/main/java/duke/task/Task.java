package duke.task;

public abstract class Task {


    public String description;
    protected boolean isDone;
    protected boolean isDeleted;

    // String description: this is received from Deadline/Event/Tdo constructor
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.isDeleted = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "X"); //return tick or X symbols
    }

    //description is really just what is the task: eg. buy bread, project meeting etc
    // this is just the skeleton that's why its abstract
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
