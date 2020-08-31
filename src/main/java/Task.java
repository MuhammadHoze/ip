public class Task {

    protected String description;
    protected String date;
    protected boolean isDone;
    protected String keyChar; // To identify: ToDo, Deadline, Event

    //This description is the string command
    public Task(String description) {
        this.keyChar = description.substring(0,1);

        if (keyChar.equals("T")) {
            this.description = description.substring(1);
        }
        else if (keyChar.equals("D")){
            this.description = description.substring(1, description.lastIndexOf("/"));
            this.date = description.substring(description.lastIndexOf(" ") + 1); // the space after by + 1 = Sunday
        }
        else if (keyChar.equals("E")) {
            this.description = description.substring(1, description.lastIndexOf("/"));
            this.date = description.substring(description.lastIndexOf("/") + 4); // the space after by + 1 = Sunday
        }
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markInstructionAsDone(){
        isDone = true;
    }
}