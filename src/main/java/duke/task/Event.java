package duke.task;

/**
 * A subclass of superclass Task.
 * Override the outputs specific to task type Event.
 */
public class Event extends Task {
    protected String at;

    /**
     * Assigns values to all the private variables.
     *
     * @param description Description of event is passed to superclass.
     * @param at Assigning value to the private variable.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /**
     * Displays the string with regards to event.
     *
     * @return string to be displayed.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    /**
     * Writes the string to file with regards to event.
     *
     * @return string to be written into duke.txt.
     */
    @Override
    public String toFile() {
        return "E|" + super.toFile() + "|" + at;
    }
}
