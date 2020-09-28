package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.IOException;
import java.util.ArrayList;

import static duke.Storage.writeToFile;
import static duke.Ui.addInstructionBeforeCompletion;
import static duke.Ui.allInstructionDeleted;
import static duke.Ui.instructionNumberOutOfBounds;

/**
 * Contains the task list.
 */
public class TaskList {

    public static ArrayList<Task> instruction = new ArrayList<>();
    private static int instructionIndex = 0;

    /**
     * Prints out all tasks currently in the list.
     */
    public static void displayList() {
        displayLine();
        System.out.println("Here are the task(s) in your list:");
        if (instruction.isEmpty()) {
            System.out.println("(List is currently empty)");
        } else {
            for (int i = 0; i < instruction.size(); i++) {
                //this wil first check instruction.get(i) and see if its a Deadline/Event/tdo
                // and then print out the toString() method of the respective Deadline/event/tdo class
                System.out.println(i + 1 + ". " + (instruction.get(i)).toString());
            }
        }
        displayLine();
    }

    /**
     * Prints out the tasks that has the matching keyword.
     * @param keyword Checks if the description of each task in the list matches.
     */
    public static void findInstructionInList(String keyword) {
        displayLine();
        System.out.println("Here are the matching task(s) in your list:");
        int indexNum = 1;
        for (Task element : instruction) {
            if (element.description.contains(keyword)) {
                System.out.print(indexNum + ". ");
                System.out.println(element);
                indexNum++;
            }
        }
        displayLine();
    }

    /**
     * Adds in the tasks to the list upon reading from file duke.txt.
     * @param task Task read from file duke.txt.
     */
    public static void addTaskFromFile(Task task) {

        instruction.add(task);
        instructionIndex++;
    }

    /**
     * Adds a new Todo type task to the list.
     * Calls a function to display the task added.
     * @param description Description of the task.
     */
    public static void addToDo(String description) {
        ToDo newToDo = new ToDo(description);
        instruction.add(newToDo);
        displayInstructionAdded(newToDo);
    }

    /**
     * Adds a new Deadline type task to the list
     * Extracts out the task description and task Date.
     * Calls a function to display the task added.
     * @param description Description of the task.
     */
    public static void addDeadline(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        System.out.println(userInputDate);
        Deadline newDeadline = new Deadline(userInputTask, userInputDate);
        instruction.add(newDeadline); // added into ArrayList
        displayInstructionAdded(newDeadline); // argument is an object
    }

    /**
     * Adds a new Event type task to the list
     * Extracts out the task description and task Date.
     * Calls a function to display the task added.
     * @param description Description of the task.
     */
    public static void addEvent(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        Event newEvent = new Event(userInputTask, userInputDate);
        instruction.add(newEvent);
        displayInstructionAdded(newEvent);
    }

    /**
     * Prints out the task that user sets as Done.
     * Checks if task number is correctly entered by user.
     * @param instructNum Identifies which task is completed.
     * @throws IndexOutOfBoundsException If instruction number does not exist in the list.
     */
    public static void displayInstructionCompleted(int instructNum) {
        try {
            if (instruction.isEmpty()) {
                addInstructionBeforeCompletion();
            } else {
                instruction.get(instructNum - 1).markInstructionAsDone(); // because instruction is data type Task
                displayLine();
                System.out.println("Nice! I've marked this task as done: ");

                //this wil first check instruction.get(instructNum -1) and see if its a Deadline/Event/tdo
                // and then print out the toString() method of the respective Deadline/event/tdo class
                System.out.println(instruction.get(instructNum - 1).toString()); // because instruction is data type Task
                displayLine();
            }
        } catch (IndexOutOfBoundsException e) {
            instructionNumberOutOfBounds();
        }
    }

    /**
     * Prints out the task that user wants to Delete.
     * Checks if task number is correctly entered by user.
     * Prints out the remaining number of task/s left in the list.
     * @param instructNum Identifies which task is deleted.
     * @throws IndexOutOfBoundsException If instruction number does not exist in the list.
     */
    public static void displayInstructionDeleted(int instructNum) {
        try {
            if (instruction.isEmpty()) {
                allInstructionDeleted();
            } else {
                instruction.get(instructNum - 1).markInstructionAsDeleted();
                displayLine();
                System.out.println("Noted. I've removed this task: \n" + "\t" + instruction.get(instructNum - 1).toString());
                instruction.remove(instructNum - 1);
                instructionIndex--;
                if (instructionIndex == 1) {
                    System.out.println("Now you have " + instructionIndex + " task in the list");
                } else {
                    System.out.println("Now you have " + instructionIndex + " tasks in the list");
                }
                displayLine();
            }
        } catch (IndexOutOfBoundsException e) {
            instructionNumberOutOfBounds();
        }
    }

    /**
     * Prints out the task which is added to the list.
     * Prints out the updated total number of task/s in the list.
     * @param task The task which is added.
     */
    public static void displayInstructionAdded(Task task) {
        instructionIndex++;
        displayLine();
        System.out.println("Got it. I've added this task: \n" + "\t" + task.toString());
        if (instructionIndex == 1) {
            System.out.println("Now you have " + instructionIndex + " task in the list");
        } else {
            System.out.println("Now you have " + instructionIndex + " tasks in the list");
        }
        displayLine();
    }

    /**
     * Prints out a line.
     */
    public static void displayLine() {
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * Calls function to write data into file after "bye" command is entered by user.
     * @throws IOException if writing to file fails.
     */
    public static void saveData() throws IOException {
        writeToFile(instruction);
    }
}