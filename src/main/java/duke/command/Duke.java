package duke.command;

import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {

        welcomeLogo();
        greetMsg();
        List listItem = new List();
        Scanner sc = new Scanner(System.in);
        String userCommand = sc.nextLine();

        // This loop is to process the commands input by user
        while (!userCommand.trim().equalsIgnoreCase("bye")) {
            try {
                if (userCommand.trim().equalsIgnoreCase("list")) {
                    listItem.printList();
                } else if (userCommand.contains("done")) {
                    String value = userCommand.replace("done", "").trim();
                    if (value.isEmpty()) {
                        throw new DukeException("Done Incomplete");
                    } else {
                        int instructNum = Integer.parseInt(value);
                        listItem.instructionCompleted(instructNum - 1);
                    }
                } else if (userCommand.contains("todo")) {
                    String todoInstruction = userCommand.replace("todo", "").trim();
                    if (todoInstruction.isEmpty()) {
                        throw new DukeException("Todo Incomplete");
                    } else {
                        listItem.addToDo(todoInstruction);
                    }
                } else if (userCommand.contains("deadline")) {
                    String deadlineInstruction = userCommand.replace("deadline", "").trim();
                    if (deadlineInstruction.isEmpty()) {
                        throw new DukeException("Deadline Incomplete");
                    } else {
                        listItem.addDeadline(deadlineInstruction);
                    }
                } else if (userCommand.contains("event")) {
                    String eventInstruction = userCommand.replace("event", "").trim();
                    if (eventInstruction.isEmpty()) {
                        throw new DukeException("Event Incomplete");
                    } else {
                        listItem.addEvent(eventInstruction);
                    }
                } else if (userCommand.contains("help")) {
                    helpCommands();
                } else if (userCommand.contains("delete")) {
                    String value = userCommand.replace("delete", "").trim();
                    if (value.isEmpty()) {
                        throw new DukeException("Delete Incomplete");
                    } else {
                        int instructNum = Integer.parseInt(value);
                        listItem.instructionDeleted(instructNum - 1);
                    }

                } else {
                    throw new DukeException("Input Incomplete");
                }
            } catch (DukeException ignored) {
            }
            userCommand = sc.nextLine();
        }
        byeMsg();
    }

    public static void welcomeLogo() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Welcome to\n" + logo);
        displayLine();
    }

    public static void displayLine() {
        System.out.println("----------------------------------------------------------------");
    }

    public static void greetMsg() {
        System.out.println("Hello World! I'm duke");
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
        System.out.println("Bye. Hope to see you again soon!");
        displayLine();
    }
}