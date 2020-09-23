package duke.command;

import duke.task_status.Task;

public class ToDo extends Task {

    //Because newToDo has a constructor value
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