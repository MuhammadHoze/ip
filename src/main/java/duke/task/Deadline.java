package duke.task;

/**
 * A subclass of superclass Task.
 * Override the outputs specific to task type Deadline.
 */
public class Deadline extends Task {
    protected String by;

    /**
     * Assigns values to all the private variables.
     *
     * @param description Description of deadline is passed to superclass.
     * @param by Assigning value to variable.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Displays the string with regards to deadline.
     *
     * @return string to be displayed.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    /**
     * Writes the string to file with regards to deadline.
     *
     * @return string to be written into duke.txt.
     */
    @Override
    public String toFile() {
        return "D|" + super.toFile() + "|" + by;
    }
}