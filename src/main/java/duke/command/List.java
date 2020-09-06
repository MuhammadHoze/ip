package duke.command;

import duke.task_status.Task;

public class List {

    private final int MAX_INSTRUCTION = 100;
    private Task[] instruction = new Task[MAX_INSTRUCTION];
    private int index = 0; // Array index
    private boolean isEmpty = true; // To check if duke.Instruction.Duke.duke.Instruction array is empty

    public void printList() {
        displayLine();
        System.out.println("Here are the task(s) in your list:");
        for (int i = 0; i < instruction.length; i++) {
            if (instruction[i] == null) { // to prevent empty array values to show
                if (isEmpty) {
                    System.out.println("(List is currently empty)");
                }
                break;
            } else {
                System.out.println((i + 1) + ". " + instruction[i].toString());
            }
        }
        displayLine();
    }

    public void instructionCompleted(int instructNum) {

        if (isEmpty) {
            System.out.println("Please add instruction first!");
        } else {
            instruction[instructNum].markInstructionAsDone();
            displayLine();
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println(instruction[instructNum].toString());
            displayLine();
        }
    }

    public void addToDo(String description) {
        ToDo newToDo = new ToDo(description);
        instruction[index] = newToDo;
        isEmpty = false;
        instructionAdded(newToDo);
        index++;
    }

    public void addDeadline(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        Deadline newDeadline = new Deadline(userInputTask, userInputDate);
        instruction[index] = newDeadline;
        isEmpty = false;
        instructionAdded(newDeadline);
        index++;
    }

    public void addEvent(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        Event newEvent = new Event(userInputTask, userInputDate);
        instruction[index] = newEvent;
        isEmpty = false;
        instructionAdded(newEvent);
        index++;
    }

    public static void displayLine() {
        System.out.println("----------------------------------------");
    }

    public void instructionAdded(Task instruction) {

        displayLine();
        System.out.println("Got it. I've added this task: \n" + "\t" + instruction.toString());
        if (index == 0) {
            System.out.println("Now you have " + (index + 1) + " task in the list");
        } else {
            System.out.println("Now you have " + (index + 1) + " tasks in the list");
        }
        displayLine();
    }
}