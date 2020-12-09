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

    public File datei = new File("departments.csv");

    public void initialize() {
        listViewDepartments.setItems(Department.loadFile(datei));
    }

    public void saveButtonClicked(ActionEvent actionEvent) {

    }

    public void cancelButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
