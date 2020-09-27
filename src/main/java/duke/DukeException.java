package duke;

public class DukeException extends Exception {
    protected String error;

    public DukeException(String error) {
        this.error = error;
    }
}
