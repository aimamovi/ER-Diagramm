package application.controller;

import application.model.Department;
import application.model.User;
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

public class User_Controller {
    public ListView<User> listViewUser;

    public Button save;
    public Button cancel;
    
    public static final ObservableList<User> dataObeservable =
            FXCollections.observableArrayList();

    public File datei = new File("users.csv");

    public void initialize() {

        dataObeservable.clear();

        String row;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    User b = new User();

                    b.valueINT = Integer.parseInt(data[0]);
                    b.titel = data[1];
                    b.name = data[2];
                    b.strase = data[3];
                    b.plz = Integer.parseInt(data[4]);
                    b.ort = data[5];
                    b.abteilung = Integer.parseInt(data[6]);

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

        listViewUser.setItems(dataObeservable);
    }

    public void saveClicked(ActionEvent actionEvent) {
    }

    public void cancelClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
