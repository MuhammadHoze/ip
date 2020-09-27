package duke;

import java.io.IOException;
import java.util.Scanner;

import static duke.Ui.*;

public class Parser {

    public static void commandExecuted(String userCommand) {
        Scanner sc = new Scanner(System.in);

        while (!userCommand.trim().equalsIgnoreCase("bye")) {
            try {
                if (userCommand.trim().equalsIgnoreCase("list")) { //correct!
                    TaskList.displayList();
                } else if (userCommand.contains("find")) {
                    displayFind(userCommand);
                } else if (userCommand.contains("help")) {
                    Ui.helpCommands();
                } else if (userCommand.contains("todo")) {
                    displayToDo(userCommand);
                } else if (userCommand.contains("deadline")) {
                    displayDeadline(userCommand);
                } else if (userCommand.contains("event")) {
                    displayEvent(userCommand);
                } else if (userCommand.isEmpty()) {
                    displayCaseEmptyInput();
                } else if (userCommand.contains("done")) {
                    String value = userCommand.replace("done", "").trim();
                    int instructNum = Integer.parseInt(value);
                    TaskList.instructionCompleted(instructNum);
                } else if (userCommand.contains("delete")) {
                    String value = userCommand.replace("delete", "").trim();
                    int instructNum = Integer.parseInt(value);
                    TaskList.displayInstructionDeleted(instructNum);
                } else {
                    displayIncompleteCommand();
                }
            } catch (NumberFormatException e) {
                displayStringIndexOutOfBoundsExceptionMessage();
            }
            userCommand = sc.nextLine();
        }
        Ui.byeMsg();
        try {
            TaskList.saveData();
        } catch (IOException e) {
            savingError();
        }
    }
}

