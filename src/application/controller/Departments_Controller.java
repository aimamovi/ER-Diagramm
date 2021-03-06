package application.controller;

import application.model.Department;
import application.model.Priorities;
import application.model.Status;
import application.model.User;
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
    public Button delete;
    public Button neu;
    public TextField nameTextField;

    public File datei = new File("departments.csv");

    public static ObservableList<Department> dataObeservable =
            FXCollections.observableArrayList();
/*
    public static String getValueString(int valueInt) {
        dataObeservable.setAll(Department.loadList());

        return dataObeservable.get(valueInt - 1).name;
    }
*/
    public void initialize() {
        dataObeservable = Department.loadList();
        listViewDepartments.setItems(dataObeservable);
    }

    public void saveButtonClicked(ActionEvent actionEvent) {

    }

    public void cancelButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void deleteClicked(ActionEvent actionEvent) {
        Department selectedDepartment = (Department) listViewDepartments.getSelectionModel().getSelectedItem();

        nameTextField.clear();
        listViewDepartments.getItems().remove(selectedDepartment);

        selectedDepartment.delete();
    }

    public void newClicked(ActionEvent actionEvent) {
    }
}
