package duke;

import java.io.IOException;
import java.util.Scanner;

import static duke.TaskList.displayTaskDeleted;
import static duke.TaskList.displayList;
import static duke.TaskList.displayTaskCompleted;
import static duke.TaskList.saveData;
import static duke.Ui.displayByeMsg;
import static duke.Ui.displayDeadline;
import static duke.Ui.displayEmptyInput;
import static duke.Ui.displayEvent;
import static duke.Ui.displayFind;
import static duke.Ui.displayHelpCommands;
import static duke.Ui.displayIncompleteCommand;
import static duke.Ui.displayIndexOutOfBounds;
import static duke.Ui.displaySavingError;
import static duke.Ui.displayToDo;

/**
 * Deals with making sense of the user command.
 */
public class Parser {
    /**
     * Reads and executes the user commands accordingly.
     *
     * @param userCommand User input.
     * @throws NumberFormatException If there exist a missing field for done and delete commands.
     * @throws IOException           When unable to save the file.
     */
    public static void commandExecuted(String userCommand) {
        Scanner sc = new Scanner(System.in);

        while (!userCommand.trim().equalsIgnoreCase("bye")) {
            try {
                if (userCommand.trim().equalsIgnoreCase("list")) {
                    displayList();
                } else if (userCommand.contains("find")) {
                    displayFind(userCommand);
                } else if (userCommand.contains("help")) {
                    displayHelpCommands();
                } else if (userCommand.contains("todo")) {
                    displayToDo(userCommand);
                } else if (userCommand.contains("deadline")) {
                    displayDeadline(userCommand);
                } else if (userCommand.contains("event")) {
                    displayEvent(userCommand);
                } else if (userCommand.isEmpty()) {
                    displayEmptyInput();
                } else if (userCommand.contains("done")) {
                    String value = userCommand.replace("done", "").trim();
                    int taskNum = Integer.parseInt(value);
                    displayTaskCompleted(taskNum);
                } else if (userCommand.contains("delete")) {
                    String value = userCommand.replace("delete", "").trim();
                    int taskNum = Integer.parseInt(value);
                    displayTaskDeleted(taskNum);
                } else {
                    displayIncompleteCommand();
                }
            } catch (NumberFormatException e) {
                displayIndexOutOfBounds();
            }
            userCommand = sc.nextLine();
        }
        displayByeMsg();
        try {
            saveData();
        } catch (IOException e) {
            displaySavingError();
        }
    }
}

