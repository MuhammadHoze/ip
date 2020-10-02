package duke.task;

/**
 * Formats each task in the list.
 */
public abstract class Task {

    private String description;
    protected boolean isDone;
    protected boolean isDeleted;

    /**
     * Assigns values to all the private variables.
     *
     * @param description The task description entered by user.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
        this.isDeleted = false;
    }

    /**
     * Returns the description of task.
     *
     * @return task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks the status of the task if it has been completed or not.
     *
     * @return / or X symbol.
     */
    public String getStatusIcon() {
        return (isDone ? "/" : "X");
    }

    /**
     * Returns string to be displayed
     *
     * @return string which includes the status and task description
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    /**
     * Marks the task as completed
     */
    public void markTaskAsDone() {
        isDone = true;
    }

    /**
     * Marks the task as deleted
     */
    public void markTaskAsDeleted() {
        isDeleted = true;
    }

    /**
     * Writes the string to file
     *
     * @return string to be written into duke.txt
     */
    public String toFile() {
        String strValue = "";
        if (isDone) {
            strValue = "1|";
        } else {
            strValue = "0|";
        }
        return strValue + description;
    }
}
