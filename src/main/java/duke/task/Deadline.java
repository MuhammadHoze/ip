package duke.command;

import duke.task_status.Task;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override // overwritten the method from superclass: Task
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    @Override
    public String toFile() {
        return "D|" + super.toFile() + "|" + by;
    }


}