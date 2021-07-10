package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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

    public void SaveList(){
        //todo: SaveList(). needs to write to file
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
