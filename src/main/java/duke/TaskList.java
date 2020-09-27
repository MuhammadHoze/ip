package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.IOException;
import java.util.ArrayList;

import static duke.Ui.addInstructionBeforeCompletion;
import static duke.Ui.allInstructionDeleted;
import static duke.Ui.instructionDoneOutOfBounds;


public class TaskList {

    public static ArrayList<Task> instruction = new ArrayList<>();
    private static int instructionIndex = 0;

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

    public static void addTaskInFile(Task t) {

        instruction.add(t);
        instructionIndex++;
    }

    public static void addToDo(String description) {
        ToDo newToDo = new ToDo(description);
        instruction.add(newToDo);
        displayInstructionAdded(newToDo);
    }

    public static void addDeadline(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        System.out.println(userInputDate);
        Deadline newDeadline = new Deadline(userInputTask, userInputDate);
        instruction.add(newDeadline); // added into ArrayList
        displayInstructionAdded(newDeadline); // argument is an object
    }

    public static void addEvent(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        Event newEvent = new Event(userInputTask, userInputDate);
        instruction.add(newEvent);
        displayInstructionAdded(newEvent);
    }

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
            instructionDoneOutOfBounds();
        }
    }

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
            instructionDoneOutOfBounds();
        }
    }

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

    public static void displayLine() {
        System.out.println("----------------------------------------------------------------");
    }


    public static void saveData() throws IOException {
        Storage.writeToFile(instruction);
    }
}