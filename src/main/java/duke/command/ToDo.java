package duke.command;

import duke.task_status.Task;

public class ToDo extends Task {


    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}