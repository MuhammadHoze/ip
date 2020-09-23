package duke.display;

import duke.Duke;
import duke.DukeException;
import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class List extends Duke {

    private final ArrayList<Task> instruction = new ArrayList<>();
    private int index = 0; // Array index

    public void printList() {
        displayLine();
        System.out.println("Here are the duke.task.task(s) in your list:");
        if (instruction.isEmpty()) {
            System.out.println("(List is currently empty)");
        } else {
            // Used for printing elements in ArrayList
            //instruction.forEach(System.out::println);
            for (int i = 0; i < instruction.size(); i++) {
                System.out.println(i + 1 + ". " + (instruction.get(i)).toString());
            }
        }
        displayLine();
    }

   /* public void findList(String keyword) {
        displayLine();
        System.out.println("Here are the matching duke.task.task(s) in your list:");


        displayLine();
    }*/

    public void instructionDeleted(int instructNum) {
        try {
            if (instruction.isEmpty()) {
                throw new DukeException("All Deleted");
            } else if (instructNum > index) {
                throw new DukeException("Null Entry");
            } else {
                instruction.get(instructNum-1).markInstructionAsDeleted();
                displayLine();
                System.out.println("Noted. I've removed this duke.task.task: \n" + "\t" + instruction.get(instructNum-1).toString());
                instruction.remove(instructNum-1);
                index--;
                if (index == 1) {
                    System.out.println("Now you have " + index + " duke.task.task in the list");
                } else {
                    System.out.println("Now you have " + index + " tasks in the list");
                }
                displayLine();
            }
        } catch (Exception ignored) {
        }
    }

    public void instructionCompleted(int instructNum) {
        try {
            if (instruction.isEmpty()) {
                throw new DukeException("Empty List");
            } else if (instructNum > index) {
                throw new DukeException("Null Entry");
            } else {
                instruction.get(instructNum - 1).markInstructionAsDone();
                displayLine();
                System.out.println("Nice! I've marked this duke.task.task as done: ");
                System.out.println(instruction.get(instructNum - 1).toString());
                displayLine();
            }
        } catch (Exception ignored) {
        }
    }

    public void addTask(Task t) {

        instruction.add(t);
        index++;
    }

    public  void addToDo(String description) {
        ToDo newToDo = new ToDo(description);
        instruction.add(newToDo);
        instructionAdded(newToDo);
    }

    public void addDeadline(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        Deadline newDeadline = new Deadline(userInputTask, userInputDate);
        instruction.add(newDeadline);
        instructionAdded(newDeadline);
    }

    public void addEvent(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        Event newEvent = new Event(userInputTask, userInputDate);
        instruction.add(newEvent);
        instructionAdded(newEvent);
    }

    public void instructionAdded(Task instruction) {
        index++;
        displayLine();
        System.out.println("Got it. I've added this duke.task.task: \n" + "\t" + instruction.toString());
        if (index == 1) {
            System.out.println("Now you have " + index + " duke.task.task in the list");
        } else {
            System.out.println("Now you have " + index + " tasks in the list");
        }
        displayLine();
    }

    public static void displayLine() {
        System.out.println("----------------------------------------");
    }

    public void save() throws IOException {
        //Writing it to file
        String fileContent = "";
        for (int i = 0; i < instruction.size(); i++) {
            fileContent += instruction.get(i).toFile() + "\n";
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\muham\\OneDrive\\Desktop\\NUS MATERIAL\\Sem 5\\CS2113\\IP\\ip\\src\\main\\java\\duke.txt"));
        writer.write(fileContent);
        writer.close();
    }

}