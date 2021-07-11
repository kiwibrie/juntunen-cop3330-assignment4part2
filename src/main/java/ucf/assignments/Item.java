package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

public class Item {
    private String description; //max 256
    private String duedate; //YYYY-MM-DD
    private boolean completed;

    public Item(String desc, String duedate, boolean completed){
        setDescription(desc);
        setDuedate(duedate);
        setCompleted(completed);
    }

    public void setDescription(String description) {
        if(description.length() <= 256){
            this.description = description;
        } else {
            this.description = description.substring(0,256);
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return completed;
    }
}
