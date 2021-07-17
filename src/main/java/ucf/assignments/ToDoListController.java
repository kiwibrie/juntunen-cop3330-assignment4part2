package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class ToDoListController {

    SceneManager sceneManager;
    ToDoList masterlist;

    public ToDoListController(){
        this.sceneManager = new SceneManager();
        masterlist = new ToDoList("My List");
    }

    //---------------------------------------------------------TOOL BAR
    @FXML public MenuItem CloseApp;
    @FXML public MenuItem SaveList;
    @FXML public MenuItem LoadList;
    @FXML public MenuItem ClearList;
    @FXML public CheckMenuItem AllItemsMenuItem;
    @FXML public CheckMenuItem OnlyCompletedMenuItem;
    @FXML public CheckMenuItem OnlyIncompletedMenuItem;
    @FXML public MenuItem Help;

    @FXML public void CloseAppClicked(ActionEvent actionEvent){
        Platform.exit();
    }

    @FXML public void SaveListClicked(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            sceneManager.makeScene(stage, "Save List");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void LoadListClicked(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            sceneManager.makeScene(stage, "Load List");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void ClearListClicked(ActionEvent actionEvent){
        masterlist.clearList();
        updateList(masterlist.list);
    }

    @FXML public void ShowAllItemsClicked(ActionEvent actionEvent) {
        OnlyCompletedMenuItem.setSelected(false);
        OnlyIncompletedMenuItem.setSelected(false);
        if(AllItemsMenuItem.isSelected()){
            updateList(masterlist.list);
        }
    }

    @FXML public void OnlyCompleteClicked(ActionEvent actionEvent) {
        AllItemsMenuItem.setSelected(false);
        OnlyIncompletedMenuItem.setSelected(false);
        if(!OnlyCompletedMenuItem.isSelected()){
            updateList(masterlist.list);
            AllItemsMenuItem.setSelected(true);
        } else {
            updateList(masterlist.getComplete());
        }
    }

    @FXML public void OnlyIncompletedClicked(ActionEvent actionEvent) {
        AllItemsMenuItem.setSelected(false);
        OnlyCompletedMenuItem.setSelected(false);
        if(!OnlyIncompletedMenuItem.isSelected()){
            updateList(masterlist.list);
            AllItemsMenuItem.setSelected(true);
        } else {
            updateList(masterlist.getIncomplete());
        }
    }

    @FXML public void HelpClicked(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            sceneManager.makeScene(stage, "Help");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------TODOLIST PANE
    @FXML public MenuItem EditItemContextMenuDesc;
    @FXML public MenuItem DeleteItemContextMenuDesc;
    @FXML public MenuItem EditItemContextMenuDate;
    @FXML public MenuItem DeleteItemContextMenuDate;
    @FXML public TableView<Item> ToDoListViewer;
    @FXML public TableColumn<Boolean, CheckBox> CompletedColumn;
    @FXML public TableColumn<Item, String> ItemDescColumn;
    @FXML public TableColumn<Item, String> DueDateColumn;

    @FXML public void EditItemButtonClicked(ActionEvent actionEvent){
        int itemindex = ToDoListViewer.getSelectionModel().getSelectedIndex();
        ItemDescField.setText(masterlist.getItem(itemindex).getDescription());
        DueDateSelector.setValue(LocalDate.parse(masterlist.getItem(itemindex).getDuedate()));
        CompletedButton.setSelected(masterlist.getItem(itemindex).getCompleted());
        masterlist.deleteItem(masterlist.getItem(itemindex));
    }

    @FXML public void DeleteItemButtonClicked(ActionEvent actionEvent){
        int index = ToDoListViewer.getSelectionModel().getSelectedIndex();
        masterlist.deleteItem(masterlist.getItem(index));
        updateList(masterlist.list);
    }

    //---------------------------------------------------------ADD ITEM PANE
    @FXML public TextArea ItemDescField;
    @FXML public DatePicker DueDateSelector;
    @FXML public CheckBox CompletedButton;
    @FXML public Button AddItemButton;

    @FXML public void AddItemButtonClicked(ActionEvent actionEvent){
        if(validDesc(ItemDescField.getText())){
            if(DueDateSelector.getValue() != null){
                if(validDueDate(DueDateSelector.getValue().toString())){
                    String desc = ItemDescField.getText();
                    String date = DueDateSelector.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE);
                    boolean status = CompletedButton.isSelected();
                    masterlist.addItem(new Item(desc, date, status));
                    updateList(masterlist.list);
                    clearAddItemFields();
                    return;
                }
            }
            validDueDate("bad date");
        }
    }

    public void updateList(List<Item> list){
        ObservableList<Item> itemObservableList = FXCollections.observableList(list);
        ToDoListViewer.setItems(itemObservableList);
        CompletedColumn.setCellValueFactory(new PropertyValueFactory<>("completed"));
        ItemDescColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<>("duedate"));
    }

    public void clearAddItemFields(){
        ItemDescField.clear();
        DueDateSelector.setValue(null);
        CompletedButton.setSelected(false);
    }

    public boolean validDesc(String desc){
        Item item = new Item("falseItem", "1970-01-01", false);
        if(desc == null || !item.verifyDescription(desc)){
            try{
                Stage stage = new Stage();
                sceneManager.makeScene(stage, "Description Error");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    public boolean validDueDate(String date){
        Item item = new Item("falseItem", "1970-01-01", false);
        if(date == null || !item.verifyDueDate(date)){
            try{
                Stage stage = new Stage();
                sceneManager.makeScene(stage, "Date Error");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

    //---------------------------------------------------------ERROR WINDOW
    @FXML public Button ErrorOK;

    @FXML public void ErrorOKClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) ErrorOK.getScene().getWindow();
        stage.close();
    }
}
