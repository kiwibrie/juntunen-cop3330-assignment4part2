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
        for(int i = 0; i < selected.size(); i++){
            for(int j = 0; j < MasterList.size(); j++){
                if(selected.get(i) == MasterList.get(j)){
                    MasterList.get(j).SaveList();
                }
            }
        }
        RemoveSelection(selected);
    }

    public void DeleteLists(List<ToDoList> selected){
        for(int i = 0; i < selected.size(); i++){
            for(int j = 0; j < MasterList.size(); j++){
                if(selected.get(i) == MasterList.get(j)){
                    MasterList.get(j).DeleteList();
                }
            }
        }
        RemoveSelection(selected);
    }

    private void RemoveSelection(List<ToDoList> selected){
        for(int i = 0; i < selected.size(); i++){
            selected.get(i).DeleteList();
        }
    }

    public void LoadList(){
        //todo: LoadList(). needs to read from file
        //read info from file
        //String title = (read from file);
        //ToDoList createdToDoList = new ToDoList(title);
        //MasterList.add(createdToDoList);
    }

}

