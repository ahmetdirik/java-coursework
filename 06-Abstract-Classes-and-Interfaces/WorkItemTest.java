abstract class WorkItem {
    protected String description;

    public WorkItem(String description) {
        this.description = description;
    }

    public void displayDescription() {
        System.out.println("Work Item: " + description);
    }

    public abstract String getProgress();
}
class SimpleChore extends WorkItem {
    private boolean isDone;

    public SimpleChore(String description, boolean isDone) {
        super(description);
        this.isDone = isDone;
    }

    @Override
    public String getProgress() {
        return isDone ? "Completed" : "Pending";
    }
}
public class WorkItemTest {
    public static void main(String[] args) {
        SimpleChore chore1 = new SimpleChore("Water plants", false);
        chore1.displayDescription();
        System.out.println("Progress: " + chore1.getProgress());

        SimpleChore chore2 = new SimpleChore("Pay electricity bill", true);
        chore2.displayDescription();
        System.out.println("Progress: " + chore2.getProgress());
    }
}
