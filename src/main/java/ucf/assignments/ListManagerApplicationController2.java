package ucf.assignments;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ListManagerApplicationController2 {
    ToDoList masterlist = new ToDoList("My List");

    //---------------------------------------------------------- TOP TOOLBAR
    //FILE
    @FXML public MenuItem CloseApp;
    @FXML
    public void CloseAppClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

    //HELP
    @FXML public MenuItem About;

    @FXML
    public void AboutClicked(ActionEvent actionEvent) {
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

    public void DeleteListClicked(ActionEvent actionEvent) {
        masterlist.ClearList();
        //todo update listviewer
    }

    //---------------------------------------------------------- SAVE SCENE
    @FXML public Button SaveOK;
    @FXML public Button CancelButton;
    @FXML public TextField DirectoryTextBox;

    @FXML
    public void SaveOKClicked(ActionEvent actionEvent) {
        String path = DirectoryTextBox.getText();
        masterlist.SaveList(path);
        //todo update listviewer
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
        //todo update listviewrr
        Stage toClose = (Stage) LoadOK.getScene().getWindow();
        toClose.close();
    }
}
