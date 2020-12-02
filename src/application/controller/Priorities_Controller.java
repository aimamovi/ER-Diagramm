package application.controller;

import application.model.Priorities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Priorities_Controller {
    public ListView<Priorities> priorityListView;
    public Button cancel;
    public Button save;

    public static final ObservableList<Priorities> dataObeservable =
            FXCollections.observableArrayList();

    public File datei = new File("priorities.csv");

    public void initialize() {

        dataObeservable.clear();

        String row = "";
        BufferedReader br = null;
        try {

            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    Priorities a = new Priorities();

                    a.valueINT = Integer.parseInt(data[0]);
                    a.valueSTRING = data[1];
                    dataObeservable.add(a);
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        priorityListView.setItems(dataObeservable);
    }


    public void cancelButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
