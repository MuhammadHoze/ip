import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println("Welcome to\n" + logo);
        System.out.println("--------------------------------------");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        System.out.println("--------------------------------------");

        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();

        while (!"bye".equals(command)) {
            switch (command) {
            case "list":
                System.out.println("--------------------------------------");
                System.out.println("list");
                System.out.println("--------------------------------------");
                break;
            case "blah":
                System.out.println("--------------------------------------");
                System.out.println("blah");
                System.out.println("--------------------------------------");
                break;
            }
            command = sc.nextLine();
        }
        System.out.println("--------------------------------------");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("--------------------------------------");
    }
}
