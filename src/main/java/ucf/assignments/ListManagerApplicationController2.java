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

    @FXML public MenuItem About;
    @FXML public TextField DirectoryTextBox;
    @FXML public Button SaveOK;
    @FXML public Button CancelButton;

    //---------------------------------------------------------- TOP TOOLBAR
    //FILE
    @FXML
    public void CloseAppClicked(ActionEvent actionEvent) {
        Platform.exit();
    }

    //HELP
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

    public void LoadListClicked(ActionEvent actionEvent) {
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

    public void DeleteListClicked(ActionEvent actionEvent) {
    }

    //---------------------------------------------------------- SAVE SCENE
    public void SaveOKClicked(ActionEvent actionEvent) {
        String path = DirectoryTextBox.getText();
        masterlist.SaveList(path);
    }

    public void CancelClicked(ActionEvent actionEvent) {
        Stage toClose = (Stage) CancelButton.getScene().getWindow();
        toClose.close();
    }

    //---------------------------------------------------------- LOAD SCENE
    public void LoadOKClicked(ActionEvent actionEvent) {
        String path = DirectoryTextBox.getText();

    }
}
