package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Brianne Juntunen
 */

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ListManagerApplicationController {
    private static final ListManager masterlistmasterlist = new ListManager();

    public static void setup(){
        masterlistmasterlist.AddList("New List");
    }

    //PRIMARY SCENE
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
    @FXML public ListView<Item> ItemViewer;
    @FXML public ListView<ToDoList> ListViewer;
    @FXML public CheckMenuItem ShowComplete;
    @FXML public CheckMenuItem ShowIncomplete;

    //FILE
    @FXML
    public void CloseAppClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

    //EDIT
    @FXML
    public void SaveListClicked(ActionEvent actionEvent) {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DirectoryScene.fxml")));
            Scene scene = new Scene(root);
            Stage directorystage = new Stage();

            directorystage.setScene(scene);
            directorystage.setResizable(false);
            directorystage.setTitle("Choose Path");
            directorystage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HelpScene.fxml")));
            Scene scene = new Scene(root);
            Stage helpstage = new Stage();

            helpstage.setScene(scene);
            helpstage.setResizable(false);
            helpstage.setTitle("Help");
            helpstage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //LIST SIDE
    @FXML
    public void NewListClicked(ActionEvent actionEvent) {
        masterlistmasterlist.AddList("New List");
        updateListViewer();
    }

    //ITEM SIDE - EDIT
    @FXML
    public void NewItemClicked(ActionEvent actionEvent) {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateItemScene.fxml")));
            Scene scene = new Scene(root);
            Stage createitemstage = new Stage();

            createitemstage.setScene(scene);
            createitemstage.setResizable(false);
            createitemstage.setAlwaysOnTop(true);
            createitemstage.setTitle("New Item");
            createitemstage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SortAlphaClicked(ActionEvent actionEvent) {
        SortDueDate.setSelected(false);

        if(SortAlphabetical.isSelected()){
            ToDoList alphalist = (ToDoList) masterlistmasterlist.getList(0).SortListAlphabetical();
            updateItemViewer(alphalist);
        } else {
            updateItemViewer(masterlistmasterlist.getList(0));
        }
    }

    @FXML
    public void SortDueDateClicked(ActionEvent actionEvent) {
        SortAlphabetical.setSelected(false);

        if(SortDueDate.isSelected()){
            ToDoList duedatelist = (ToDoList) masterlistmasterlist.getList(0).SortListDuedate();
            updateItemViewer(duedatelist);
        } else {
            updateItemViewer(masterlistmasterlist.getList(0));
        }
    }

    @FXML
    public void ShowCompleteClicked(ActionEvent actionEvent) {
        ShowIncomplete.setSelected(false);

        if(ShowComplete.isSelected()){
            ToDoList complist = (ToDoList) masterlistmasterlist.getList(0).GetComplete();
            updateItemViewer(complist);
        } else {
            updateItemViewer(masterlistmasterlist.getList(0));
        }
    }

    @FXML
    public void ShowIncompleteClicked(ActionEvent actionEvent) {
        ShowComplete.setSelected(false);

        if(ShowIncomplete.isSelected()){
            ToDoList incomplist = (ToDoList) masterlistmasterlist.getList(0).GetIncomplete();
            updateItemViewer(incomplist);
        } else {
            updateItemViewer(masterlistmasterlist.getList(0));
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
        Item thisitem = masterlistmasterlist.getList(0).getItem(ItemViewer.getEditingIndex());
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditItemScene.fxml")));
            Scene scene = new Scene(root);
            Stage edititemstage = new Stage();

            edititemstage.setScene(scene);
            edititemstage.setResizable(false);
            edititemstage.setAlwaysOnTop(true);
            edititemstage.setTitle("Edit Item");
            edititemstage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void DeleteItemClicked(ActionEvent actionEvent) {
        Item thisitem = masterlistmasterlist.getList(0).getItem(ItemViewer.getEditingIndex());
        masterlistmasterlist.getList(0).DeleteItem(thisitem);
    }

    @FXML
    public void updateListViewer(){
        ListViewer.setItems((ObservableList<ToDoList>) masterlistmasterlist.MasterList);
    }

    @FXML
    public void updateItemViewer(ToDoList list){
        ItemViewer.setItems((ObservableList<Item>) list);
    }



    //CREATE NEW ITEM SCENE CONTROLS

    @FXML public Button AddItem;
    @FXML public Button CancelButton;
    @FXML public CheckBox CompletedBox;
    @FXML public DatePicker DueDateBox;
    @FXML public TextField DescriptionTextBox;

    @FXML
    public void AddItemClicked(ActionEvent actionEvent) {
        String desc = DescriptionTextBox.getText();
        String date = DueDateBox.toString();
        boolean completed = CompletedBox.isSelected();
        Item newitem = new Item(desc, date, completed);
        masterlistmasterlist.getList(0).AddItem(newitem);
        updateItemViewer(masterlistmasterlist.getList(0));
        Stage stage = (Stage) AddItem.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void CancelClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    //EDIT ITEM SCENE CONTROLS
    @FXML public Button SaveChanges;

    @FXML
    public void SaveChangesClicked(ActionEvent actionEvent) {
        Item thisitem = masterlistmasterlist.getList(0).getItem(ItemViewer.getEditingIndex());
        thisitem.setDescription(DescriptionTextBox.getText());
        thisitem.setDuedate(DueDateBox.toString());
        thisitem.setCompleted(CompletedBox.isSelected());
        updateItemViewer(masterlistmasterlist.getList(0));
        Stage stage = (Stage) SaveChanges.getScene().getWindow();
        stage.close();
    }

    //SAVE AND LOAD STUFF
    @FXML public TextField DirectoryTextBox;
    @FXML public Button PathOK;

    @FXML
    public void PathOKClicked() {
        List<ToDoList> list = new ArrayList<>();
        list.add(masterlistmasterlist.getList(0));
        masterlistmasterlist.SaveLists(list, DirectoryTextBox.getText());
    }
}
