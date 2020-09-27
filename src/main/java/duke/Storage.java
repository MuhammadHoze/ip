package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.*;
import java.util.ArrayList;

import static duke.TaskList.addTaskFromFile;
import static duke.Ui.*;

public class Storage {

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
                        // this is each individual value of a command to separate array index
                        // some command have until i == 3 (deadline/event) while tdo only until i == 2
                        for (int i = 0; i < commandList.length; i++) {
                            if (i == 2) {
                                instructionDesc = commandList[i];
                            } else if (i == 3) {
                                dateOfInstructionDesc = commandList[i];
                            }
                        }
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
