package duke;

import parser.Parser;
import storage.Storage;
import ui.Ui;

import java.io.File;
import java.util.Scanner;

public class Duke  {

    public static void main(String[] args) {

        Ui.welcomeLogo();
        Ui.greetMsg();

        File file = new File("duke.txt");
        Storage.readFromFile(file);

        Scanner input = new Scanner(System.in);
        String userCommand = input.nextLine();

        Parser.commandExecuted(userCommand);
    }
}