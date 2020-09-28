package duke;

import java.io.File;
import java.util.Scanner;

import static duke.Parser.commandExecuted;
import static duke.Storage.readFromFile;
import static duke.Ui.greetMsg;
import static duke.Ui.welcomeLogo;

/**
 * Duke application begins here.
 */

public class Duke  {

    /**
     * Displays greeting.
     * Loads the contents from existing file.
     * Takes in user input.
     * @param args
     */
    public static void main(String[] args) {

        welcomeLogo();
        greetMsg();

        File file = new File("duke.txt");
        readFromFile(file);

        Scanner input = new Scanner(System.in);
        String userCommand = input.nextLine();

        commandExecuted(userCommand);
    }
}