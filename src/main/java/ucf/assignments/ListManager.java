package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListManager {
    List<ToDoList> MasterList = new ArrayList<>();

    public ToDoList getList(int x){
        return MasterList.get(x);
    }

    public void AddList(String title){
        ToDoList list = new ToDoList(title);
        MasterList.add(list);
    }

    public void SaveLists(List<ToDoList> selected, String path){
        for (ToDoList selectedList : selected) {
            for (ToDoList todoList : MasterList) {
                if (selectedList == todoList) {
                    todoList.SaveList(path);
                }
            }
        }
        RemoveSelection(selected);
    }

    public void DeleteLists(List<ToDoList> selected){
        for (ToDoList selectedList : selected) {
            for (ToDoList todoList : MasterList) {
                if (selectedList == todoList) {
                    todoList.ClearList();
                    MasterList.remove(todoList);
                }
            }
        }
        RemoveSelection(selected);
    }

    private void RemoveSelection(List<ToDoList> selected){
        for (ToDoList toDoList : selected) {
            toDoList.ClearList();
        }
    }

    public void LoadList(String path) {
        //using Gson
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

            String title = parser.get("title").getAsString();
            ToDoList loadedlist = new ToDoList(title);
            loadedlist.setTitle(title);

            for (JsonElement item : parser.get("items").getAsJsonArray()) {
                JsonObject obj = item.getAsJsonObject();
                Item createditem = new Item(
                        obj.get("desc").getAsString(),
                        obj.get("duedate").getAsString(),
                        obj.get("completed").getAsBoolean());
                loadedlist.AddItem(createditem);
            }
            MasterList.add(loadedlist);

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

