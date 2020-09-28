package duke.task;

//class Deadline inherits methods/attributes from class Task

/**
 * A subclass of superclass Task.
 * Override the outputs specific to task type Deadline.
 */
public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description); //it is passing description into Task(String description){} HAS TO BE IN A CONSTRUCTOR
        this.by = by;
    }

    // it takes the value from super.toString which is "[" + getStatusIcon() + "] " + description;
    // from the superclass: Task
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toFile() {
        return "D|" + super.toFile() + "|" + by;
    }


}