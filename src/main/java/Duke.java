import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        ArrayList<String> books = new ArrayList<String>();
        //String[] loan = new String[100]; // borrow the books
        //String[] restore = new String[100]; // return the books
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
            case "read book":
                System.out.println("--------------------------------------");
                System.out.println("added: read book");
                books.add("read book");
                System.out.println("--------------------------------------");
                break;
            case "return book":
                System.out.println("--------------------------------------");
                System.out.println("added: return book");
                books.add("return book");
                System.out.println("--------------------------------------");
                break;
            case "list":
                System.out.println("--------------------------------------");
                for(int i = 0; i < books.size(); i++){
                    System.out.println(i+1 + ". " + books.get(i)); //get the element from the ArrayList
                }
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
