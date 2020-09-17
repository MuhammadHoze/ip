package duke.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Duke {


    public static void main(String[] args) throws IOException {

        List listItem = new List();
        File file = new File("C:\\Users\\muham\\OneDrive\\Desktop\\NUS MATERIAL\\Sem 5\\CS2113\\IP\\ip\\src\\main\\java\\duke.txt");


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


                    listItem.addTask(t);
                } else if (commandList[0].equals("D")) {
                    Deadline u = new Deadline(taskDesc, dateDesc);

                    if (checked)
                        u.markInstructionAsDone();
                    if (!taskDesc.isEmpty() && !dateDesc.isEmpty()) {

                        listItem.addTask(u);
                    } else {
                        throw new DukeException("Error reading description or date/time, skipping to next line");
                    }
                } else if (commandList[0].equals("E")) {
                    Event v = new Event(taskDesc, dateDesc);
                    if (checked)
                        v.markInstructionAsDone();
                    listItem.addTask(v);
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

        welcomeLogo();
        greetMsg();
        //List listItem = new List();
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
                        listItem.instructionCompleted(instructNum);
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
                        listItem.instructionDeleted(instructNum);
                    }

                } else {
                    throw new DukeException("Input Incomplete");
                }
            } catch (DukeException ignored) {
            }
            userCommand = sc.nextLine();
        }
        byeMsg();
        try {
            listItem.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
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