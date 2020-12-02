package application.controller;

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

    public void initialize() {

        dataObeservable.clear();

        String row;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    Status b = new Status();

                    b.valueINT = Integer.parseInt(data[0]);
                    b.valueSTRING = data[1];
                    dataObeservable.add(b);
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        listViewStati.setItems(dataObeservable);
    }


    public void saveButtonClicked(ActionEvent actionEvent) {

    }

    public void cancelButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelStati.getScene().getWindow();
        stage.close();
    }
}
