package application.controller;

import application.model.Department;
import application.model.Priorities;
import application.model.Status;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Priorities_Controller {
    public ListView<Priorities> priorityListView;
    public Button cancel;
    public Button save;
    public Button delete;
    public Button neu;
    public TextField nameTextField;

    public static final ObservableList<Priorities> dataObeservable =
            FXCollections.observableArrayList();

    public File datei = new File("priorities.csv");



    public static String getValueString(int valueInt){
        dataObeservable.setAll(Priorities.loadList());
        return dataObeservable.get(valueInt - 1).name;
    }

    public void initialize() {
        dataObeservable.setAll(Priorities.loadList());
        priorityListView.setItems(dataObeservable);
    }

    public void cancelButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void saveButtonClicked(ActionEvent actionEvent) {
        Priorities selectedPriority = (Priorities) priorityListView.getSelectionModel().getSelectedItem();

        if(selectedPriority != null){
            selectedPriority.name = nameTextField.getText();
            priorityListView.refresh();

            selectedPriority.update(); //aktualisiren in datenbank
        }else{
            if(!nameTextField.getText().isEmpty()){
                //Priorities s = new Priorities(count, nameTextField.getText());
            }
        }
    }

    public void newClicked(ActionEvent actionEvent) {
        nameTextField.clear();

        //selectedPriority = null; haben wir noch nicht gemacht i think
    }

    public void deleteClicked(ActionEvent actionEvent) {
        Priorities selectedPriority = (Priorities) priorityListView.getSelectionModel().getSelectedItem();

        nameTextField.clear();
        dataObeservable.remove(selectedPriority);
        priorityListView.setItems(dataObeservable);

        selectedPriority.delete();
    }
}
