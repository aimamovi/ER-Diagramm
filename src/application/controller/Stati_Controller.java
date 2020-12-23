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

    public static final ObservableList<Status> dataObeservable =
            FXCollections.observableArrayList();

    public File datei = new File("stati.csv");

    public static String getValueString(int valueInt){
        return dataObeservable.get(valueInt - 1).valueSTRING;
    }

    public void initialize() {
        dataObeservable.setAll(Status.loadFile(datei));
        listViewStati.setItems(dataObeservable);

    }

    public void saveButtonClicked(ActionEvent actionEvent) {

    }

    public void cancelButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelStati.getScene().getWindow();
        stage.close();
    }
}
