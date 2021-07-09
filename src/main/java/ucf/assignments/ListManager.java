package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.util.ArrayList;
import java.util.List;

public class ListManager {
    static List<ToDoList> MasterList;

    public static void AddList(String title){
        ToDoList list = new ToDoList(title);
        MasterList.add(list);
    }

    //delete selected list(s)
        //search list for x
        //call that list's delete method
        //repeat for every selected list

    //save selected list(s)
        //search list for x
        //call that list's save method
        //repeat for every selected list

    //load list(s) from storage
        //read data from external file
        //AddList() using the translated data
        //repeat for every list in file
}
