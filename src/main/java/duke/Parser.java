package duke;

import java.io.IOException;
import java.util.Scanner;

import static duke.TaskList.displayInstructionCompleted;
import static duke.TaskList.displayInstructionDeleted;
import static duke.TaskList.displayList;
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


public class Parser {

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
                    int instructNum = Integer.parseInt(value);
                    displayInstructionCompleted(instructNum);
                } else if (userCommand.contains("delete")) {
                    String value = userCommand.replace("delete", "").trim();
                    int instructNum = Integer.parseInt(value);
                    displayInstructionDeleted(instructNum);
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
            TaskList.saveData();
        } catch (IOException e) {
            displaySavingError();
        }
    }
}

