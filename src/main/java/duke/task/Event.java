package duke.command;

import duke.task_status.Task;

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