package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToDoListTest {
    ToDoList list = new ToDoList("title");

    @Test
    public void gettitle(){
        assertEquals("title", list.getTitle());
    }
    @Test
    public void settitle(){
        list.setTitle("changed title");
        assertEquals("changed title", list.getTitle());
    }

    @Test
    public void getitem(){
        additem();
        assertEquals("desc", list.getItem(0).getDescription());
        assertEquals("01011970", list.getItem(0).getDuedate());
        assertFalse(list.getItem(0).getCompleted());
    }

    @Test
    public void additem(){
        Item item = new Item("desc", "01011970", false);
        list.AddItem(item);
    }

    @Test
    public void deleteitem(){
        additem();
        list.DeleteItem(list.getItem(0));
        assertEquals(0, list.list.size());
    }

    @Test
    public void sortalpha(){
        Item shouldbefirst = new Item("alpha", "07112021", false);
        list.AddItem(new Item("omega", "01011970", true));
        list.AddItem(new Item("beta", "07102021", false));
        list.AddItem(shouldbefirst);
        assertEquals(shouldbefirst, list.SortListAlphabetical().get(0));
    }

    @Test
    public void sortduedate(){
        Item shouldbefirst = new Item("omega", "01011970", true);
        list.AddItem(new Item("alpha", "07112021", false));
        list.AddItem(new Item("beta", "07102021", false));
        list.AddItem(shouldbefirst);
        assertEquals(shouldbefirst, list.SortListDuedate().get(0));
    }

    @Test
    public void displaycomplete(){
        list.AddItem(new Item("alpha", "07112021", false));
        list.AddItem(new Item("beta", "07102021", false));
        list.AddItem(new Item("omega", "01011970", true));
        assertEquals(1, list.DisplayComplete().size());
    }

    @Test
    public void displayincomplete(){
        list.AddItem(new Item("alpha", "07112021", false));
        list.AddItem(new Item("beta", "07102021", false));
        list.AddItem(new Item("omega", "01011970", true));
        assertEquals(2, list.DisplayIncomplete().size());
    }

    //save list to file

    @Test
    public void clearlist(){
        additem();
        list.ClearList();
        assertEquals(0, list.list.size());
    }

}