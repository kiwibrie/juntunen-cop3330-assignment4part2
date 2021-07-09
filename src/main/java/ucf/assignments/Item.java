package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.time.LocalDate;

public class Item {
    String description;
    LocalDate duedate;
    boolean complete; //status

    public Item(String description, LocalDate duedate){
        setDescription(description);
        setDuedate(duedate);
        setStatus(false);
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

    public void setStatus(boolean status) {
        this.complete = status;
    }

    public boolean getStatus(){
        return complete;
    }

    //desc setter
    //desc getter

    //duedate setter
        //check validity (good month, good day)
    //dudeate getter

    //status setter
    //status getter
}
