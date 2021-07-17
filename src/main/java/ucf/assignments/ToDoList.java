package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ToDoList {
    public List<Item> list;
    private String title;

    public ToDoList(String title) {
        setTitle(title);
        this.list = new ArrayList<>();
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

    public void addItem(Item item){
        list.add(item);
    }

    public void deleteItem(Item item){
        list.remove(item);
    }

    public void saveList(String path){
        //using Gson
        Gson gson = new Gson();
        File saveFile = new File(path+"/ToDoList.json");
        if(!saveFile.exists()){
            try {
                File directory = new File(saveFile.getParent());
                if(!directory.exists()){
                    if(!directory.mkdirs()) System.out.println("error creating directories");
                }
                if(!saveFile.createNewFile()) System.out.println("error creating new file");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(saveFile.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            Map<String, Object> savinglist = new HashMap<>();
            savinglist.put("title", this.getTitle());

            Map<String, Object> items = new HashMap<>();
            for(int i = 0; i < list.size(); i++){
                Map<String, Object> item = new HashMap<>();
                item.put("description", this.getItem(i).getDescription());
                item.put("duedate", this.getItem(i).getDuedate());
                item.put("completed", this.getItem(i).getCompleted());
                items.put("item"+i, item);
            }
            savinglist.put("all items", items);

            bufferedWriter.write(gson.toJson(savinglist));
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ToDoList loadList(String path) {
        //using Gson
        try {
            Path genpath = Paths.get(path);
            Path fullpath = genpath.toAbsolutePath();
            Reader reader = Files.newBufferedReader(fullpath);
            JsonObject parser = JsonParser.parseReader(reader).getAsJsonObject();

            String title = parser.get("title").getAsString();
            ToDoList loadedlist = new ToDoList(title);
            loadedlist.setTitle(title);

            for (JsonElement item : parser.get("items").getAsJsonArray()) {
                JsonObject obj = item.getAsJsonObject();
                Item createditem = new Item(
                        obj.get("description").getAsString(),
                        obj.get("duedate").getAsString(),
                        obj.get("completed").getAsBoolean());
                loadedlist.addItem(createditem);
            }
            this.list = loadedlist.list;
            this.title = loadedlist.getTitle();

            reader.close();
            return loadedlist;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void clearList(){
        list.clear();
    }

    public List<Item> sortListAlphabetical(){
        List<Item> sortedlist = list;
        sortedlist.sort(Comparator.comparing(Item::getDescription));
        return sortedlist;
    }

    public List<Item> sortListDuedate(){
        List<Item> sortedlist = list;
        sortedlist.sort(Comparator.comparing(Item::getDuedate));
        return sortedlist;
    }

    public List<Item> getComplete(){
        List<Item> completeEvents = new ArrayList<>();
        for (Item item : list) {
            if (item.getCompleted()) {
                completeEvents.add(item);
            }
        }
        return completeEvents;
    }

    public List<Item> getIncomplete(){
        List<Item> incompleteEvents = new ArrayList<>();
        for (Item item : list) {
            if (!item.getCompleted()) {
                incompleteEvents.add(item);
            }
        }
        return incompleteEvents;
    }
}
