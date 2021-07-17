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
        assertEquals("19700101", list.getItem(0).getDuedate());
        assertFalse(list.getItem(0).getCompleted());
    }

    @Test
    public void additem(){
        Item item = new Item("desc", "19700101", false);
        list.addItem(item);
    }

    @Test
    public void deleteitem(){
        additem();
        list.deleteItem(list.getItem(0));
        assertEquals(0, list.list.size());
    }

    @Test
    public void sortalpha(){
        Item shouldbefirst = new Item("alpha", "20210711", false);
        list.addItem(new Item("omega", "19700101", true));
        list.addItem(new Item("beta", "20210710", false));
        list.addItem(shouldbefirst);
        assertEquals(shouldbefirst, list.sortListAlphabetical().get(0));
    }

    @Test
    public void sortduedate(){
        Item shouldbefirst = new Item("omega", "19700101", true);
        list.addItem(new Item("alpha", "20210711", false));
        list.addItem(new Item("beta", "20210710", false));
        list.addItem(shouldbefirst);
        assertEquals(shouldbefirst, list.sortListDuedate().get(0));
    }

    @Test
    public void getcomplete(){
        list.addItem(new Item("alpha", "20210711", false));
        list.addItem(new Item("beta", "20210710", false));
        list.addItem(new Item("omega", "19700101", true));
        assertEquals(1, list.getComplete().size());
    }

    @Test
    public void getincomplete(){
        list.addItem(new Item("alpha", "20210711", false));
        list.addItem(new Item("beta", "20210710", false));
        list.addItem(new Item("omega", "19700101", true));
        assertEquals(2, list.getIncomplete().size());
    }

    @Test
    public void savelist(){
        ToDoList testsave = new ToDoList("TEST Save");
        testsave.addItem(new Item("item1", "19700101", false));
        testsave.addItem(new Item("item2", "20210711", true));
        testsave.saveList("C:\\Users\\brian\\Documents\\Downloads");
    }

    @Test
    public void loadlist(){
        list.loadList("C:\\Users\\brian\\Documents\\Downloads\\ToDoList.json");
        System.out.print(list.getTitle());
    }

    @Test
    public void clearlist(){
        additem();
        assertEquals(3, list.list.size());
        list.clearList();
        assertEquals(0, list.list.size());
    }

}