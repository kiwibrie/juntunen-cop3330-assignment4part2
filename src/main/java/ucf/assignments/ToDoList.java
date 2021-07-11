package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ToDoList {
    public List<Item> list;
    private String title;

    public ToDoList(String title) {
        setTitle(title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Item getItem(int x){
        return list.get(x);
    }

    public void AddItem(Item item){
        list.add(item);
    }

    public void DeleteItem(Item item){
        list.remove(item);
    }

    public void SaveList(String path){
        //using Gson
        try {
            //todo make a path and create ToDoList_Title.json
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

    public ToDoList LoadList(String path) {
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
            //MasterList.add(loadedlist);

            reader.close();
            return loadedlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ClearList(){
        list.clear();
    }

    public List<Item> SortListAlphabetical(){
        List<Item> sortedlist = list;
        sortedlist.sort(Comparator.comparing(Item::getDescription));
        return sortedlist;
    }

    public List<Item> SortListDuedate(){
        List<Item> sortedlist = list;
        sortedlist.sort(Comparator.comparing(Item::getDuedate));
        return sortedlist;
    }

    public List<Item> GetComplete(){
        List<Item> completeEvents = new ArrayList<>();
        for (Item item : list) {
            if (item.getCompleted()) {
                completeEvents.add(item);
            }
        }
        return completeEvents;
    }

    public List<Item> GetIncomplete(){
        List<Item> incompleteEvents = new ArrayList<>();
        for (Item item : list) {
            if (!item.getCompleted()) {
                incompleteEvents.add(item);
            }
        }
        return incompleteEvents;
    }
}
