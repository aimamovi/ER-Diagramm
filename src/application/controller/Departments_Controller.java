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

public class Departments_Controller {

    public Button save;
    public Button cancel;
    public ListView<Department> listViewDepartments;

    public static final ObservableList<Department> dataObeservable =
            FXCollections.observableArrayList();

    public File datei = new File("departments.csv");

    public void initialize() {

        dataObeservable.clear();

        String row;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(datei));
            try {
                while ((row = br.readLine()) != null) {
                    String[] data = row.split(";");
                    Department b = new Department();

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

        listViewDepartments.setItems(dataObeservable);
    }


    public void saveButtonClicked(ActionEvent actionEvent) {

    }

    public void cancelButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
