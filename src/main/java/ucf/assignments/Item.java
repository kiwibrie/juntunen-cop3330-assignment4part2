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
        if(verifyDescription(description)){
          this.description = description;
        } else {
            this.description = "New Item";
        }
    }

    public String getDescription() {
        return description;
    }

    public boolean verifyDescription(String desc){
        return desc.length() > 0 && desc.length() < 257;
    }

    public void setDuedate(String duedate) {
        if(!verifyDueDate(duedate)){
            duedate = String.format(duedate, "%tF");
        }
        this.duedate = duedate;
    }

    public String getDuedate() {
        return duedate;
    }

    public boolean verifyDueDate(String duedate){
        return (duedate.length() == 10) && duedate.matches("\\d\\d\\d\\d-\\d\\d-\\d\\d");
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return completed;
    }
}
