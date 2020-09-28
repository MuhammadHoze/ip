package duke.task;

/**
 * A subclass of superclass Task.
 * Override the outputs specific to task type Event.
 */
public class Event extends Task {
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String toFile() {
        return "E|" + super.toFile() + "|" + at;
    }
}
