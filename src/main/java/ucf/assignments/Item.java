package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.time.LocalDate;

public class Item {
    private String description;
    private LocalDate duedate;
    private boolean completed;

    public Item(String desc, LocalDate duedate){
        setDescription(desc);
        setDuedate(duedate);
        setCompleted(false);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return completed;
    }
}
