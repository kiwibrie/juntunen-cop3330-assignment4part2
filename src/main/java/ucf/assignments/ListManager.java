package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.util.ArrayList;
import java.util.List;

public class ListManager {
    List<ToDoList> MasterList = new ArrayList<>();

    public void SaveLists(List<ToDoList> selected){
        for (ToDoList selectedList : selected) {
            for (ToDoList todoList : MasterList) {
                if (selectedList == todoList) {
                    todoList.SaveList();
                }
            }
        }
        RemoveSelection(selected);
    }

    public void DeleteLists(List<ToDoList> selected){
        for (ToDoList selectedList : selected) {
            for (ToDoList todoList : MasterList) {
                if (selectedList == todoList) {
                    todoList.DeleteList();
                }
            }
        }
        RemoveSelection(selected);
    }

    private void RemoveSelection(List<ToDoList> selected){
        for (ToDoList toDoList : selected) {
            toDoList.DeleteList();
        }
    }

    public void LoadList() {
        //todo: LoadList(). needs to read from file
        //read info from file
        //String title = (read from file);
        //while(there is next line) {
            //create new item from line
        //}
        //ToDoList createdToDoList = new ToDoList(title);
        //MasterList.add(createdToDoList);
    }

}

