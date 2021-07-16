package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class ToDoListController {
    SceneManager sceneManager;
    ToDoList masterlist;

    public ToDoListController(SceneManager scmanager){
        this.sceneManager = scmanager;
        masterlist = new ToDoList("My List");
    }

    //---------------------------------------------------------TOOL BAR
    @FXML public MenuItem CloseApp;
    @FXML public MenuItem SaveList;
    @FXML public MenuItem LoadList;
    @FXML public MenuItem DeleteList;
    @FXML public MenuItem Help;

    @FXML public void CloseAppClicked(ActionEvent actionEvent){
        Platform.exit();
    }

    @FXML public void SaveListClicked(ActionEvent actionEvent){
        //todo SaveListClicked
    }

    @FXML public void LoadListClicked(ActionEvent actionEvent){
        //todo LoadlistClicked
    }

    @FXML public void DeleteListClicked(ActionEvent actionEvent){
        //todo DeleteListClicked
    }

    @FXML public void HelpClicked(ActionEvent actionEvent){
        try{
            Stage stage = null;
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
        //todo editItemButtonClicked
    }

    @FXML public void DeleteItemButtonClicked(ActionEvent actionEvent){
        //todo DeleteItemButtonClicked
    }

    //---------------------------------------------------------ADD ITEM PANE
    @FXML public TextArea ItemDescField;
    @FXML public DatePicker DueDateSelector;
    @FXML public CheckBox CompletedButton;
    @FXML public Button AddItemButton;

    @FXML public void AddItemButtonClicked(ActionEvent actionEvent){
        String desc = ItemDescField.getText();
        String date = DueDateSelector.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE);
        boolean status = CompletedButton.isSelected();
        masterlist.addItem(new Item(desc, date, status));
        updateList(masterlist);
    }

    public void updateList(ToDoList list){
        ObservableList<Item> itemObservableList = FXCollections.observableList(masterlist.list);
        ToDoListViewer.setItems(itemObservableList);
        CompletedColumn.setCellValueFactory(new PropertyValueFactory<>("completed"));
        ItemDescColumn.setCellValueFactory(new PropertyValueFactory<>("desc"));
        DueDateColumn.setCellValueFactory(new PropertyValueFactory<>("duedate"));
    }

}
