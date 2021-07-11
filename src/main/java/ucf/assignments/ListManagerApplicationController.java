package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ListManagerApplicationController {
    @FXML public MenuItem EditItem;
    @FXML public CheckMenuItem SortDueDate;
    @FXML public CheckMenuItem SortAlphabetical;
    @FXML public MenuItem NewItem;
    @FXML public Label ListTitle;
    @FXML public CheckMenuItem CompletedToggle;
    @FXML public MenuItem DeleteItem;
    @FXML public Button NewList;
    @FXML public MenuItem About;
    @FXML public MenuItem DeleteList;
    @FXML public MenuItem LoadList;
    @FXML public MenuItem SaveList;
    @FXML public MenuItem CloseApp;
    @FXML public MenuItem EditList;
    @FXML public ListView ItemViewer;
    @FXML public ListView ListViewer;

    //FILE
    @FXML
    public void CloseAppClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

    //EDIT
    @FXML
    public void SaveListClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void LoadListClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void DeleteListClicked(ActionEvent actionEvent) {
    }

    //HELP
    @FXML
    public void AboutClicked(ActionEvent actionEvent) {
    }

    //LIST SIDE
    @FXML
    public void NewListClicked(ActionEvent actionEvent) {
        //open a new window for creating a list
    }

    //ITEM SIDE - EDIT
    @FXML
    public void NewItemClicked(ActionEvent actionEvent) {
        //open a window for creating an item
        //allow user to edit whatever
        //todo: when button in window is clicked, write information and create list
    }

    @FXML
    public void SortAlphaClicked(ActionEvent actionEvent) {
        SortDueDate.setSelected(false);

        if(SortAlphabetical.isSelected()){
            //for the current list, display sorted alpha list
            //update ItemViewer
        } else {
            //for the current list, display unsorted list
            //update ItemViewer
        }
    }

    @FXML
    public void SortDueDateClicked(ActionEvent actionEvent) {
        SortAlphabetical.setSelected(false);

        if(SortDueDate.isSelected()){
            //for the current list, display sorted due date list
            //update ItemViewer
        } else {
            //for the current list, display unsorted list
            //update ItemViewer
        }
    }

    @FXML
    public void EditListClicked(ActionEvent actionEvent) {
        //for the current list, open window for creating a list with prefilled info
        //allow user to edit whatever
        //todo: when button in window is clicked, overwrite information
    }

    //ITEM SIDE - ITEMS
    @FXML
    public void ToggleCompletedClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void EditItemClicked(ActionEvent actionEvent) {
    }

    @FXML
    public void DeleteItemClicked(ActionEvent actionEvent) {
    }

}
