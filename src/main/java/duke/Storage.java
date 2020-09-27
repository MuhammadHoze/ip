package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.*;
import java.util.ArrayList;

public class Storage  {

    public static void readFromFile(File file){
        try {
            if(file.createNewFile()) {
                System.out.println("No existing file found, new file is created");
                Ui.displayLine();
            } else {
                //System.out.println("Uploading data into system ...");
                System.out.println("Upload Completed");
                Ui.displayLine();
                BufferedReader br = new BufferedReader(new FileReader(file));

                String st;
                String taskDesc = "";
                String dateDesc = "";
                while ((st = br.readLine()) != null) {
                    String[] commandList = st.split("\\|");
                    try {
                        for (int i = 0; i < commandList.length; i++) {
                            if (i == 2) {
                                taskDesc = commandList[i];
                            } else if (i == 3) {
                                dateDesc = commandList[i];
                            }
                        }
                        boolean checked = false;
                        if (commandList.length > 1) {
                            if (!(commandList[1].equals("1") || commandList[1].equals("0"))) {
                                throw new DukeException("Error reading 1 or 0, skipping to next line");
                            }
                            checked = commandList[1].equals("1");
                        }
                        if (commandList[0].equals("T")) {
                            ToDo t = new ToDo(taskDesc);
                            if (checked)
                                t.markInstructionAsDone();
                            TaskList.addTaskInFile(t);
                        } else if (commandList[0].equals("D")) {
                            Deadline u = new Deadline(taskDesc, dateDesc);

                            if (checked)
                                u.markInstructionAsDone();
                            if (!taskDesc.isEmpty() && !dateDesc.isEmpty()) {

                                TaskList.addTaskInFile(u);
                            } else {
                                throw new DukeException("Error reading description or date/time, skipping to next line");
                            }
                        } else if (commandList[0].equals("E")) {
                            Event v = new Event(taskDesc, dateDesc);
                            if (checked)
                                v.markInstructionAsDone();
                            TaskList.addTaskInFile(v);
                        } else if (!commandList[0].isEmpty()) {
                            throw new DukeException("Error reading whether if its T, D, or E, skipping to next line");
                        }
                    } catch (Exception e) {
                        System.out.println("     Error when reading current line, please fix the text file:");
                        e.printStackTrace();
                        System.out.println("     Duke will continue reading the rest of file");
                    }
                }
                br.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(ArrayList <Task> instruction ) throws IOException {

        //Writing it to file
        BufferedWriter writer = new BufferedWriter(new FileWriter("duke.txt"));

        String fileContent = "";

        for (int i = 0; i < instruction.size(); i++) {
            fileContent += instruction.get(i).toFile() + "\n";
        }

        writer.write(fileContent);
        writer.close();

    }
}
