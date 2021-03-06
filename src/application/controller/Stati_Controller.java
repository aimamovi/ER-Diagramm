package application.controller;

import application.model.Department;
import application.model.Priorities;
import application.model.Status;
import javafx.application.Platform;
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

public class Stati_Controller {
    public Button saveStati;
    public Button cancelStati;
    public ListView<Status> listViewStati;
    public Button delete;
    public Button neu;
    public TextField nameTextField;

    public static final ObservableList<Status> dataObeservable =
            FXCollections.observableArrayList();

    public File datei = new File("stati.csv");

    public static String getValueString(int valueInt){
        dataObeservable.setAll(Status.loadList());

        return dataObeservable.get(valueInt - 1).name;
    }

    public void initialize() {
        dataObeservable.setAll(Status.loadList());
        listViewStati.setItems(dataObeservable);

    }

    public void saveButtonClicked(ActionEvent actionEvent) {

    }

    public void cancelButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelStati.getScene().getWindow();
        stage.close();
    }

    public void newClicked(ActionEvent actionEvent) {
    }

    public void deleteClicked(ActionEvent actionEvent) {
        Status selectedStatus = (Status) listViewStati.getSelectionModel().getSelectedItem();

        nameTextField.clear();
        listViewStati.getItems().remove(selectedStatus);

        selectedStatus.delete();
    }
}
