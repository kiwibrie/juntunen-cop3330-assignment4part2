package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import javax.swing.*;

public class ListManagerSceneController {

    @FXML
    private MenuItem SaveList;

    @FXML
    private MenuItem LoadList;

    @FXML
    private MenuItem DeleteList;

    @FXML
    private MenuItem HelpPage;

    @FXML
    public void NewListMenuClicked(ActionEvent actionEvent) {
        //display new window with text boxes
        //create a new list from window information
        ListManager.AddList("title");
    }

    @FXML
    public void DeleteListMenuClicked(ActionEvent actionEvent) {
        //display a window showing all lists
        //user selects which lists to delete
        //secondary pop-up -- are you sure?
        //iterate, deleting each list
    }

    @FXML
    public void TodayButtonClicked(ActionEvent actionEvent) {
        //display all items due today
    }

    @FXML
    public void TomorrowButtonClicked(ActionEvent actionEvent) {
        //display all items due tomorrow
    }

    @FXML
    public void ListButtonClicked(ActionEvent actionEvent) {
        //display all items in selected list
    }
}

