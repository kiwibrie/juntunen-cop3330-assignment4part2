package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

public class Item {
    private String description;
    private int duedate;
    private boolean completed;

    public Item(String desc, String duedate, boolean completed){
        setDescription(desc);
        setDuedate(Integer.parseInt(duedate));
        setCompleted(completed);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDuedate(int duedate) {
        this.duedate = duedate;
    }

    public int getDuedate() {
        return duedate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return completed;
    }
}
