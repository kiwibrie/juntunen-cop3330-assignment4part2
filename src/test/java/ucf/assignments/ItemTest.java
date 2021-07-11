package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item item = new Item("desc", "01011970", false);

    @Test
    public void getdesc(){
        assertEquals("desc", item.getDescription());
    }
    @Test
    public void setdesc(){
        item.setDescription("changed description");
        assertEquals("changed description", item.getDescription());
    }

    @Test
    public void getduedate(){
        assertEquals("01011970", item.getDuedate());
    }
    @Test
    public void setduedate(){
        item.setDuedate("07112021");
        assertEquals("07112021", item.getDuedate());
    }

    @Test
    public void getstatus(){
        assertFalse(item.getCompleted());
    }
    @Test
    public void setstatus(){
        item.setCompleted(true);
        assertTrue(item.getCompleted());
    }
}