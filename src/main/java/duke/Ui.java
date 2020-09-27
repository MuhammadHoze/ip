package duke;


import static duke.TaskList.*;

public class Ui {

    public static void welcomeLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Welcome to\n" + logo);
        displayLine();
    }

    public static void greetMsg() {
        System.out.println("Hello World! I'm Duke");
        System.out.println("What can I do for you?\n");
        displayLine();
    }

    public static void helpCommands() {
        System.out.println("list: Outputs the tasks\n"
                + "todo: <eg. todo visit new theme park>\n"
                + "deadline: <eg. deadline submit report /by 11/10/2019 5pm>\n"
                + "event: <eg. event team project meeting /at 2/10/2019 2-4pm>\n"
                + "bye: End program :(");
    }

    public static void byeMsg() {
        displayLine();
        System.out.println("Bye. All instructions have been saved. Hope to see you again soon!");
        displayLine();
    }

    public static void allInstructionDeleted(){
        displayLine();
        System.out.println("No instructions to delete");
        displayLine();
    }

    public static void addInstructionBeforeCompletion(){
        displayLine();
        System.out.println("Please add instruction first!");
        displayLine();
    }

    public static void instructionDoneOutOfBounds(){
        displayLine();
        System.out.println("Instruction number does not exist. Please try again!");
        displayLine();
    }

    public static void displayLine() {
        System.out.println("----------------------------------------------------------------");
    }

    public static void displayStringIndexOutOfBoundsExceptionMessage() {
        displayLine();
        System.out.println("The task you input has missing fields!");
        displayLine();
    }

    public static void savingError() {
        displayLine();
        System.out.println("Unable to save data, please try again!");
        displayLine();
    }

    public static void displayCaseEmptyInput() {
        displayLine();
        System.out.println("OOPS!!! The description cannot be empty!");
        displayLine();
    }

    public static void displayIncompleteCommand() {
        displayLine();
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
        displayLine();
    }

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

    public static void displayFind(String userCommand) {
        if (userCommand.toLowerCase().trim().equals("find")) {
            displayLine();
            System.out.println("The description of find cannot be empty.");
            displayLine();
        } else {
            String keyword = userCommand.replace("find", "").trim();
            findList(keyword);
        }
    }
}
