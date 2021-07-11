package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListManagerTest {
    ListManager masterlist = new ListManager();

    @Test
    public void getlist(){
        masterlist.AddList("title");
        assertEquals(masterlist.MasterList.get(0).getTitle(), masterlist.getList(0).getTitle());
    }

    @Test
    public void addlist(){
        masterlist.AddList("title");
        assertEquals("title", masterlist.MasterList.get(0).getTitle());
    }

    @Test
    public void deletelist(){
        masterlist.AddList("title");
        masterlist.AddList("second list");
        List<ToDoList> selectedlists = new ListManager().MasterList;
        selectedlists.add(masterlist.MasterList.get(0));
        masterlist.DeleteLists(selectedlists);
        assertEquals(1, masterlist.MasterList.size());
    }

    //test SaveList() (should go through todolist)
    public void savelist(){
        //todo: savelist test in ListManagerTest.java
    }

    //test LoadList() (should go through todolist)
    public void loadlist(){
        //todo: loadlist test in ListManagerTest.java
    }
}