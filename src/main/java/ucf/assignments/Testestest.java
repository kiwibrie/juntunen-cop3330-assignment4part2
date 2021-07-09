package ucf.assignments;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Testestest {
    @FXML
    Button addEventButton;
    @FXML
    TextField descriptionTextBox;
    @FXML
    DatePicker duedatePicker;
    @FXML
    ListView<Item> eventList;

    @FXML
    private void addEventClicked(Event e){
        ToDoList.AddItem(descriptionTextBox.getText(), duedatePicker.getValue());
        eventList.setItems(ToDoList.list);
        descriptionTextBox.clear();
    }
}
