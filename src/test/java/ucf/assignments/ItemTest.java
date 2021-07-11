package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item item = new Item("desc", "19700101", false);

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
    public void setlongdesc(){
        String teststring = "THIS STRING IS 256 CHARACTERS xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxLAST"
                +"ADDING CHARACTERS FOR GOOD MEASURE"; //https://gist.github.com/hishma/10153402
        item.setDescription(teststring);
        assertNotEquals(teststring, item.getDescription());
        System.out.print(item.getDescription()+"\n");
    }

    @Test
    public void getduedate(){
        assertEquals("19700101", item.getDuedate());
    }
    @Test
    public void setduedate(){
        item.setDuedate("20210711");
        assertEquals("20210711", item.getDuedate());
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