package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ListManagerApplicationController2 {
    ToDoList masterlist;

    @FXML public Button NewList;
    @FXML
    public void NewListClicked(ActionEvent actionEvent) {
        NewList.setDisable(true);
        masterlist = new ToDoList("My List");
        UpdateListViewer();
        UpdateItemViewer(masterlist);
    }

    //---------------------------------------------------------- TOP TOOLBAR
    //FILE
    @FXML public MenuItem CloseApp;

    @FXML
    public void CloseAppClicked() {
        Platform.exit();
    }

    //HELP
    @FXML public MenuItem About;

    @FXML
    public void AboutClicked() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HelpScene.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Help");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //EDIT
    @FXML public MenuItem SaveList;
    @FXML public MenuItem LoadList;
    @FXML public MenuItem DeleteList;

    @FXML
    public void SaveListClicked(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SaveScene.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Get Path");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void LoadListClicked(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoadScene.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Get Path");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void DeleteListClicked(ActionEvent actionEvent) {
        masterlist.ClearList();
        UpdateItemViewer(masterlist);
    }

    //---------------------------------------------------------- SAVE SCENE
    @FXML public Button SaveOK;
    @FXML public Button CancelButton;
    @FXML public TextField DirectoryTextBox;

    @FXML
    public void SaveOKClicked(ActionEvent actionEvent) {
        String path = DirectoryTextBox.getText();
        masterlist.SaveList(path);
        Stage toClose = (Stage) SaveOK.getScene().getWindow();
        toClose.close();
    }

    @FXML
    public void CancelClicked(ActionEvent actionEvent) {
        Stage toClose = (Stage) CancelButton.getScene().getWindow();
        toClose.close();
    }

    //---------------------------------------------------------- LOAD SCENE
    @FXML public Button LoadOK;

    @FXML public void LoadOKClicked(ActionEvent actionEvent) {
        String path = DirectoryTextBox.getText();
        masterlist.LoadList(path);
        UpdateListViewer();
        UpdateItemViewer(masterlist);
        Stage toClose = (Stage) LoadOK.getScene().getWindow();
        toClose.close();
    }

    //---------------------------------------------------------- LEFT HAND PANE
    @FXML public ListView<String> ListViewer;
    @FXML public Label ListTitle;

    @FXML
    public void UpdateListViewer(){
        ObservableList<String> viewinglist = FXCollections.observableArrayList();
        viewinglist.add(masterlist.getTitle());
        ListViewer.setItems(viewinglist);
    }

    //---------------------------------------------------------- RIGHT HAND PANE
    //list viewer
    @FXML public ListView<Item> ItemViewer;

    @FXML
    public void UpdateItemViewer(ToDoList todolist){
        ObservableList<Item> itemviewinglist = FXCollections.observableArrayList();
        for(int i = 0; i < todolist.list.size(); i++){
            itemviewinglist.add(todolist.getItem(i));
        }
        ItemViewer.setItems(itemviewinglist);
        ListTitle.textProperty().set(masterlist.getTitle());
    }

    //edit menu
    @FXML public MenuItem NewItem;
    @FXML public CheckMenuItem SortAlphabetical;
    @FXML public CheckMenuItem SortDueDate;
    @FXML public CheckMenuItem ShowComplete;
    @FXML public CheckMenuItem ShowIncomplete;
    @FXML public MenuItem EditList;

    @FXML
    public void NewItemClicked(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CreateItemScene.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Create New Item");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SortAlphaClicked(ActionEvent actionEvent) {
        SortDueDate.setSelected(false);
        ShowComplete.setSelected(false);
        ShowIncomplete.setSelected(false);

        if(SortAlphabetical.isSelected()){
            UpdateItemViewer((ToDoList) masterlist.SortListAlphabetical());
        } else {
            UpdateItemViewer(masterlist);
        }
    }

    @FXML
    public void SortDueDateClicked(ActionEvent actionEvent) {
        SortAlphabetical.setSelected(false);
        ShowComplete.setSelected(false);
        ShowIncomplete.setSelected(false);

        if(SortDueDate.isSelected()){
            UpdateItemViewer((ToDoList) masterlist.SortListDuedate());
        } else {
            UpdateItemViewer(masterlist);
        }
    }

    @FXML
    public void ShowCompleteClicked(ActionEvent actionEvent) {
        ShowIncomplete.setSelected(false);
        SortAlphabetical.setSelected(false);
        SortDueDate.setSelected(false);

        if(ShowComplete.isSelected()){
            UpdateItemViewer((ToDoList) masterlist.GetComplete());
        } else {
            UpdateItemViewer(masterlist);
        }
    }

    @FXML
    public void ShowIncompleteClicked(ActionEvent actionEvent) {
        ShowComplete.setSelected(false);
        SortAlphabetical.setSelected(false);
        SortDueDate.setSelected(false);

        if(ShowIncomplete.isSelected()){
            UpdateItemViewer((ToDoList) masterlist.GetIncomplete());
        } else {
            UpdateItemViewer(masterlist);
        }
    }

    @FXML
    public void EditListClicked(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditListScene.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Edit List");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //EDIT LIST CLICKED MENU
    @FXML public TextField TitleTextBox;
    @FXML public Button ListSaveChanges;

    @FXML
    public void ListSaveChangesClicked(){
        String title = TitleTextBox.getText();
        masterlist.setTitle(title);
        UpdateItemViewer(masterlist);
        UpdateListViewer();
        Stage toClose = (Stage) ListSaveChanges.getScene().getWindow();
        toClose.close();
    }

    //NEW ITEM CLICKED MENU
    @FXML public TextField DescriptionTextBox;
    @FXML public DatePicker DueDateBox;
    @FXML public CheckBox CompletedBox;
    @FXML public Button AddItem;

    @FXML
    public void AddItemClicked() {
        String desc = DescriptionTextBox.getText();
        String duedate = DueDateBox.toString();
        boolean status = CompletedBox.isSelected();
        masterlist.AddItem(new Item(desc, duedate, status));
        UpdateItemViewer(masterlist);
        Stage toClose = (Stage) AddItem.getScene().getWindow();
        toClose.close();
    }

    //ITEM "SETTINGS"
    @FXML public CheckMenuItem CompletedToggle;
    @FXML public MenuItem EditItem;
    @FXML public MenuItem DeleteItem;

    @FXML
    public void ToggleCompletedClicked() {
        masterlist.getItem(ItemViewer.getEditingIndex()).setCompleted(CompletedToggle.isSelected());
    }

    @FXML
    public void EditItemClicked() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditItemScene.fxml")));
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Edit Existing Item");
            DescriptionTextBox.setPromptText(masterlist.getItem(ItemViewer.getEditingIndex()).getDescription());
            DueDateBox.setPromptText(masterlist.getItem(ItemViewer.getEditingIndex()).getDuedate());
            CompletedBox.setSelected(masterlist.getItem(ItemViewer.getEditingIndex()).getCompleted());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void DeleteItemClicked() {
        masterlist.DeleteItem(masterlist.getItem(ItemViewer.getEditingIndex()));
        UpdateItemViewer(masterlist);
    }

    //EDIT ITEM CLICKED MENU
    @FXML
    public void SaveChangesClicked() {
        String desc = DescriptionTextBox.getText();
        String duedate = DueDateBox.toString();
        boolean status = CompletedBox.isSelected();
        masterlist.getItem(ItemViewer.getEditingIndex()).setDescription(desc);
        masterlist.getItem(ItemViewer.getEditingIndex()).setDuedate(duedate);
        masterlist.getItem(ItemViewer.getEditingIndex()).setCompleted(status);
        UpdateItemViewer(masterlist);
        Stage toClose = (Stage) AddItem.getScene().getWindow();
        toClose.close();
    }

}
