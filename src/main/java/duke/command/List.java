package duke.command;

import duke.task_status.Task;
import java.util.ArrayList;

public class List {

    private final ArrayList<Task> instruction = new ArrayList<>();
    private int index = 0; // Array index

    public void printList() {
        displayLine();
        System.out.println("Here are the task(s) in your list:");
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

    public void instructionDeleted(int instructNum) {
        try {
            if (instruction.isEmpty()) {
                throw new DukeException("All Deleted");
            } else {
                instruction.get(instructNum).markInstructionAsDeleted();
                displayLine();
                System.out.println("Noted. I've removed this task: \n" + "\t" + instruction.get(instructNum).toString());
                instruction.remove(instructNum);
                index--;
                if (index == 1) {
                    System.out.println("Now you have " + index + " task in the list");
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

            } else {
                instruction.get(instructNum).markInstructionAsDone();
                displayLine();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(instruction.get(instructNum).toString());
                displayLine();
            }
        } catch (Exception ignored) {
        }
    }

    public void addToDo(String description) {
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

    public static void displayLine() {
        System.out.println("----------------------------------------");
    }

    public void instructionAdded(Task instruction) {
        index++;
        displayLine();
        System.out.println("Got it. I've added this task: \n" + "\t" + instruction.toString());
        if (index == 1) {
            System.out.println("Now you have " + index + " task in the list");
        } else {
            System.out.println("Now you have " + index + " tasks in the list");
        }
        displayLine();
    }
}