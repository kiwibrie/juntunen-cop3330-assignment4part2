package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    String name;
    public static ObservableList<Item> list;

    public ToDoList(String title){
        this.name = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void AddItem(String description, LocalDate duedate){
        Item item = new Item(description, duedate);
        list.add(item);
    }

    //delete item
        //search list for x
        //delete x

    //sort list
        //sort by duedate
        //sort by alphabetical

    //display/hide *not quite sure the best way to do this yet*
        //complete
        //incomplete

    //save list
        //convert each item to format
        //export

    //delete list
        //delete every item
        //delete empty list
}
