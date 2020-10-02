package duke;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Task;
import duke.task.ToDo;

import java.io.IOException;
import java.util.ArrayList;

import static duke.Storage.writeToFile;
import static duke.Ui.addTaskBeforeCompletion;
import static duke.Ui.allTaskDeleted;
import static duke.Ui.taskNumberOutOfBounds;

/**
 * Contains the task list.
 */
public class TaskList {

    public static ArrayList<Task> task = new ArrayList<>();
    private static int taskIndex = 0;

    /**
     * Prints out all tasks currently in the list.
     */
    public static void displayList() {
        displayLine();
        System.out.println("Here are the task(s) in your list:");
        if (task.isEmpty()) {
            System.out.println("\t(List is currently empty)");
        } else {
            for (int i = 0; i < task.size(); i++) {
                System.out.println(i + 1 + ". " + (task.get(i)).toString());
            }
        }
        displayLine();
    }

    /**
     * Prints out the tasks that has the matching keyword.
     *
     * @param keyword Checks if the description of each task in the list matches.
     */
    public static void findTaskInList(String keyword) {
        displayLine();
        System.out.println("Here are the matching task(s) in your list:");
        int indexNum = 1;
        boolean isMatchKeyword = false;
        for (Task element : task) {
            if (element.getDescription().contains(keyword)) {
                System.out.print(indexNum + ". ");
                System.out.println(element);
                indexNum++;
                isMatchKeyword = true;
            }
        }
        if (!isMatchKeyword) {
            System.out.println("\t(Sorry,no matches found)");
        }
        displayLine();
    }

    /**
     * Adds in the tasks to the list upon reading from file duke.txt.
     *
     * @param instruction Task read from file duke.txt.
     */
    public static void addTaskFromFile(Task instruction) {

        task.add(instruction);
        taskIndex++;
    }

    /**
     * Adds a new Todo type task to the list.
     * Calls a function to display the task added.
     *
     * @param description Description of the task.
     */
    public static void addToDo(String description) {
        ToDo newToDo = new ToDo(description);
        task.add(newToDo);
        displayTaskAdded(newToDo);
    }

    /**
     * Adds a new Deadline type task to the list
     * Extracts out the task description and task Date.
     * Calls a function to display the task added.
     *
     * @param description Description of the task.
     */
    public static void addDeadline(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        Deadline newDeadline = new Deadline(userInputTask, userInputDate);
        task.add(newDeadline);
        displayTaskAdded(newDeadline);
    }

    /**
     * Adds a new Event type task to the list
     * Extracts out the task description and task Date.
     * Calls a function to display the task added.
     *
     * @param description Description of the task.
     */
    public static void addEvent(String description) {
        String userInputTask = description.substring(0, description.lastIndexOf("/"));
        String userInputDate = description.substring(description.lastIndexOf("/") + 3).trim();
        Event newEvent = new Event(userInputTask, userInputDate);
        task.add(newEvent);
        displayTaskAdded(newEvent);
    }

    /**
     * Prints out the task that user sets as Done.
     * Checks if task number is correctly entered by user.
     *
     * @param taskNum Identifies which task is completed.
     * @throws IndexOutOfBoundsException If task number does not exist in the list.
     */
    public static void displayTaskCompleted(int taskNum) {
        try {
            if (task.isEmpty()) {
                addTaskBeforeCompletion();
            } else {
                task.get(taskNum - 1).markTaskAsDone();
                displayLine();
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(task.get(taskNum - 1).toString());
                displayLine();
            }
        } catch (IndexOutOfBoundsException e) {
            taskNumberOutOfBounds();
        }
    }

    /**
     * Prints out the task that user wants to Delete.
     * Checks if task number is correctly entered by user.
     * Prints out the remaining number of task/s left in the list.
     *
     * @param taskNum Identifies which task is deleted.
     * @throws IndexOutOfBoundsException If task number does not exist in the list.
     */
    public static void displayTaskDeleted(int taskNum) {
        try {
            if (task.isEmpty()) {
                allTaskDeleted();
            } else {
                task.get(taskNum - 1).markTaskAsDeleted();
                displayLine();
                System.out.println("Noted. I've removed this task: \n" + "\t" + task.get(taskNum - 1).toString());
                task.remove(taskNum - 1);
                taskIndex--;
                if (taskIndex == 1) {
                    System.out.println("Now you have " + taskIndex + " task in the list");
                } else {
                    System.out.println("Now you have " + taskIndex + " tasks in the list");
                }
                displayLine();
            }
        } catch (IndexOutOfBoundsException e) {
            taskNumberOutOfBounds();
        }
    }

    /**
     * Prints out the task which is added to the list.
     * Prints out the updated total number of task/s in the list.
     *
     * @param task The task which is added.
     */
    public static void displayTaskAdded(Task task) {
        taskIndex++;
        displayLine();
        System.out.println("Got it. I've added this task: \n" + "\t" + task.toString());
        if (taskIndex == 1) {
            System.out.println("Now you have " + taskIndex + " task in the list");
        } else {
            System.out.println("Now you have " + taskIndex + " tasks in the list");
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
     *
     * @throws IOException if writing to file fails.
     */
    public static void saveData() throws IOException {
        writeToFile(task);
    }
}