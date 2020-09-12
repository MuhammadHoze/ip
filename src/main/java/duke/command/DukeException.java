package duke.command;

public class DukeException extends Exception {
    protected String error;

    public DukeException(String error) {
        this.error = error;

        if (error.equals("Null Entry")) {
            displayLine();
            System.out.println("☹ OOPS!!! Invalid Input, Please Try Again");
            displayLine();
        } else if (error.equals("Done Incomplete")) {
            displayLine();
            System.out.println("☹ OOPS!!! A value is required after done.");
            displayLine();
        } else if (error.equals("Delete Incomplete")) {
            displayLine();
            System.out.println("☹ OOPS!!! A value is required after delete.");
            displayLine();
        } else if (error.equals("Todo Incomplete")) {
            displayLine();
            System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
            displayLine();
        } else if (error.equals("Deadline Incomplete")) {
            displayLine();
            System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
            displayLine();
        } else if (error.equals("Event Incomplete")) {
            displayLine();
            System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
            displayLine();
        } else if (error.equals("Input Incomplete")) {
            displayLine();
            System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            displayLine();
        } else if (error.equals("Empty List")){
            displayLine();
            System.out.println("Please add instruction first!");
            displayLine();
        } else if (error.equals("All Deleted")){
            displayLine();
            System.out.println("No instructions to delete");
            displayLine();
        }
    }

    public static void displayLine() {
        System.out.println("----------------------------------------------------------------");
    }
}
