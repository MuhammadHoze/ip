import java.util.Scanner;

public class Duke {
    private static final int MAX_INSTRUCTION = 100;
    private static String[] instruction = new String[MAX_INSTRUCTION];
    private static Boolean[] instructionStatus = new Boolean[MAX_INSTRUCTION];
    private static int indexCount = 0; // Index to add in instructions to array
    private static boolean isEmpty = true; // To check if Instruction array is empty

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Welcome to\n" + logo);
        System.out.println("----------------------------------------");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("----------------------------------------");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        // if "Enter key" is pressed WITHOUT any input
        while(command.isEmpty()){
            System.out.println("Invalid Input, Please Try Again");
            command = sc.nextLine();
        }

        while (!"bye".equals(command)) {
            if (command.trim().equalsIgnoreCase("list")) {
                System.out.println("----------------------------------------");
                for (int i = 0; i < instruction.length; i++) {
                    if (instruction[i] == null) { // to prevent empty array values to show
                        if (isEmpty) {
                            System.out.println("List is currently empty");
                        }
                        break;
                    }
                    else {
                        System.out.println(i + 1 + ". " + "[" + getStatusIcon(i) + "]" + " " + instruction[i]);
                    }
                }
                System.out.println("----------------------------------------");
            }
            else if (command.trim().equalsIgnoreCase("bye")) {
                break;
            }
            else if (command.contains("done")) {
                if (isEmpty){
                    System.out.println("Please add instruction first!");
                }
                else {
                    //This is to get the instruction number
                    String value = command.replace("done", "").trim();
                    int instructNum = Integer.parseInt(value);
                    setInstruction(instructNum);
                    System.out.println("----------------------------------------");
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + getStatusIcon(instructNum - 1) + "]" + " " + instruction[instructNum - 1]);
                    System.out.println("----------------------------------------");
                }
            }
            else {
                System.out.println("----------------------------------------");
                System.out.println("added: "+ command );
                System.out.println("----------------------------------------");
                instruction[indexCount] = command;
                instructionStatus[indexCount] = false; //Initially
                isEmpty = false;
                indexCount++;
            }
            command = sc.nextLine();
            while(command.isEmpty()){
                System.out.println("Invalid Input, Please Try Again");
                command = sc.nextLine();
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("----------------------------------------");
    }

    public static String getStatusIcon(int index) {
        if (instructionStatus[index].equals(false)) {
            return "\u2718";
        }
        else {
            return "\u2713";
        }
    }

    //This function is to mark instruction number as completed
    public static void setInstruction(int taskNum) {
        instructionStatus[taskNum - 1] = true; //will set that taskNum to true
    }
}