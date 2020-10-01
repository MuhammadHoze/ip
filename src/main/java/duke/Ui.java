package duke;


import static duke.TaskList.addDeadline;
import static duke.TaskList.addEvent;
import static duke.TaskList.addToDo;
import static duke.TaskList.findTaskInList;

/**
 * Deals with interacting with the user.
 */
public class Ui {

    /**
     * Prints out the Duke logo.
     */
    public static void welcomeLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Welcome to\n" + logo);
        displayLine();
    }

    /**
     * Prints out a greeting message.
     */
    public static void greetMsg() {
        System.out.println("Hello World! I'm Duke");
        System.out.println("What can I do for you?\n");
        displayLine();
    }

    /**
     * Prints out the commands and format that are accepted by Duke.
     */
    public static void displayHelpCommands() {
        displayLine();
        System.out.println(
                  "list:        Output all tasks\n"
                + "todo:        eg. todo <TaskDesc>\n"
                + "deadline:    eg. deadline <TaskDesc> /by <TaskDate>\n"
                + "event:       eg. event <TaskDesc> /at <TaskDate>\n"
                + "done:        eg. done <TaskNumber>\n"
                + "delete:      eg. delete <TaskNumber>\n"
                + "find:        eg. find <keyword>\n"
                + "help:        Prints out the help commands\n"
                + "bye:         Save and end program :(");
        displayLine();
    }

    /**
     * Prints out exit message.
     */
    public static void displayByeMsg() {
        displayLine();
        System.out.println("Bye! All tasks have been saved. Hope to see you again soon!");
        displayLine();
    }

    /**
     * Prints out when user inputs delete command after all tasks
     * have already been deleted from the list.
     */
    public static void allTaskDeleted(){
        displayLine();
        System.out.println("No tasks to delete");
        displayLine();
    }

    /**
     * Prints out when user inputs done command before any task is added into the list.
     */
    public static void addTaskBeforeCompletion(){
        displayLine();
        System.out.println("Please add task first!");
        displayLine();
    }

    /**
     * Prints out when user inputs an invalid task number during done or delete command.
     */
    public static void taskNumberOutOfBounds(){
        displayLine();
        System.out.println("Task number does not exist. Please try again!");
        displayLine();
    }

    /**
     * Prints out a line.
     */
    public static void displayLine() {
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * Prints out when the value is missing for a done or delete command.
     */
    public static void displayIndexOutOfBounds() {
        displayLine();
        System.out.println("The task you input has missing fields!");
        displayLine();
    }

    /**
     * Prints out if user presses the Enter key without any inputs.
     */
    public static void displayEmptyInput() {
        displayLine();
        System.out.println("OOPS!!! The description cannot be empty!");
        displayLine();
    }

    /**
     * Prints out if user incorrectly enters a command which Duke does not support.
     */
    public static void displayIncompleteCommand() {
        displayLine();
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
        displayLine();
    }

    /**
     * Checks if user have correctly entered the description of ToDo.
     * Subsequently calls a function which adds the task into an ArrayList.
     * @param userCommand User input.
     */
    public static void displayToDo(String userCommand) {
        if (userCommand.toLowerCase().trim().equals("todo")) {
            displayLine();
            System.out.println("OOPS!!! The description of a todo cannot be empty.");
            displayLine();
        } else {
            userCommand = userCommand.replace("todo", "");
            addToDo(userCommand);
        }
    }

    /**
     * Checks if user have correctly entered the description of deadline.
     * Subsequently calls a function which adds the task into an ArrayList.
     * @param userCommand User input.
     */
    public static void displayDeadline(String userCommand) {
        if (userCommand.toLowerCase().trim().equals("deadline")) {
            displayLine();
            System.out.println("OOPS!!! The description of a deadline cannot be empty.");
            displayLine();
        } else {
            userCommand = userCommand.replace("deadline", "");
            addDeadline(userCommand);
        }
    }

    /**
     * Checks if user have correctly entered the description of event.
     * Subsequently calls a function which adds the task into an ArrayList.
     * @param userCommand User input.
     */
    public static void displayEvent(String userCommand) {
        if (userCommand.toLowerCase().trim().equals("event")) {
            displayLine();
            System.out.println("OOPS!!! The description of an event cannot be empty.");
            displayLine();
        } else {
            userCommand = userCommand.replace("event", "");
            addEvent(userCommand);
        }
    }

    /**
     * Checks if user have correctly entered the description of find.
     * Subsequently, extract out the keyword and call a function which executes the find command.
     * @param userCommand User input.
     */
    public static void displayFind(String userCommand) {
        if (userCommand.toLowerCase().trim().equals("find")) {
            displayLine();
            System.out.println("The description of find cannot be empty.");
            displayLine();
        } else {
            String keyword = userCommand.replace("find", "").trim();
            findTaskInList(keyword);
        }
    }

    /**
     * Prints out if there is an error in saving the file.
     */
    public static void displaySavingError() {
        displayLine();
        System.out.println("Unable to save data, please try again!");
        displayLine();
    }

    /**
     * Prints out if there is an error in reading the values from the .txt file.
     */
    public static void displayReadingFileError(){
        System.out.println("Error reading value, skipping to next line.");
        System.out.println("Removed corrupted task. Please add again.");
        displayLine();
    }

    /**
     * Print out if entire file is corrupted and unable to load into the application.
     */
    public static void displayCorruptedFile(){
        System.out.println("File is corrupted. Shutting down... ");
        displayLine();

    }
}
