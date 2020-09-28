package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static duke.TaskList.addTaskFromFile;
import static duke.Ui.displayCorruptedFile;
import static duke.Ui.displayLine;
import static duke.Ui.displayReadingFileError;

/**
 * Deals with loading tasks from the file and saving tasks in the file.
 */
public class Storage {

    /**
     * Reads the file duke.txt, if exists, and outputs the contents in the list.
     * If file does not exists, a new file is created.
     * @param file The file which is read.
     * @throws IOException if file is corrupted.
     */
    public static void readFromFile(File file) {
        try {
            if (file.createNewFile()) {
                System.out.println("No existing file found, new file is created");
                displayLine();
            } else {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String fileInput;
                String instructionDesc = "";
                String dateOfInstructionDesc = "";
                while ((fileInput = br.readLine()) != null) {
                    String[] commandList = fileInput.split("\\|");
                    try {
                        instructionDesc = commandList[2];
                        if (commandList.length > 3)
                            dateOfInstructionDesc = commandList[3];
                        switch (commandList[0]) {
                        case "T":
                            ToDo todoFromFile = new ToDo(instructionDesc);
                            if (commandList[1].equals("1"))
                                todoFromFile.markInstructionAsDone();
                            addTaskFromFile(todoFromFile);
                            break;
                        case "D":
                            Deadline deadlineFromFile = new Deadline(instructionDesc, dateOfInstructionDesc);
                            if (commandList[1].equals("1")) {
                                deadlineFromFile.markInstructionAsDone();
                            }
                            addTaskFromFile(deadlineFromFile);
                            break;
                        case "E":
                            Event eventFromFile = new Event(instructionDesc, dateOfInstructionDesc);
                            if (commandList[1].equals("1")) {
                                eventFromFile.markInstructionAsDone();
                            }
                            addTaskFromFile(eventFromFile);
                            break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        displayReadingFileError();
                    }
                }
                br.close();
                System.out.println("Upload Completed");
                displayLine();
            }

        } catch (IOException e) {
            displayCorruptedFile();
            System.exit(0);
        }
    }

    /**
     * Writes all task data into file, duke.txt in a readable format.
     * @param instruction The tasks in the list are written into the file.
     * @throws IOException if an error occurs during writing to file.
     */
    public static void writeToFile(ArrayList<Task> instruction) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("duke.txt"));
        StringBuilder fileContent = new StringBuilder();

        for (Task task : instruction) {
            fileContent.append(task.toFile()).append("\n");
        }
        writer.write(fileContent.toString());
        writer.close();
    }
}
