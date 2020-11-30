package application.controller;

import application.model.ToString;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Priorities_Controller {
    public ListView<ToString> priorityListView;
    public Button cancel;
    public Button save;

    public static final ObservableList<ToString> dataObeservable =
            FXCollections.observableArrayList();

    public File datei = new File("priorities.csv");

    public void initialize() {

        String row;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    ToString a = new ToString();

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


}
