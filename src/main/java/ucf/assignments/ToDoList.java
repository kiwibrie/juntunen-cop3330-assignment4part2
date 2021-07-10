package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ToDoList {
    private final List<Item> list;
    private String title;

    public ToDoList(String title) {
        setTitle(title);
        list = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void AddItem(Item item){
        list.add(item);
    }

    public void SaveList(){
        //using Gson
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("ToDoList_"+getTitle()+".json"));

            Map<String, Object> savedlist = new HashMap<>();
            savedlist.put("title", getTitle());

            Map<String, Object> items = new HashMap<>();
            for(int i = 0; i < list.size(); i++){
                Map<String, Object> item = new HashMap<>();
                item.put("desc", list.get(i).getDescription());
                item.put("duedate", list.get(i).getDuedate());
                item.put("completed", list.get(i).getCompleted());
                items.put("item"+i, item);
            }

            Gson gson = new Gson();

            // write JSON to file
            writer.write(gson.toJson(savedlist));

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteList(){
        list.clear();
    }

    public void SortListAlphabetical(){
        list.sort(Comparator.comparing(Item::getDescription));
    }

    public void SortListDuedate(){
        list.sort(Comparator.comparing(Item::getDuedate));
    }

    public List<Item> DisplayComplete(){
        List<Item> completeEvents = new ArrayList<>();
        for (Item item : list) {
            if (item.getCompleted()) {
                completeEvents.add(item);
            }
        }
        return completeEvents;
    }

    public List<Item> DisplayIncomplete(){
        List<Item> incompleteEvents = new ArrayList<>();
        for (Item item : list) {
            if (!item.getCompleted()) {
                incompleteEvents.add(item);
            }
        }
        return incompleteEvents;
    }
}
