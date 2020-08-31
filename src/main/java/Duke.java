import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        List listItem = new List();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to\n" + logo);
        System.out.println("----------------------------------------");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("----------------------------------------");
        String command = sc.nextLine();

        // if "Enter key" is pressed WITHOUT any input
        while(command.isEmpty()){
            System.out.println("Invalid Input, Please Try Again");
            command = sc.nextLine();
        }

        // This loop is to process the commands input by user
        while (!"bye".equals(command) && !command.trim().equalsIgnoreCase("bye")) {
            if (command.trim().equalsIgnoreCase("list")) {
                listItem.printList(); //object is calling function called printList()
            }
            else if (command.contains("done")) {
                //This is to get the instruction number
                String value = command.replace("done", "").trim();
                int instructNum = Integer.parseInt(value);
                listItem.instructionCompleted(instructNum-1);
            }
            else if (command.contains("todo")) {
                String todoInstruction = command.replace("todo", "T").trim();
                listItem.addToDo(todoInstruction);
            }
            else if (command.contains("deadline")){
                String deadlineInstruction = command.replace("deadline", "D").trim();
                listItem.addDeadline(deadlineInstruction);

            }
            else if (command.contains("event")){
                String eventInstruction = command.replace("event", "E").trim();
                listItem.addEvent(eventInstruction);
            }
            //Other general Instructions (Before Level 4)
            /*
            else {
                System.out.println("----------------------------------------");
                System.out.println("added: " + command );
                System.out.println("----------------------------------------");
                listItem.addInstruction(command);
            } */
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
}