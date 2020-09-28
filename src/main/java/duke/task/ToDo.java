package duke.task;

/**
 * A subclass of superclass Task.
 * Override the outputs specific to task type Todo.
 */
public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFile() {
        return "T|" + super.toFile();
    }
}