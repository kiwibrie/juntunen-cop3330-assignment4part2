package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SceneManager {
    Map<String, String> directory;
    ToDoListController controller;

    public SceneManager(){
        directory = new HashMap<>();
        directory.put("To Do List", "ListManagerApplication.fxml");
        directory.put("Help", "Help.fxml");
        directory.put("Error", "ErrorMessage.fxml");
        this.controller = new ToDoListController(this);
    }

    public void makeScene(Stage stage, String key) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(key))));
        if(stage == null){
            stage = new Stage();
        }
        stage.setScene(scene);
        stage.setTitle(key);
        stage.setResizable(false);
    }


}
