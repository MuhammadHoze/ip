package duke.task;

/**
 * A subclass of superclass Task.
 * Override the outputs specific to task type Todo.
 */
public class ToDo extends Task {

    /**
     * @param description Description of event is passed to superclass.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Displays the string with regards to todo.
     *
     * @return string to be displayed.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Writes the string to file with regards to todo.
     *
     * @return string to be written into duke.txt.
     */
    @Override
    public String toFile() {
        return "T|" + super.toFile();
    }
}