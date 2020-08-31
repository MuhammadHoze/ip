public class List {

    private final int MAX_INSTRUCTION = 100;
    private Task[] instruction = new Task[MAX_INSTRUCTION];
    private int index = 0; // Array index
    private boolean isEmpty = true; // To check if Instruction array is empty

    public void printList() {
        System.out.println("----------------------------------------");
        System.out.println("Here are the task(s) in your list:");
        for (int i = 0; i < instruction.length; i++) {
            if (instruction[i] == null) { // to prevent empty array values to show
                if (isEmpty) {
                    System.out.println("(List is currently empty)");
                }
                break;
            }
            else {
                System.out.println((i + 1) + ". " + "["+ instruction[i].keyChar + "]"
                        + "[" + instruction[i].getStatusIcon() + "]" + instruction[i].description);
            }
        }
        System.out.println("----------------------------------------");
    }

    public void instructionCompleted(int instructNum) {

        if (isEmpty) {
            System.out.println("Please add instruction first!");
        } else {
            instruction[instructNum].markInstructionAsDone();
            System.out.println("----------------------------------------");
            System.out.println("Nice! I've marked this task as done: ");
            System.out.println("[" + instruction[instructNum].getStatusIcon() + "]"
                    + " " + instruction[instructNum].description);
            System.out.println("----------------------------------------");
        }
    }

    // Other general instructions (Before Level 4)
   /* public void addInstruction(String description) {
        Task newInstruction = new Task(description);
        instruction[index] = newInstruction;
        index++;
        isEmpty = false;
    } */

    public void addToDo (String description) {
        Task newToDo = new Task(description);
        instruction[index] = newToDo;
        isEmpty = false;
        System.out.println("----------------------------------------");
        System.out.println("Got it. I've added this task: ");
        System.out.println("  [" + instruction[index].keyChar + "]"
                + "["+ instruction[index].getStatusIcon() + "]" + instruction[index].description);
        if (index == 0) {
            System.out.println("Now you have " + (index + 1) + " task in the list");
        }
        else{
            System.out.println("Now you have " + (index + 1) + " tasks in the list");
        }
        System.out.println("----------------------------------------");
        index++;
    }
    public void addDeadline(String description){
        Task newDeadline = new Task(description);
        instruction[index] = newDeadline;
        isEmpty = false;
        System.out.println("----------------------------------------");
        System.out.println("Got it. I've added this task: ");
        System.out.println("  [" + instruction[index].keyChar + "]"
                + "["+ instruction[index].getStatusIcon() + "]"
                + instruction[index].description + "(by: " + instruction[index].date + ")");
        if (index == 0) {
            System.out.println("Now you have " + (index + 1) + " task in the list");
        }
        else{
            System.out.println("Now you have " + (index + 1) + " tasks in the list");
        }
        System.out.println("----------------------------------------");
        index++;
    }

    public void addEvent(String description){
        Task newEvent = new Task(description);
        instruction[index] = newEvent;
        isEmpty = false;
        System.out.println("----------------------------------------");
        System.out.println("Got it. I've added this task: ");
        System.out.println("  [" + instruction[index].keyChar + "]"
                + "["+ instruction[index].getStatusIcon() + "]"
                + instruction[index].description + "(at: " + instruction[index].date + ")");
        if (index == 0) {
            System.out.println("Now you have " + (index + 1) + " task in the list");
        }
        else{
            System.out.println("Now you have " + (index + 1) + " tasks in the list");
        }
        System.out.println("----------------------------------------");
        index++;
    }
}